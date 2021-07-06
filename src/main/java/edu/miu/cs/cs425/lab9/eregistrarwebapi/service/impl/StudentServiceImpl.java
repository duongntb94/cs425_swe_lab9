package edu.miu.cs.cs425.lab9.eregistrarwebapi.service.impl;

import edu.miu.cs.cs425.lab9.eregistrarwebapi.model.Student;
import edu.miu.cs.cs425.lab9.eregistrarwebapi.repository.StudentRepository;
import edu.miu.cs.cs425.lab9.eregistrarwebapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author duong at 7/2/21
 * @project eRegistrar
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll(Sort.by("firstName"));
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Optional<Student> getStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public List<Student> findStudentsByKeyword(String keyword) {
        return studentRepository.findByStudentNumberLike(keyword);
    }
}
