package io.manasobi.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by twjang on 15. 9. 6.
 */
public interface PersonRepositories extends JpaRepository<Person, Long>, QueryDslPredicateExecutor<Person> {


}
