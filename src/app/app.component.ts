import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { FooterComponent } from './footer/footer.component';
import  HeaderComponent  from './header/header.component';
import { StudentsComponent } from './students/students.component';
import { LoginComponent } from './login/login.component';
import { SortComponent } from './sort/sort.component';
import { RegisterComponent } from './register/register.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { HomeComponent } from './home/home.component';
import { MenuComponent } from './menu/menu.component';
import { LogoutComponent } from './logout/logout.component';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar'
import { MatSidenavModule } from '@angular/material/sidenav'
import { MatIconModule } from '@angular/material/icon'
// import { MatDialogModule, MatDialog } from '@angular/material/dialog'
// import { ModelDialogComponent } from './model-dialog/model-dialog.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet,FooterComponent,HeaderComponent,StudentsComponent,
           LoginComponent,AboutUsComponent,ContactUsComponent,MenuComponent,LogoutComponent,
           RegisterComponent,HomeComponent,MatButtonModule, MatToolbarModule, MatSidenavModule, 
           MatIconModule,SortComponent],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'helloworld';
  
}
