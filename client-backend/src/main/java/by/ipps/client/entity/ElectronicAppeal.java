package by.ipps.client.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElectronicAppeal {
  private int type; // 1- fiz, 2 - ur
  private String name;
  private String email;
  private String address;
  private String textAppeal;
  private MultipartFile[] file;
  private String fulNameUr;
  private String postcode;
  private String jurName;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ElectronicAppeal{");
        sb.append("type=").append(type);
        sb.append(", fio='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", addr='").append(address).append('\'');
        sb.append(", message='").append(textAppeal).append('\'');
        sb.append(", fulNameUr='").append(fulNameUr).append('\'');
        sb.append(", index='").append(postcode).append('\'');
        sb.append(", fulName='").append(jurName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
