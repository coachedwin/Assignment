import { Component, OnInit } from '@angular/core';
import { FormGroup,FormBuilder,Validators } from '@angular/forms';
import {StudentdialogComponent} from '../studentdialog/studentdialog.component'
import {MatDialog,MAT_DIALOG_DATA} from '@angular/material/dialog'
import { AppServiceService } from '../app-service.service'; 
import { Router } from '@angular/router';
@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
public studentDetail!:FormGroup
data:any
student:any
loginFailed=false
  constructor(private formBuilder:FormBuilder,private dialog:MatDialog, private service:AppServiceService,private router:Router) { }

  ngOnInit(): void {
    this.studentDetail=this.formBuilder.group({
      roll:['',Validators.required],
      dob:['',Validators.required]
    })
  }
  LogOut(){
    this.router.navigate(['']);
   }
  

search(){
  if(this.studentDetail.valid){
    this.service.getData().subscribe(data1=>{
      this.data=data1;
      const user=this.data.find((a:any)=>{
        console.log("Find reached")
        return a.roll===this.studentDetail.value.roll && a.dob===this.studentDetail.value.dob

      });
      this.student=this.data.filter((a:any)=>{
        return a.roll===this.studentDetail.value.roll && a.dob===this.studentDetail.value.dob
      })
      
      if(user){     
        
  this.dialog.open(StudentdialogComponent, {
    width:"30%",
    data:this.student
    })
      }
      else{
        this.loginFailed=true;
      }
    })
}
else{
  alert("Please fill all the data")
}
}
}
