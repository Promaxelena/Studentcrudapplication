package com.javaguides.springbootbackendcrudapp.repository;

import com.javaguides.springbootbackendcrudapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
