package in.co.vwits.sms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import in.co.vwits.model.Exception.StudentNotFoundException;
import in.co.vwits.sms.model.Student;

public interface StudentService {

	//This is single line comment
	/*
	 * This is MultiLine comment
	 */
	/**
	 * This is Documentation comment
	 * Finds all the student details who scored more than given percentage
	 * @param percentage
	 * @return java.util.List<Student>
	 */
	List<Student> findAllStudentsScoredMoreThanGivenPercentage(double percentage);

	List<Student> findAllStudentsScoredMoreThanGivenPercentageInLessThanGivenAttempts(double percentage, int attempts);

	long findTotalCountStudentsNamesStartsWithNameStarting(char c);

	//Printing students in descending order based on their percentages
	List<Student> findAllStudentsSortedByPercentage();

	//Printing only the names of students who scored more than given percentage
	List<String> findAllStudentNamesWhoScoredMoreThanGivenPercentage(double percentage);

	//Print students who is learning same subject
	List<Student> findAllStudentsLearningSpecificSubject(String subject);

	//Students who born after specific date
	List<Student> findAllStudentsWhoBornAfterSpecificDate(LocalDate SpecificDate);

	//count of students who are born after specific date
	long countAllStudentsWhoBornAfterSpecificDate(LocalDate SpecificDate);

	//List of students who are born between specified range of date
	List<Student> findAllStudentsWhoBornBetweenSpecificDate(LocalDate startDate, LocalDate endDate);

	//Partition of students based on marks
	Map<Boolean, List<Student>> partiotioningStudentsBasedOnMarks(double marks);

	//Count of all unique subjects learn by all students
	long countOfTotalUniqueSubjectsLearntByAllStudents();

	//ReadAll
	List<Student> findAll();

	//create 
	void save(Student s);

	//Find student by specific roll no
	Optional<Student> findByRollno(int rollno) throws StudentNotFoundException;

	////Delete student by specific roll no
	void deleteByRollno(int rollno);

	//Update student data by specified roll no
//	void updateByRollno(int rollno, double modifiedPercentage);

	//Update student data by specified roll no
	void updateStudentByRollno(Student s);
	
	List<Student> findAllWithSubjects();
	
    Student findOneWithSubjectsLearning(int roll);
	

}