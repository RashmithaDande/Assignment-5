import { Injectable } from '@angular/core';
import { Student } from '../../model/Student';
import { StudentService } from './student.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {
   isUserLoggedIn:boolean = false
   public students:Student[]=[]; 
   message:string=''
   
   constructor(private s:StudentService){
      this.isValidSession()
   }

   PerformLogin(username:string,password:string){
     if(username=='admin' && password=='admin')
     {
        this.isUserLoggedIn=true;
     }
     else
     {
       this.isUserLoggedIn=false
     }
     return this.isUserLoggedIn
   } 

  //  Following methods are for maintaining session of the user
   public createSessionAndStoreValue(username:string, isUserLoggedIn:boolean){
        sessionStorage.setItem('isUserLoggedIn', isUserLoggedIn+'')
        sessionStorage.setItem('username',username)
   }

   public isValidSession(){

        let username = sessionStorage.getItem('username')
        if(username=='guest'){
           this.isUserLoggedIn=false
        }
        else{
          this.isUserLoggedIn=true
        }
   }

  public logout(){
    sessionStorage.removeItem('username')
    sessionStorage.removeItem('isUserLoggedIn')
    this.isUserLoggedIn=false
  }
}
