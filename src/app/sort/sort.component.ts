import { Component, EventEmitter, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Student } from '../../model/Student';

import { MatRadioModule } from '@angular/material/radio'
@Component({
  selector: 'app-sort',
  standalone: true,
  imports: [CommonModule,MatRadioModule],
  templateUrl: './sort.component.html',
  styleUrl: './sort.component.css'
})
export class SortComponent {
   criteria:string='';
   @Output()
   criteriaEmitter=new EventEmitter<string>();
   constructor()
   {
  
   }
     
   sortByPercentage()
  {
    this.criteria='percentage'
    this.criteriaEmitter.emit(this.criteria)
  }
  sortByAttempts()
  {
    this.criteria='attempts'
    this.criteriaEmitter.emit(this.criteria)
  }
  sortBysubjects()
  {
    this.criteria='subjects'
    this.criteriaEmitter.emit(this.criteria)
  }
  
}