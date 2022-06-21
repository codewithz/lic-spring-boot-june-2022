package com.lic.services;

import com.lic.model.Student;
import com.lic.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        List<Student> list=studentRepository.findAll();
        if(!list.isEmpty()){
            return  list;
        }
        else{
            throw new ResponseStatusException( HttpStatus.NOT_FOUND,"Students not found");
        }
    }

    public Student getStudentById(Long id){
        Optional<Student> optional=studentRepository.findById(id);
        if(optional.isPresent()){
            return  optional.get();
        }
        else{
            throw new ResponseStatusException( HttpStatus.NOT_FOUND,"Student with Id:" +id+" not found");
        }
    }

    public String createStudent(Student student){
        Student savedStudent=studentRepository.save(student);
        if(savedStudent!=null){
            return "Success";
        }
        else{
            throw new ResponseStatusException( HttpStatus.NOT_FOUND,"Student creation failed");
        }
    }

    public String updateStudent(Student student,Long id) {

        boolean exists = studentRepository.existsById(id);
        if (exists) {
            student.setId(id);
            Student savedStudent = studentRepository.save(student);
            if (savedStudent != null) {
                return "Success";
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student updation failed");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with Id:" + id + " not found");
        }
    }

        public String deleteStudent(Long id){

            boolean exists=studentRepository.existsById(id);
            if(exists) {
                studentRepository.deleteById(id);

                    return "Success";
                }

            else{
                throw new ResponseStatusException( HttpStatus.NOT_FOUND,"Student with Id:" +id+" not found");
            }
    }
}
