const express = require("express")
const mysql = require("mysql2")
const bodyParser = require("body-parser")

const app = express()

const PUERTO=3000

const conexion = mysql.createConnection({
    host:'localhost',
    database:'proyectomoviles',
    user:'root',
    password:'123456'
})

app.listen(PUERTO,()=>{
    console.log('Servidor corriendo en '+ PUERTO)
})

app.get('/',(req,res)=>{
    res.send('Bienvenido al servicio de metropolitano')
})

app.get('/cliente',(req,res)=>{
    const consulta=" SELECT * FROM cliente "
    conexion.query(consulta,(error,resultado)=>{
        if(error) return console.error(error.message)
            
        const obj={}

        if(resultado.length>0){
            obj.listaClientes=resultado
            res.json(obj)
        }else{
            res.json('no hay clientes')
        }
    })
})

app.post('/cliente/registro',(req,res)=>{
    const cliente={
        cli_nombre:req.body.cli_nombre,
        cli_apellido:req.body.cli_apellido,
        cli_correo:req.body.cli_correo,
        cli_contraseña:req.body.cli_contraseña,
        fk_tarj_id:req.body.fk_tarj_id
    }

    const query = "INSERT INTO cliente SET?"
    conexion.query(query,cliente,(error)=>{
        if(error) return console.error(error.message)
        res.json("Se inserto correctamente a la persona")
    })
})

app.get('/login',(req,res)=>{
    const {cli_correo, cli_contraseña}=req.params
    const query="SELECT * FROM cliente WHERE cli_correo=? AND cli_contraseña=?"

    conexion.query(query,[cli_correo,cli_contraseña],(error,respuesta)=>{
        if(error) return console.error(error.message)

        if(respuesta.length>0){
            res.json(respuesta[0])
        }else{
            res.json("No hay registros")
        }
    })
})

app.get('/tarjeta',(req,res)=>{
    const {cli_id}=req.params
    const consulta="SELECT c.cli_id, tm.tarj_id, tm.tarj_saldo, tm.tipo_tarj_id FROM cliente c JOIN tarjeta_metro tm ON c.fk_tarj_id = tm.tarj_id WHERE c.cli_id = ?"  

    conexion.query(express.query,[cli_id],(error, resultado)=>{
        if(error) return console.error(error.message)

        const obj={}

        if(resultado.length>0){
            obj.listaTarjetas=resultado
            res.json(obj)
        }else{
            res.json('no hay tarjetas')
        }
    })
})

app.put('/recargar/:monto',(req,res)=>{
    const {monto}=req.params
    const {tarj_id} =req.body


    const query="UPDATE tarjeta_metro SET `tarj_saldo` = `tarj_saldo` + "+monto+ "WHERE `tarj_id` = "+tarj_id
    conexion.query(query,(error)=>{
        if(error) return console.error(error.message)

        res.json("Se recargo la tarjeta con exito")
    })
})
