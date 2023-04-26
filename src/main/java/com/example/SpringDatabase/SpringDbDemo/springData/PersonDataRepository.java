package com.example.SpringDatabase.SpringDbDemo.springData;

import com.example.SpringDatabase.SpringDbDemo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDataRepository extends JpaRepository<Person, Integer> {

}
