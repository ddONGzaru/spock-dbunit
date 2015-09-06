package io.manasobi.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by twjang on 15. 9. 6.
 */
@Entity
public class Person {

    @Column(name = "FIRST_NAME")
    String firstName;

    @Column(name = "LAST_NAME")
    String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
