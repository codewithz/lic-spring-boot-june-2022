package com.lic.repository;

import com.lic.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public Optional<Student> findStudentByEmail(String email);

    public List<Student> findStudentsByFirstNameAndAgeGreaterThanEqual(String name, Integer age);

    public List<Student> findStudentsByFirstNameOrAgeGreaterThanEqual(String name, Integer age);
}
