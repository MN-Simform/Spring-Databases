package com.example.SpringDatabase.SpringDbDemo;

import com.example.SpringDatabase.SpringDbDemo.entity.Person;
import com.example.SpringDatabase.SpringDbDemo.jdbc.PersonJdbcDAO;
import com.example.SpringDatabase.SpringDbDemo.jpa.PersonJpa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(JpaDemoApplication.class);
	@Autowired
	PersonJpa jpa;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Record of Id 10001 : {}", jpa.findById(10001));
		logger.info("Inserting Record : {}", jpa.insert(new Person("Niim", "Amreli", new Date())));
		logger.info("Updating Record : {}", jpa.update(new Person(10003, "Nimit", "Khambha", new Date())));
		jpa.delete(10002);
		logger.info("All Records : {}", jpa.findAllData());



	}
}
