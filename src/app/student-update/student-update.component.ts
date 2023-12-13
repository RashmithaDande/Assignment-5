import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Student } from '../../model/Student';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-student-update',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './student-update.component.html',
  styleUrl: './student-update.component.css'
})
export class StudentUpdateComponent {
  @Input()
   updatedStudent = new Student(0,'',0,0,[])

   //To send data from child to parent we need to use @Output decorator
   @Output()
   studentEmitter = new EventEmitter<Student>()//1st step
   performUpdate(){
       this.studentEmitter.emit(this.updatedStudent)//2nd step
   }
}
