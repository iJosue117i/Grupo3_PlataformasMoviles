const express = require("express")
const mysql = require("mysql2")
const bodyParser = require("body-parser")

const app = express()

const PUERTO=3000

app.listen(PUERTO,()=>{
    console.log('Servidor corriendo en '+ PUERTO)
})