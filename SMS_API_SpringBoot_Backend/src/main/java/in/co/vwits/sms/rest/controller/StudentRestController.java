package in.co.vwits.sms.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.co.vwits.sms.model.Student;

import in.co.vwits.sms.service.StudentService;

@RestController
@RequestMapping(value="/api/student")
public class StudentRestController {
    
	@Autowired
	private StudentService service;
	
	@GetMapping
	public List<Student> findAll(){
		return service.findAllWithSubjects();
	}
	
	@GetMapping("/{rollno}")
	public Student findByRollno(@PathVariable int rollno) {
		return service.findOneWithSubjectsLearning(rollno);	
	}
	
	@PostMapping
	public ResponseEntity<Student> createNewStudent(@RequestBody Student s) {
		this.service.save(s);
		ResponseEntity<Student> entity = new ResponseEntity<>(s,HttpStatus.CREATED);
		return entity;
	}
	
	//ToDo improve server to return appropriate status code
	@DeleteMapping("/{rollno}")
	public void deleteStudentByRollno(@PathVariable int rollno) throws InterruptedException {
		Thread.sleep(10000);//forceful delay just to mimic the behavior as if server is taking 
		//time to complete the processing
		this.service.deleteByRollno(rollno);
	}
	
	@PutMapping("/{rollno}")
	public ResponseEntity<Student> updateStudent(@PathVariable int rollno, @RequestBody Student s)
	{
		this.service.updateStudentByRollno(s);
		ResponseEntity<Student> entity = new ResponseEntity<>(s,HttpStatus.OK);
		return entity;
	}
}









