package io.manasobi.jpa;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by twjang on 15. 9. 6.
 */
@Repository
public class PersonRepo extends QueryDslRepositorySupport {

    public PersonRepo() {
        super(Person.class);
    }

    /**
     * Creates a new {@link QueryDslRepositorySupport} instance for the given domain type.
     *
     * @param person must not be {@literal null}.
     */
    public PersonRepo(Class<Person> person) {
        super(person);
    }

    public Iterable<Person> findAll(String firstName) {

        QPerson person = QPerson.person;

        return from(person).where(person.firstName.eq(firstName)).list(person);

    }

}
