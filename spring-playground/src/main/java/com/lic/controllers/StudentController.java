package com.lic.controllers;

import com.lic.config.ApiSuccessPayload;
import com.lic.model.Student;
import com.lic.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<ApiSuccessPayload> getAllStudents(){
        List<Student> list=studentService.getAllStudents();
        ApiSuccessPayload payload=ApiSuccessPayload.build(list,"Students List Found", HttpStatus.OK);
        ResponseEntity<ApiSuccessPayload> response=new ResponseEntity(payload,HttpStatus.OK);
        return response;
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<ApiSuccessPayload> getStudetById(@PathVariable Long studentId){
        Student student=studentService.getStudentById(studentId);
        ApiSuccessPayload payload=ApiSuccessPayload.build(student,"Student  Found", HttpStatus.OK);
        ResponseEntity<ApiSuccessPayload> response=new ResponseEntity(payload,HttpStatus.OK);
        return response;
    }

    @PostMapping()
    public ResponseEntity<ApiSuccessPayload> createStudent(@RequestBody Student student){
        String result= studentService.createStudent(student);
        ApiSuccessPayload payload=ApiSuccessPayload.build(result,result, HttpStatus.CREATED);
        ResponseEntity<ApiSuccessPayload> response=new ResponseEntity(payload,HttpStatus.CREATED);
        return response;
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<ApiSuccessPayload> createStudent(@RequestBody Student student,@PathVariable Long studentId){
        String result= studentService.updateStudent(student,studentId);
        ApiSuccessPayload payload=ApiSuccessPayload.build(result,result, HttpStatus.CREATED);
        ResponseEntity<ApiSuccessPayload> response=new ResponseEntity(payload,HttpStatus.CREATED);
        return response;
    }
    @DeleteMapping("/{studentId}")
    public ResponseEntity<ApiSuccessPayload> createStudent(@PathVariable Long studentId){
        String result= studentService.deleteStudent(studentId);
        ApiSuccessPayload payload=ApiSuccessPayload.build(result,result, HttpStatus.CREATED);
        ResponseEntity<ApiSuccessPayload> response=new ResponseEntity(payload,HttpStatus.CREATED);
        return response;
    }


}
