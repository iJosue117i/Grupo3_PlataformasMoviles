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
    private  fun asignarDatos(){
        regCorreo = findViewById(R.id.regCorreo)
        regContra = findViewById(R.id.regContra)
        regTipo= findViewById(R.id.regTipo)
        regNumeroTarjeta = findViewById(R.id.regNumeroTarjeta)
        regNombre = findViewById(R.id.regNombre)
        regApellido = findViewById(R.id.regApellido)
        btnRegistrar = findViewById(R.id.btnRegistrar)

        btnRegistrar.setOnClickListener {
            registrar()
        }

    }
    private fun registrar(){
        val correo = regCorreo.text.toString()
        val contra= regContra.text.toString()
        val tipo = regTipo.dropDownVerticalOffset.toString()
        val tarjeta = regNumeroTarjeta.text.toString()
        val nombre = regNombre.text.toString()
        val apellido = regApellido.text.toString()

        val cliente = Cliente (0, nombre, apellido, correo, contra, 0,0)
        CoroutineScope(Dispatchers.IO).launch {
            val rpta = RetrofitClient.webService.agregarCliente(cliente)
            runOnUiThread {
                if(rpta.isSuccessful){
                    mostrarMensaje(rpta.body().toString())
                }
            }
        }

    }
    private fun mostrarMensaje(mensaje:String){
        val ventana = AlertDialog.Builder(this)
        ventana.setTitle("Información")
        ventana.setMessage(mensaje)
        ventana.setPositiveButton("Aceptar", DialogInterface.OnClickListener{ dialog, which ->
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
        ventana.create().show()

}
}

