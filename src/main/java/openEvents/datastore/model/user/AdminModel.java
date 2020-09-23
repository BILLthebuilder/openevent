package openEvents.datastore.model.user;

import openEvents.datastore.model.util.BaseUserEntity;
import openEvents.datastore.model.util.Person;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;


@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "admin")
public class AdminModel extends BaseUserEntity {

    @Embedded
    Person admin;

    public Person getAdmin() {
        return admin;
    }

    public void setAdmin(Person admin) {
        this.admin = admin;
    }

}
