package edu.miu.cs.cs425.lab9.eregistrarwebapi.repository;

import edu.miu.cs.cs425.lab9.eregistrarwebapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

/**
 * @author duong at 7/2/21
 * @project eRegistrar
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByStudentNumberLike(String keyword);
}
