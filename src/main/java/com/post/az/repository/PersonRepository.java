package com.post.az.repository;

import com.post.az.dto.PersonDTO;
import com.post.az.entity.Person;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT c FROM Person c where c.age > :age")
        // JPQL
    List<Person> getPersonByAgeGreaterThanTwenty(@Param("age") String age);


    @Query(value = "SELECT * FROM person p where p.name = :name ", nativeQuery = true)
        // Native Query
    List<Person> getData(@Param("name") String name);

    @Query(value = "UPDATE person SET name = :newName where id = :id", nativeQuery = true)
    @Modifying(clearAutomatically = true)
    @Transactional
        // Native query, Update Statement
    void updatePersonName(@Param("newName") String newName, @Param("id") Long id);

    @Query(value = "SELECT p FROM Person p")
    @EntityGraph(value = "Person.address", type = EntityGraph.EntityGraphType.FETCH)
    List<Person> getALlDAta();


}
