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
    const query="SELECT c.cli_id, tm.tarj_id, tm.tarj_saldo, tm.tipo_tarj_id FROM cliente c JOIN tarjeta_metro tm ON c.fk_tarj_id = tm.tarj_id WHERE c.cli_id = ?"  

    conexion.query(query,[cli_id],(error, resultado)=>{
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

app.delete('/tarjeta/eliminar/:tarj_id',(req,res)=>{
    const {tarj_id}=req.params

    const query ="DELETE FROM recargas WHERE tarjeta_metro_id = "+tarj_id
    conexion.query(query,(error)=>{
        if(error) console.error(error.message)
        res.json("Se elimino tarjeta")
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

app.post('/recarga',(req,res)=>{
    const recarga={
        tarjeta_metro_id:req.body.tarjeta_metro_id,
        tarjeta_metro_tipo_id:req.body.tarjeta_metro_tipo_id,
        pago_debito_id:req.body.pago_debito_id,
        recargas_fecha:new Date(),
        recarga_monto:req.body.recarga_monto,
        observacion:req.body.observacion
    }

    const query = "INSERT INTO recargas SET?"
    conexion.query(query,recarga,(error)=>{
        if(error) return console.error(error.message)
        res.json("Se inserto correctamente la recarga")
    })
})

app.get('/recarga/historial',(req,res)=>{
    const {cli_id}=req.params
    const query="SELECT * FROM recargas r JOIN tarjeta_metro tm ON r.tarjeta_metro_id = tm.tarj_id JOIN cliente c ON c.fk_tarj_id=tm.tarj_id WHERE c.cli_id =?"

    conexion.query(query,[cli_id],(error, resultado)=>{
        if(error) return console.error(error.message)

        const obj={}

        if(resultado.length>0){
            obj.listarRecargas=resultado
            res.json(obj)
        }else{
            req.json('no hay recargas')
        }
    })
})


app.post('/tarjeta/debito',(req,res)=>{
    const debito={
        debito_id:req.body.debito_id,
        debit_num_tarjeta:req.body.debit_num_tarjeta,
        debito_fecha_caducidad:req.body.debito_fecha_caducidad,
        debito_ccv:req.body.debito_ccv
    }

    const query = "INSERT INTO pago_debito SET?"
    conexion.query(query,debito,(error)=>{
        if(error) return console.error(error.message)
        res.json("Se inserto la tarjeta de debito")
    })
})


