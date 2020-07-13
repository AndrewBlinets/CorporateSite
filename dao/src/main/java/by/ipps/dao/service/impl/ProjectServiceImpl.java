package by.ipps.dao.service.impl;

import by.ipps.dao.entity.Department;
import by.ipps.dao.entity.Project;
import by.ipps.dao.entity.Sheet;
import by.ipps.dao.repository.*;
import by.ipps.dao.service.ProjectService;
import by.ipps.dao.service.base.BaseEntityServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl extends BaseEntityServiceImpl<Project, ProjectRepository>
    implements ProjectService {

  public ProjectServiceImpl(ProjectRepository repository) {
    super(repository);
  }

  @Override
  public Page<Project> findProjectPageBySectionAndDepartment(
      Sheet section, Department department, Pageable pageable) {
    return repository.findProjectPageBypageAndDepartment(section, department, pageable);
  }

  @Override
  public Page<Project> findProjectPageBySectionAndDepartmentForAdmin(
      Sheet section, Department department, Pageable pageable) {
    return repository.findProjectPageBypageAndDepartmentForAdmin(section, department, pageable);
  }

  @Override
  public Project findByIdAndPublicForCustomer(long project) {
    return repository.findByIdAndStatusRAndPublicForCustomer(project, "A", true).orElse(null);
  }

  @Override
  public List<Project> findAllPublicForCustomer() {
    return repository.findAllByPublicForCustomer(true);
  }

  @Override
  public Page<Project> findProjectPageDepartmentId(List<Long> departments, Pageable pageable) {
    return repository.findProjectPageAndDepartment(departments, pageable);
  }

  @Override
  public Project findByIdAndSectionAndDepartmentForClient(
      Long id, Sheet section, Department department) {
    return repository
        .findByIdAndSectionAndDepartmentForClient(id, section, department)
        .orElse(null);
  }

  @Override
  public Project findByIdAndSectionAndDepartment(Long id, Sheet section, Department department) {
    return repository.findByIdAndSectionAndDepartment(id, section, department).orElse(null);
  }
}
