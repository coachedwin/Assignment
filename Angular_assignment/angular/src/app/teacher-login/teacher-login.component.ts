import { Component, OnInit } from '@angular/core';
import { AppServiceService} from '../app-service.service'

import {MatDialog, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { DialogComponent } from '../dialog/dialog.component';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-teacher-login',
  templateUrl: './teacher-login.component.html',
  styleUrls: ['./teacher-login.component.css']
})
export class TeacherLoginComponent implements OnInit {
studentData:any;

  constructor(private service:AppServiceService,private dialog : MatDialog,private router:Router) {
    
   }
   //function to open dialog
   openDialog() {
    this.dialog.open(DialogComponent, {
      width:"30%"
    }).afterClosed().subscribe(value=>{
      if(value=="save"){
        this.ngOnInit();
      }
    })
  }
  //for edit data
  editData(data: any){
    this.dialog.open(DialogComponent,{
      width:"30%",
      data:data
    }).afterClosed().subscribe(value=>{
      if(value=="update"){
        this.ngOnInit();
      }
    })
  }

  //function for delete data
  deleteData(id:number){
    this.service.deleteProduct(id).subscribe({
      next:(res)=>{
        //Swal.fire("Product Deleted Successfully");
        Swal.fire({
          icon: 'error',
          text: 'Record Deleted !',
        })
      this.ngOnInit();
      },error:()=>{
        alert("Error while deleting");
      }
    })
 }
 //function to log out
 LogOut(){
  this.router.navigate(['']);
 }
  ngOnInit(): void {
    this.service.getData().subscribe(data=>{
      console.warn(data);
      this.studentData=data;
    })
  }


}
