package si.fri.rso.models.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Customer extends BaseEntity {

    private String firstName;
    private String lastName;
    private String mail;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setName(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getName() { return this.firstName + " " + this.lastName; }

}
