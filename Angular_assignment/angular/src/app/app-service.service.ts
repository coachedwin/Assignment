import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AppServiceService {

  constructor(private http:HttpClient) { }
//calling api to get student data
  getData(){
  let url="http://localhost:2000/get"
  return this.http.get(url);

}
//calling api to add student data
postData(data: any){
  let url="http://localhost:2000/addStudent"
  return this.http.post(url,data);
}
//calling api to update student data
updateData(data:any){
  let url="http://localhost:2000/update"
  return this.http.put(url,data);
}

//calling api to delete student data
deleteProduct(id:number){
  let url="http://localhost:2000/delete/"
return this.http.delete(url+id);
}

//calling api to get teacher data for teacher login
teacherData(){
  let url="http://localhost:2000/teacherData"
  return this.http.get(url);
  
}

//calling api to get student login data
studentData(){
  let url="http://localhost:2000/studentData"
  return this.http.get(url);
  
}

}
