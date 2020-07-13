package by.ipps.client.entity.contact;

import by.ipps.client.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForContact extends BaseEntity implements Serializable {
    private String name;
    private String patronicName;
    private String surName;
    private String room;
    private String phone;
    private String email;
    private PositionContact positions;
    private InfoContact contact;

    public UserForContact(
            long id,
            String name,
            String patronicName,
            String surName,
            String room,
            String phone,
            String email) {
        super(id);
        this.name = name;
        this.patronicName = patronicName;
        this.surName = surName;
        this.room = room;
        this.phone = phone;
        this.email = email;
    }
}
