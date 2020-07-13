package by.ipps.client.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Partners extends BaseEntity implements Serializable {

    private String name;
    private long image;
    private String url;

    public void setImage(BaseEntity image) {
        this.image = image.getId();
    }
}
