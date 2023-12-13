import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule,FormsModule,MatFormFieldModule,MatInputModule,MatButtonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
   username:string=''
   password:string=''
   message:string=''
   showError:boolean=false;
   constructor(private service:UserService,private r:Router){
      this.username = 'admin';
      this.password = 'admin';
   }
   PerformLogin(){
    if(this.service.PerformLogin(this.username,this.password)){
      this.message = 'Login Success'
      this.service.createSessionAndStoreValue(this.username, true)
      // show students view to user   
      this.r.navigate(['students']) //this is programmatic navigation
    }
    else
    {
      this.message = 'Login Failed'
      this.service.createSessionAndStoreValue('guest', false)
      this.showError=true;
    }
   }
   
}