package com.javaguides.springbootbackendcrudapp;

import com.javaguides.springbootbackendcrudapp.model.Student;
import com.javaguides.springbootbackendcrudapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendCrudappApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendCrudappApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {

		Student student = new Student();

		student.setFirstName("max");
		student.setLastName("nay");
		student.setEmailId("nay@gmail.com");
		student.setRegNumber("1234");
		studentRepository.save(student);


		Student student1 = new Student();

		student1.setFirstName("mac");
		student1.setLastName("afro");
		student1.setEmailId("afro@gmail.com");
		student1.setRegNumber("1235");
		studentRepository.save(student1);
	}
}
