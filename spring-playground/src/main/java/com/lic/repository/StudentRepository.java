package com.lic.repository;

import com.lic.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public Optional<Student> findStudentByEmail(String email);

    public List<Student> findStudentsByFirstNameAndAgeGreaterThanEqual(String name, Integer age);

    public List<Student> findStudentsByFirstNameOrAgeGreaterThanEqual(String name, Integer age);

    @Query("SELECT s FROM Student s WHERE s.email=?1")
    public Optional<Student> selectStudentByEmail(String email);

    @Query("Select s FROM Student s WHERE s.firstName=:firstName AND s.age>=:age")
    public List<Student>
    selectStudentWithFirstNameAndAgeGreaterOrEquals(@Param("firstName") String name,
                                                    @Param("age") Integer age);

    @Query(value = "Select * FROM student WHERE first_name=:firstName AND age>=:age",
            nativeQuery = true)
    public List<Student>
    selectStudentWithFirstNameAndAgeGreaterOrEqualsNative(@Param("firstName") String name,
                                                    @Param("age") Integer age);
}
