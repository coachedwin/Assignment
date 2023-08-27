import { Component, Inject, OnInit } from '@angular/core';
import { FormGroup,FormBuilder,Validators} from '@angular/forms';
import { AppServiceService } from '../app-service.service';
import {MatDialogRef,MAT_DIALOG_DATA} from '@angular/material/dialog'
import Swal from 'sweetalert2';

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css']
})
export class DialogComponent implements OnInit {
studentForm!:FormGroup;
  actionBtn: string="Save";
  data:any
  a:boolean=false
constructor(private formBuilder:FormBuilder, private service:AppServiceService,
  @Inject(MAT_DIALOG_DATA)public editData:any,
  private dialogRef: MatDialogRef<DialogComponent>,
  ){}
  ngOnInit(): void {
    this.studentForm=this.formBuilder.group({
      name:['',Validators.required],
      roll:['',Validators.required],
      score:['',Validators.required],
      dob:['',Validators.required]
    })
if(this.editData){
  this.actionBtn="Update"
 this.a=true
  this.studentForm.controls['name'].setValue(this.editData.name);
  this.studentForm.controls['roll'].setValue(this.editData.roll);
  this.studentForm.controls['score'].setValue(this.editData.score);
  this.studentForm.controls['dob'].setValue(this.editData.dob);
}
  }
  //add student data
  addStudent(){
    if(!this.editData){
      if(this.studentForm.valid){
        this.service.getData().subscribe(data1=>{
          this.data=data1;
          const user=this.data.find((a:any)=>{
            console.log("Find reached")
            return a.roll===this.studentForm.value.roll
          });
          if(!user){
            this.service.postData(this.studentForm.value).subscribe({next:(res)=>{
            if(res){
              //alert("Student Data added successfully")
              Swal.fire('Student Data added successfully!!!');
            }
            this.studentForm.reset();
            this.dialogRef.close('save');
          },
         error:()=>{
           //alert("Error in adding data!!");
           Swal.fire('Error in adding data!!');

         }});
         }else{
           //alert("Student with this details is already present")
           Swal.fire('Student with this roll number already exist !');

         }
        }
        
         )}
      }
    
    else{
      this.updateData();
    }
   }
   //update student data
   updateData(){
     this.service.updateData(this.studentForm.value).subscribe({next: (res)=>{
      Swal.fire("Student data updated successfully");
       this.studentForm.reset();
       this.dialogRef.close("update");
     },error:()=>{
      Swal.fire("Error while updating");
       
     }
    })
   }
   

}
