package com.javaguides.springbootbackendcrudapp.controller;

import com.javaguides.springbootbackendcrudapp.exception.ResourceNotFoundException;
import com.javaguides.springbootbackendcrudapp.model.Student;
import com.javaguides.springbootbackendcrudapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;


    @GetMapping
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }


    // create API

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);

    }
    // create read API ById

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id){
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not exist with id:" + id));
        return ResponseEntity.ok(student);
    }
    // update API



    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody Student studentDetails){

        Student updateStudent = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not exist with id:" + id));

        updateStudent.setFirstName(studentDetails.getFirstName());
        updateStudent.setLastName(studentDetails.getLastName());
        updateStudent.setEmailId(studentDetails.getEmailId());
        updateStudent.setRegNumber(studentDetails.getRegNumber());

        studentRepository.save(updateStudent);
        return ResponseEntity.ok(updateStudent);
    }
    // delete API

    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable long id){
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("student not exist with id:" + id));

        studentRepository.delete(student);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
