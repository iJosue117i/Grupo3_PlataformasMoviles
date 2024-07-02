const express = require("express")
const mysql = require("mysql2")
const bodyParser = require("body-parser")

const app = express()

const PUERTO=3000

const conexion = mysql.createConnection({
    host:'localhost',
    database:'proyectomoviles',
    user:'root',
    password:'mysql'
})

app.listen(PUERTO,()=>{
    console.log('Servidor corriendo en '+ PUERTO)
})

app.get('/',(req,res)=>{
    res.send('Bienvenido al servicio de metropolitano')
})

app.get('/cliente',(req,res)=>{
    const consulta=" SELECT * FROM cliente"
    conexion.query(consulta,(error,resultado)=>{
        if(error) return console.error(error.message)
            
        const obj={}

        if(resultado.length>0){
            obj.listaPersonas=resultado
            res.json(obj)
        }else{
            res.json('no hay cliente')
        }
    })
})

app.post('/cliente/registro',(req,res)=>{
    const cliente={
        cli_nombre:req.body.cli_nombre,
        cli_apellido:req.body.cli_apellido,
        cli_correo:req.body.cli_correo
    }
})