package by.ipps.dao.controller;

import by.ipps.dao.controller.base.BaseEntityAbstractController;
import by.ipps.dao.controller.base.BaseEntityController;
import by.ipps.dao.dto.contact.ContactForClient;
import by.ipps.dao.dto.contact.InfoContact;
import by.ipps.dao.dto.contact.PositionContact;
import by.ipps.dao.dto.contact.UserForContact;
import by.ipps.dao.entity.*;
import by.ipps.dao.service.ContactService;
import by.ipps.dao.service.DepartmentService;
import by.ipps.dao.service.LoggerService;
import by.ipps.dao.utils.view.ViewContact;
import com.fasterxml.jackson.annotation.JsonView;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController extends BaseEntityAbstractController<Contact, ContactService>
    implements BaseEntityController<Contact> {

  private DepartmentService departmentService;

  protected ContactController(
      ContactService contactService,
      DepartmentService departmentService,
      ModelMapper modelMapper,
      LoggerService loggerService) {
    super(contactService, modelMapper, loggerService);
    this.departmentService = departmentService;
  }

  @GetMapping(value = "/client")
  @ResponseBody
  public ResponseEntity<List<ContactForClient>> getContactForClient(
      @SortDefault.SortDefaults({
            @SortDefault(sort = "code", direction = Sort.Direction.ASC),
          })
              Sort sort) {
    List<Department> contactList = departmentService.findAll(sort);
    List<ContactForClient> list = new ArrayList<>();
    for (Department department : contactList) {
      List<UserForContact> users = new ArrayList<>();
      for (UserPortal userPortal : department.getUsers()) {
        UserForContact userForContact =
            new UserForContact(
                userPortal.getId(),
                userPortal.getName(),
                userPortal.getPatronicName(),
                userPortal.getSurName(),
                userPortal.getRoom(),
                userPortal.getPhone(),
                userPortal.getEmail());
        Contact contact = this.baseEntityService.findByUser(userPortal);
        userForContact.setContact(this.modelMapper.map(contact, InfoContact.class));
        if (department.getPositions().isEmpty()) {
          userForContact.setPositions(null);
        } else if (department.getPositions().size() == 1) {
          userForContact.setPositions(
              contact.getPosition() != null
                  ? this.modelMapper.map(department.getPositions().get(0), PositionContact.class)
                  : null);
        } else {
          for (Position position : userPortal.getPositions())
            userForContact.setPositions(
                contact.getPosition() != null
                    ? this.modelMapper.map(
                        department.getPositions().get(department.getPositions().indexOf(position)),
                        PositionContact.class)
                    : null);
        }
        users.add(userForContact);
      }

      list.add(new ContactForClient(department.getId(), department.getName(), users));
    }
    return new ResponseEntity<>(list, HttpStatus.OK);
  }

  @Override
  @JsonView(ViewContact.BaseClass.class)
  public ResponseEntity<Contact> get(Long id, String language, Sheet sheet, Department department) {
    return super.get(id, language, sheet, department);
  }

  @Override
  public ResponseEntity<Contact> create(Contact entity, UserPortal userPortal) {
    return super.create(entity, userPortal);
  }

  @Override
  @JsonView(ViewContact.BaseClass.class)
  public ResponseEntity<Contact> update(Contact entity, UserPortal userPortal) {
    return super.update(entity, userPortal);
  }

  @Override
  public ResponseEntity<Boolean> remove(Contact id, UserPortal userPortal) {
    return super.remove(id, userPortal);
  }

  @Override
  @JsonView(ViewContact.BaseClass.class)
  public ResponseEntity<Page<Contact>> getAll(
          Pageable pageable, String language, Sheet sheet, Department department) {
    return super.getAll(pageable, language, sheet, department);
  }

  @Override
  @JsonView(ViewContact.BaseClass.class)
  public ResponseEntity<List<Contact>> getAll(Sort sort) {
    return super.getAll(sort);
  }
}
