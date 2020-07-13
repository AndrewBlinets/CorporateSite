package by.ipps.client.entity.contact;

import by.ipps.client.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactForClient extends BaseEntity {
    private String name;
    private List<UserForContact> users;

    public ContactForClient(long id, String name, List<UserForContact> users) {
        this.setId(id);
        this.name = name;
        this.users = users;
    }
}
