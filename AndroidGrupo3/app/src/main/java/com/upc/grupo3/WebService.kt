package com.upc.grupo3

import com.google.gson.GsonBuilder
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


object AppConstantes{
    const val BASE_URL="http://192.168.0.103:3000"
}

interface WebService {
    @GET("/cliente")
    suspend fun obtenerCliente():Response<ClienteResponse>

    @POST("/cliente/registro")
    suspend fun agregarCliente(@Body cliente: Cliente):Response<String>


}

object RetrofitClient{
    val webService:WebService by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstantes.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(webService::class.java)
    }
}

