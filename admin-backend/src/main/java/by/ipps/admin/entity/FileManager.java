package by.ipps.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FileManager extends BaseEntity implements Serializable {

  private String fileName;
  private String fileMine;
  private byte[] file;
  private byte[] realize;
  private long size;

  public FileManager(long mainImage) {
    this.id = mainImage;
  }

  public FileManager(String originalFilename, String contentType, byte[] bytes) {
    this.fileName = originalFilename;
    this.fileMine = contentType;
    this.file = bytes;
    this.realize = null;
  }
}
