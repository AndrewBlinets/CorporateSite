package by.ipps.client.controller;

import by.ipps.client.entity.ElectronicAppeal;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RestController
@RequestMapping("/api/electronicAppeal")
@Log4j2
@CrossOrigin
public class ElectronicAppealController {

  private final JavaMailSender emailSender;

  public ElectronicAppealController(JavaMailSender emailSender) {
    this.emailSender = emailSender;
  }

  @PostMapping(consumes = {"multipart/form-data"})
  public ResponseEntity send(@ModelAttribute ElectronicAppeal electronicAppeal)
      throws MessagingException {
    MimeMessage message = emailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message, true);
    StringBuilder stringBuilder = new StringBuilder();
    if (electronicAppeal.getName() != null)
      stringBuilder.append("Имя: \"").append(electronicAppeal.getName()).append("\"\n");
    if (electronicAppeal.getFulNameUr() != null)
      stringBuilder
          .append("Фамилия юр лица: \"")
          .append(electronicAppeal.getFulNameUr())
          .append("\"\n");
    if (electronicAppeal.getAddress() != null)
      stringBuilder.append("Адресс: \"").append(electronicAppeal.getAddress()).append("\"\n");
    if (electronicAppeal.getEmail() != null)
      stringBuilder
          .append("Адресс электронной почты: \"")
          .append(electronicAppeal.getEmail())
          .append("\"\n");
    if (electronicAppeal.getJurName() != null)
      stringBuilder.append("Имя юр лица: \"").append(electronicAppeal.getJurName()).append("\"\n");
    if (electronicAppeal.getPostcode() != null)
      stringBuilder.append("Индекс: \"").append(electronicAppeal.getPostcode()).append("\"\n");
    if (electronicAppeal.getTextAppeal() != null)
      stringBuilder
          .append("Текст обращения: \"")
          .append(electronicAppeal.getTextAppeal())
          .append("\"\n");
    try {
      for (MultipartFile file : electronicAppeal.getFile()) {
        helper.addAttachment(file.getOriginalFilename(), file);
      }
      log.info(electronicAppeal.getFile()[0].getOriginalFilename());
    } catch (NullPointerException ignore) {
    }
    helper.setText(stringBuilder.toString(), true);
    helper.setFrom("web@ipps.by");
    helper.setTo("info@ipps.by");
    helper.setSubject("Электронное обращение граждан");
    log.info(electronicAppeal.toString());
    emailSender.send(message);
    return new ResponseEntity(HttpStatus.OK);
  }
}
