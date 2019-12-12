package pl.krakow.uek.pp5.jkan.banking.crm;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ClientData {
    @Id
    String id;

    String firstname;
    String lastname;

    public ClientData() { }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
