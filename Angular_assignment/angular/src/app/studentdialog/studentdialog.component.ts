import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog,MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-studentdialog',
  templateUrl: './studentdialog.component.html',
  styleUrls: ['./studentdialog.component.css']
})
export class StudentdialogComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data: any) { }
name:any
roll:any;
dob:any
score:any
  ngOnInit(): void {
    console.log(this.data[0].name);
    this.name=this.data[0].name;
    this.roll=this.data[0].roll;
    this.score=this.data[0].score;
    this.dob=this.data[0].dob;
  }

}
