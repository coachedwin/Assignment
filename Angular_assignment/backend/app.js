const express = require('express');
//const mysqlConnection = require('mysql/lib/Connection');

const mysqlConnection = require("./connection");
const bodyParser = require('body-parser');
const app = express();
let cors = require("cors");
app.use(cors());
app.use(bodyParser.json());

app.use(bodyParser.urlencoded({ extended: true }));

const routes = require('./servers/routes/routers');
app.use('/',routes);

//Middleare to set the response headers for CORS ORIGIN POLICY
app.use((req, res, next) => {
    res.setHeader("Access-Control-Allow-Origin", "*");
    res.setHeader(
        "Access-Control-Allow-Headers",
        "Origin, X-Requested-With, Content-Type, Accept, Authorization"
    );
    res.setHeader(
        "Access-Control-Allow-Methods",
        "GET, POST, PUT, PATCH, DELETE, OPTIONS"
    );
    next();
});

app.listen(2000, (req, res) => {
    console.log('Express api is running');
})