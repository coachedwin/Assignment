const express = require('express');
const router = express.Router();
const userConteroller =require('../controllers/controllers');
module.exports = router;

//api to render the all student records page after successful login of the teacher
router.get('/get',userConteroller.get);

//api to add student details
router.post('/addStudent',userConteroller.addStudent);

//api to update student details
router.put('/update',userConteroller.update);

//api to delete students details
router.delete('/delete/:id',userConteroller.delete);

//api for student authentication
router.get('/studentData',userConteroller.studentData);

//api to get the result of students
router.get('/getstudent',userConteroller.getstudent);

//api for teacher login authentication
router.get('/teacherData',userConteroller.teacherData);
