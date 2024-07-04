package com.upc.grupo3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RecargarTarjeta : AppCompatActivity() {
    private lateinit var btnPagar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recargar_tarjeta)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        asignarRefe()
    }
        private fun asignarRefe() {
            btnPagar = findViewById(R.id.btnPagar)

            btnPagar = findViewById(R.id.btnPagar)
            btnPagar.setOnClickListener {
                val intent = Intent(this, AgregarTarjetaCreditoDebito::class.java)
                startActivity(intent)
            }
        }
}