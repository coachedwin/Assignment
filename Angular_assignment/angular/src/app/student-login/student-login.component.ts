import { Component, OnInit } from '@angular/core';
import { FormGroup,FormBuilder,Validators, Form } from '@angular/forms';
import { AppServiceService } from '../app-service.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-student-login',
  templateUrl: './student-login.component.html',
  styleUrls: ['./student-login.component.css']
})
export class StudentLoginComponent implements OnInit {
loginForm!:FormGroup
loginFailed=false
studentData:any
  constructor(private service:AppServiceService,private formBuilder:FormBuilder,private router:Router) { }

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
  this.service.studentData().subscribe(data=>{
    this.studentData=data;
    const user=this.studentData.find((a:any)=>{
      return a.email===this.loginForm.value.email && a.pass===this.loginForm.value.pass
    });
    
    if(user){
      
      this.loginForm.reset();
      this.router.navigate(['student']);
    }
    else{
      this.loginFailed=true
    }
  })
}
else{
  alert("Please Enter the email id and password")}
}
}
