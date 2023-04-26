package com.example.SpringDatabase.SpringDbDemo.jpa;

import com.example.SpringDatabase.SpringDbDemo.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class PersonJpa {

    @PersistenceContext
    EntityManager entityManager;

    public List<Person> findAllData(){
        TypedQuery<Person> namedQuery =  entityManager.createNamedQuery("find_all_data", Person.class);
        return namedQuery.getResultList();
    }
    public Person findById(int id){
        return entityManager.find(Person.class, id);
    }

    public Person update(Person person){
        return entityManager.merge(person);
    }

    public Person insert(Person person){
        return entityManager.merge(person);
    }

    public void delete(int id){
        Person person = findById(id);
        entityManager.remove(person);
    }
}
