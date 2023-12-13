package in.co.vwits.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.co.vwits.sms.model.Student;

//JPA repository gives us lot of built-in methods for CRUD operaions 
//which we don't have to implement at all
public interface StudentRepository extends JpaRepository<Student, Integer>{
	//but also we have freedom of writing our custom methods like below.
	//we just have to declare custom methods, but we don't have to define them.
	//but for our custom methods we have to write JPQL on top of respective
	//custom method.
	//This is done using @Query annotation.
	
	@Query("SELECT DISTINCT s FROM Student AS s LEFT JOIN FETCH s.subjectsLearning")
    List<Student> findAllWithSubjects();
	
	@Query("FROM Student AS s LEFT JOIN FETCH s.subjectsLearning WHERE s.rollno = :rno")
    Student findOneWithSubjectsLearning(@Param(value="rno") int rollno);
}
