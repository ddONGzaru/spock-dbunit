package io.manasobi.jpa;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by twjang on 15. 9. 6.
 */
@Entity
public class Person implements Serializable {

    @Id
    @Column(name = "PERSON_ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
