package vn.proj.spring.studentmanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.proj.spring.studentmanage.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
