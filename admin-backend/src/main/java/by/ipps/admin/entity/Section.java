package by.ipps.admin.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Section extends BaseEntity implements Serializable {
  private List<SectionLanguageVersion> languageVersions;
  private int type;
  private int index;
  private int status;
  private List<Long> files;
  private long page;
  private String name;

  public void setFiles(List<FileManager> files) {
    if (files != null) {
      this.files = new ArrayList<>();
      for (FileManager fileManager : files) {
        this.files.add(fileManager.getId());
      }
    }
  }

  public void setBlocks(List<Block> blocks) {
    for (Block block : blocks) {
      for (BlockLanVer blockLanVer : block.getLanguageVersions())
        for (SectionLanguageVersion languageVersion : this.languageVersions) {
          if (blockLanVer.getCodeLanguage().equals(languageVersion.getCodeLanguage())) {
            if (languageVersion.getBlocks() == null) {
              languageVersion.setBlocks(new ArrayList<>());
            }
            languageVersion
                .getBlocks()
                .add(
                    new BlockForFront(
                        block.getId(),
                        block.getIndex(),
                        blockLanVer.getContent(),
                        blockLanVer.getId()));
          }
        }
    }
  }
}
