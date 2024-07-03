package com.upc.grupo3

import com.google.gson.annotations.SerializedName

data class ClienteResponse(
    @SerializedName("listaClientes") var listaClientes:ArrayList<Cliente>
)