package com.example.SpringDatabase.SpringDbDemo;

import com.example.SpringDatabase.SpringDbDemo.entity.Person;
import com.example.SpringDatabase.SpringDbDemo.jpa.PersonJpa;
import com.example.SpringDatabase.SpringDbDemo.springData.PersonDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(SpringDataDemoApplication.class);
	@Autowired
	PersonDataRepository jpa;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Record of Id 10001 : {}", jpa.findById(10001));
		logger.info("Inserting Record : {}", jpa.save(new Person("Niim", "Amreli", new Date())));
		logger.info("Updating Record : {}", jpa.save(new Person(10003, "Nimit", "Khambha", new Date())));
		jpa.deleteById(10002);
		logger.info("All Records : {}", jpa.findAll());
	}
}
