const mysqlConnection = require("../../connection");

//api to render the all student records page after successful login of the teacher
exports.get=(req, res) => {
    mysqlConnection.query("Select * from student ", (err, rows, field) => {
        res.json(rows);
    });
}

//api to add student details
exports.addStudent=function(req, res) {
    var params = req.body;
    console.log(params);
    mysqlConnection.query('INSERT INTO student SET ?', params, function(error, results, fields) {
        //if user tries to enter a primary key value again then a error message will sent to the form.ejs
        if (results == null) {
            var msg = "Student Data with this roll number is already present!!!";
            res.json({ msg: "Invalid!!" })
            console.log(msg);
        } else {
            res.json(results);
        }
    });
}

//api to update student details
exports.update= function(req, res) {
    mysqlConnection.query('UPDATE `student` SET `name`=?,`dob`=?,`score`=? where `roll`=?', [req.body.name, req.body.dob, req.body.score, req.body.roll], function(error, results, fields) {
        if (error) throw error;
        res.json(results);
        console.log(results);
    });

}

//api to delete students details
exports.delete= (req, res) => {
    mysqlConnection.query('DELETE FROM Student WHERE ROLL =?', [req.params.id], (err, rows, fields) => {
        if (!err) {
            res.json(rows);
            console.log(rows);
        } else {
            console.log(err);
        }
    })

}
//api for student authentication
exports.studentData= (req, res) => {
    mysqlConnection.query('select * from student_login', function(error, results, fields) {
        console.log(results);
        if (!error) {
            res.json(results);
        } else {
            throw error;
        }
    });
}
//api to get the result of students
exports.getstudent= function(req, res) {
    mysqlConnection.query('select * from student ', function(error, results, fields) {
        if (error) throw error;
        res.json(results)
    });
}

//api for teacher login authentication
exports.teacherData= (req, res) => {
    mysqlConnection.query('select * from teachers', function(error, results, fields) {
        console.log(results);
        if (!error) {
            res.json(results);
        } else {
            throw error;
        }
    });
}


