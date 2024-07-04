package com.upc.grupo3

data class Cliente(
    var cli_id:Int,
    var cli_nombre:String,
    var cli_apellido:String,
    var cli_correo:String,
    var cli_contraseña:String,
    var tarj_id:Int,
    var tipo_tarj_id: Int,
)

data class Registro(
    var tipo_tarj_id:Int,
    var tipo_tarj_descripcion:String,
    var tarjeta_id:Int,
    var tarjeta_saldo:Double,

)
