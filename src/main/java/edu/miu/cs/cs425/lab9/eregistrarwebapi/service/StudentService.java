package edu.miu.cs.cs425.lab9.eregistrarwebapi.service;

import edu.miu.cs.cs425.lab9.eregistrarwebapi.model.Student;

import java.util.*;

/**
 * @author duong at 7/2/21
 * @project eRegistrar
 */
public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    void deleteStudent(Long studentId);
    Optional<Student> getStudentById(Long studentId);
    List<Student> findStudentsByKeyword(String keyword);
}
