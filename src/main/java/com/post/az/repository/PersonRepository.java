package com.post.az.repository;

import com.post.az.entity.IdCard;
import com.post.az.entity.Person;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT c FROM Person c where c.age > :age")
        // JPQL
    List<Person> getPersonByAgeGreaterThanTwenty(@Param("age") String age);


    @Query(value = "SELECT * FROM person p where p.name = :name ", nativeQuery = true)
        // Native Query
    List<Person> getDataByName(@Param("name") String name);

    @Query(value = "UPDATE person SET name = :newName where id = :id", nativeQuery = true)
    @Modifying(clearAutomatically = true)
    @Transactional
        // Native query, Update Statement
    void updatePersonName(@Param("newName") String newName, @Param("id") Long id);

    @Query(value = "SELECT p FROM Person p")
    @EntityGraph(value = "Person.address", type = EntityGraph.EntityGraphType.FETCH)
    List<Person> getALlDAta();

    @Query(value = "SELECT p FROM Person p where p.idCard = :idCard")
    Person findByIdCard(@Param("idCard") IdCard idCard);

    @Query(value = "UPDATE Person SET balance = :balance where idCard = :idCard ")
    @Modifying
    @Transactional
    void updateBalance(@Param("balance") long balance, @Param("idCard") IdCard idCard);

    @Query(value = "SELECT p FROM Person p WHERE p.id = :id ")
    @Lock(LockModeType.PESSIMISTIC_READ)
    Person getByPersonId(Long id);


    Person getDataById(Long id);
}
