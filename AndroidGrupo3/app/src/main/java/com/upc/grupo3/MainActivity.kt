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

class MainActivity : AppCompatActivity() {
    private lateinit var lgCorreo:EditText
    private lateinit var lgContrasena:EditText
    private lateinit var btnIniciarSesion:Button
    private lateinit var tvRegistrar:TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login_activity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
       asignarReferencias()
    }
    private fun asignarReferencias() {
        lgCorreo = findViewById(R.id.lgCorreo)
        lgContrasena = findViewById(R.id.lgContrasena)
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion)

        tvRegistrar = findViewById(R.id.tvRegistrar)
        tvRegistrar.setOnClickListener {
            val intent = Intent(this, RegistroCliente::class.java)
            startActivity(intent)
        }
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion)
        btnIniciarSesion.setOnClickListener {
            val intent = Intent(this, RecargarTarjeta::class.java)
            startActivity(intent)}
    }
}
