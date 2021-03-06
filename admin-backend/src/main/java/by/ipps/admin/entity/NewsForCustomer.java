package by.ipps.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsForCustomer extends BaseEntity {
//    @JsonProperty("dat")
    private Date dti;
    private String title;
    private String content;
    private String shortTitle;
    private ProjectDtoAdmin project;
    private Page sheet;
}
