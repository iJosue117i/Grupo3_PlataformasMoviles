package com.upc.grupo3

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistroCliente : AppCompatActivity() {

    private lateinit var regCorreo:EditText
    private lateinit var regContra:EditText
    private lateinit var regTipo:Spinner
    private lateinit var regNumeroTarjeta:EditText
    private lateinit var regNombre:EditText
    private lateinit var regApellido:EditText
    private lateinit var btnRegistrar: TextView
    private lateinit var btnVolver:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro_cliente)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        asignarDatos()
    }
    private  fun asignarDatos() {
        regCorreo = findViewById(R.id.regCorreo)
        regContra = findViewById(R.id.regContra)
        regTipo = findViewById(R.id.regTipo)
        regNumeroTarjeta = findViewById(R.id.regNumeroTarjeta)
        regNombre = findViewById(R.id.regNombre)
        regApellido = findViewById(R.id.regApellido)

                btnRegistrar= findViewById(R.id.btnRegistrar)
        btnRegistrar.setOnClickListener {
            val intent = Intent(this, RecargarTarjeta::class.java)
            startActivity(intent)
        }
        btnVolver = findViewById(R.id.btnVolver)
        btnVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

        }



