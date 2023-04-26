package com.example.SpringDatabase.SpringDbDemo;

import com.example.SpringDatabase.SpringDbDemo.entity.Person;
import com.example.SpringDatabase.SpringDbDemo.jdbc.PersonJdbcDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(SpringJdbcDemoApplication.class);
	@Autowired
	PersonJdbcDAO dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All Records : {}", dao.finalAll());
		logger.info("Record of Id 10001 : {}", dao.findById(10001));
		logger.info("Record Of Name Nimit : {}", dao.findByName("Nimit"));
		logger.info("Number Of Record Deleted : {}", dao.deleteById(10002));
		logger.info("Delete Record By Id And NAme : {}", dao.deleteByIdAndName(10003,"MN"));
		logger.info("Inserting Record : {} ", dao.insertPerson(new Person(10004, "Sim", "Amreli", new Date())));
		logger.info("Inserting Record : {} ", dao.insertPerson(new Person(10005, "Sim", "Amreli", new Date())));
		logger.info("Updating Record : {}", dao.updatePerson(new Person(10005,"Simlo", "Amreli", new Date())));

	}
}
