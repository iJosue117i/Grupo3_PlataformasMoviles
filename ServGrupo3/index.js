const express = require("express")
const mysql = require("mysql2")
const bodyParser = require("body-parser")

const app = express()

const PUERTO=3000

const conexion = mysql.createConnection({
    host:'localhost',
    database:'metropolitano',
    user:'root',
    password:'123456'
})

app.listen(PUERTO,()=>{
    console.log('Servidor corriendo en '+ PUERTO)
})

app.get('/',(req,res)=>{
    res.send('Bienvenido al servicio de metropolitano')
})

app.get('/clientes',(req,res)=>{
    const consulta=" SELECT * FROM clientes"
    conexion.query(consulta,(error,resultado)=>{
        if(error) return console.error(error.message)
            
        const obj={}

        if(resultado.length>0){
            obj.listaPersonas=resultado
            res.json(obj)
        }else{
            res.json('no hay clientes')
        }
    })
})

app.post('/clientes/registro',(req,res)=>{
    const cliente={
        cli_nombre:req.body.cli_nombre,
        cli_apellido:req.body.cli_apellido,
        cli_correo:req.body.cli_correo
    }
})