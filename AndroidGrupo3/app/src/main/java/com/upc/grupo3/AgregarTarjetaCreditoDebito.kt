package com.upc.grupo3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AgregarTarjetaCreditoDebito : AppCompatActivity() {
    private lateinit var btnGuardar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_agregar_tarjeta_credito_debito)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        llenarDatos()
    }
    private fun llenarDatos() {
        btnGuardar = findViewById(R.id.btnGuardar)

        btnGuardar = findViewById(R.id.btnGuardar)
        btnGuardar.setOnClickListener {
            val intent = Intent(this, Pago::class.java)
            startActivity(intent)
        }
    }
}