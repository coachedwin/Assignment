import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentComponent } from './student/student.component';
import { TeacherComponent } from './teacher/teacher.component';
import { HomeComponent } from './home/home.component';
import { TeacherLoginComponent } from './teacher-login/teacher-login.component';
import { StudentLoginComponent } from './student-login/student-login.component';
const routes: Routes = [
  {
    path:'student',
    component:StudentComponent
  },
  {
    path:'teacher',
    component:TeacherComponent
  },
  {
path:'teacher-login',
component:TeacherLoginComponent
  },
  {
    path:'student-login',
    component:StudentLoginComponent
      },
  {
    path:'',
    component:HomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
