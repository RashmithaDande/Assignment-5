import { Injectable } from '@angular/core';
import { Student } from '../../model/Student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  students:Student[] = []
  constructor() { 
      let s1 = new Student(1,"Rashmitha",2,80,["Java","Python"])
      let s2 = new Student(2,"Prasoona",1,98,["C","Sql"])
      let s3 = new Student(3,"Anjani",3,79,["Angular","Python"])
      let s4 = new Student(4,"Ramya",4,94,["React","Java"])
      let s5 = new Student(5,"Madhu",2,89,["English","Maths"])
      this.students.push(s1)
      this.students.push(s2)
      this.students.push(s3)
      this.students.push(s4)
      this.students.push(s5)
  }
  findAllStudents(){
      return this.students
  }
}
