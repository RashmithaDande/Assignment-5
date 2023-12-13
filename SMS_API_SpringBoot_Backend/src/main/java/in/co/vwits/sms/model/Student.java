package in.co.vwits.sms.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity  //used on top of class and this class name is treated as table name in db
//         and to change this table name we use @Table
@Table(name="tbl_student") //used to change table name in database
@NamedQuery(name="findAllWithSubjects", query= "FROM Student AS s LEFT JOIN FETCH s.subjectsLearning")
public class Student implements Comparable<Student> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//this will automatically increment value of rollno in database
	private int rollno;
	@Column(name="st_name",nullable = false)//It means name should not be null
	private String name;
	private double percentage;
	private int numberOfAttempts;
	
//	@ElementCollection(fetch = FetchType.EAGER)//Not recommended though possible becoz it gives all records even we are not intrested
	@ElementCollection(fetch = FetchType.LAZY)//Recommended approach becoz it fetch data when user wants using jpql
	@CollectionTable(name="Students_Subjects",joinColumns =@JoinColumn(name="rollno_fk"))//To change table name of subjects and roll no is foreign key here
    private List<String> subjectsLearning;
	
	@Transient  //this field will not save in database
    private LocalDate dateOfBirth;
    
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public int getNumberOfAttempts() {
		return numberOfAttempts;
	}
	public void setNumberOfAttempts(int numberOfAttempts) {
		this.numberOfAttempts = numberOfAttempts;
	}
	
	public List<String> getSubjectsLearning() {
		return subjectsLearning;
	}
	public void setSubjectsLearning(List<String> subjectsLearning) {
		this.subjectsLearning = subjectsLearning;
	}
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", percentage=" + percentage + ", numberOfAttempts="
				+ numberOfAttempts + ", subjectsLearning=" + subjectsLearning +  ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return (int) (o.percentage - this.percentage);
	}
	
	


}
