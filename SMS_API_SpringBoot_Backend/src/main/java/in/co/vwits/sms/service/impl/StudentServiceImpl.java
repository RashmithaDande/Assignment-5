package in.co.vwits.sms.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.vwits.model.Exception.StudentNotFoundException;
import in.co.vwits.sms.model.Student;
import in.co.vwits.sms.repository.StudentRepository;
import in.co.vwits.sms.service.StudentService;

@Service //Used for annotation of service class
@Transactional //this annotation instructs spring framework to invoke all methods of this class in transaction
public class StudentServiceImpl implements StudentService {
    //using reference of interface to communicate with other layer of application is known as "Coding to Interface".
    //"Coding to Interface" is best practice as it gives loose coupling among layers.
	@Autowired
	private StudentRepository repo;

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
	@Override
	public List<Student> findAllStudentsScoredMoreThanGivenPercentage(double percentage){
		return repo.findAll().stream()
				.filter(student -> student.getPercentage()> percentage)
				.collect(Collectors.toList());
	}

	/**
	 * Finds all the students who scored more than given percentage and less 
	 * than given attempts.
	 * @param percentage
	 * @param attempts
	 * @return java.util.List<Student>
	 */
	@Override
	public List<Student> findAllStudentsScoredMoreThanGivenPercentageInLessThanGivenAttempts(double percentage, int attempts){
		return repo.findAll().stream()
				.filter(student -> student.getPercentage()> percentage) 
				.filter(student -> student.getNumberOfAttempts()< attempts)
				.collect(Collectors.toList());

	}

	/**
	 * Count of students whose name starts with specifies character
	 * @param c
	 * @return 
	 */
	@Override
	public long findTotalCountStudentsNamesStartsWithNameStarting(char c){
		return repo.findAll().stream()
				.filter(student -> student.getName().charAt(0) == c)
				.count();
	}

	//Printing students in descending order based on their percentages
	@Override
	public List<Student> findAllStudentsSortedByPercentage(){
		return repo.findAll().stream().sorted().collect(Collectors.toList());
	}

	//Printing only the names of students who scored more than given percentage
	@Override
	public List<String> findAllStudentNamesWhoScoredMoreThanGivenPercentage(double percentage){
		return repo.findAll().stream()
				.filter(student->student.getPercentage()>percentage)
				//.map(student->student.getName())
				.map(Student::getName)//49 and 50 same but in 50 we r using method reference
				.collect(Collectors.toList());
	}

	//Print students who is learning same subject
	@Override
	public List<Student> findAllStudentsLearningSpecificSubject(String subject){
		return repo.findAll().stream()
				.filter(student->student.getSubjectsLearning().stream().anyMatch(sub->sub.contains(subject)))			
				.collect(Collectors.toList());
	}
    
	//Students who born after specific date
	@Override
	public List<Student> findAllStudentsWhoBornAfterSpecificDate(LocalDate SpecificDate){
		return repo.findAll().stream()
				.filter(student -> student.getDateOfBirth().isBefore(SpecificDate))
				.collect(Collectors.toList());
	}
     
	//count of students who are born after specific date
	@Override
	public long countAllStudentsWhoBornAfterSpecificDate(LocalDate SpecificDate){
		return repo.findAll().stream()
				.filter(student -> student.getDateOfBirth().isAfter(SpecificDate))
				.count();
	}
    
	//List of students who are born between specified range of date
	@Override
	public List<Student> findAllStudentsWhoBornBetweenSpecificDate(LocalDate startDate, LocalDate endDate){
		return repo.findAll().stream()
				.filter(student -> student.getDateOfBirth().isAfter(startDate))
				.filter(student->student.getDateOfBirth().isBefore(endDate))
				.collect(Collectors.toList());
	}
	
	//Partition of students based on marks
	@Override
	public Map<Boolean, List<Student>> partiotioningStudentsBasedOnMarks(double marks){
		return repo.findAll().stream().collect(Collectors.partitioningBy(s->s.getPercentage()> marks));
	}
	
	//Count of all unique subjects learn by all students
	@Override
	public long countOfTotalUniqueSubjectsLearntByAllStudents() {
		return repo.findAll().stream().flatMap(s->s.getSubjectsLearning().stream()).distinct().count();	
	}

	//ReadAll
	@Override
	public List<Student>findAll(){
		return repo.findAll();//repo.findAll(),save() all these are built in methods
	}
	//create 
	@Override
	public void save(Student s) {
		repo.save(s);
	}

	//Find student by specific roll no
	@Override
	public Optional<Student> findByRollno(int rollno) throws StudentNotFoundException {
		Optional<Student> p = repo.findById(rollno);
		if(p.isPresent()) {
			return p;
		}
		else {
			//throw user defined exception "StudentNotFound".
			throw new StudentNotFoundException(); 
		}

	}
	
	//Delete student by specific roll no
	@Override
	public void deleteByRollno(int rollno) {
		repo.deleteById(rollno);

	}
	//Update student data by specified roll no
//	@Override
	public void updateByRollno(int rollno, double modifiedPercentage) {
//		repo.updateByRollno(rollno,modifiedPercentage);
//				
//        
	}

	@Override
	public void updateStudentByRollno(Student s) {
		this.repo.save(s);
		
	}

	@Override
	public List<Student> findAllWithSubjects() {
		return this.repo.findAllWithSubjects();
		
	}

	@Override
	public Student findOneWithSubjectsLearning(int roll) {
		// TODO Auto-generated method stub
		return this.repo.findOneWithSubjectsLearning(roll);
	}
	
}
