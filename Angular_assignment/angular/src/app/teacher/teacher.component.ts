import { Component, OnInit } from '@angular/core';
import { FormGroup,FormBuilder,Validator, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import {AppServiceService} from '../app-service.service';


@Component({
  selector: 'app-teacher',
  templateUrl: './teacher.component.html',
  styleUrls: ['./teacher.component.css']
})
export class TeacherComponent implements OnInit {
loginForm!:FormGroup
teacherData:any
loginFailed:boolean=false
  constructor(private formBuilder:FormBuilder,private router:Router,private service:AppServiceService) { }

  ngOnInit(): void {
    this.loginForm=this.formBuilder.group({
      email:['',Validators.required],
      pass:['',Validators.required]
    })
  }
login()
{
  console.log("Login REached");
if(this.loginForm.valid){
  this.service.teacherData().subscribe(data=>{
    this.teacherData=data;
    const user=this.teacherData.find((a:any)=>{
      return a.email===this.loginForm.value.email && a.pass===this.loginForm.value.pass
    });
    
    if(user){
      this.loginForm.reset();
      this.router.navigate(['teacher-login']);
    }
    else{
     this.loginFailed=true;
     
    }
  })
}
else{
  alert("Please Enter the email id and password")}
}
}
