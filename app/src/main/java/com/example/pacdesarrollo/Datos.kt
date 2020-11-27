package com.example.pacdesarrollo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_datos.*
import kotlinx.android.synthetic.main.activity_insertar.*
import kotlinx.coroutines.launch


class Datos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos)


    }

    override fun onResume() {
        super.onResume()

        //CREAR TABLA
        button3.setOnClickListener{

            lifecycleScope.launch {
                val db = Room.databaseBuilder(applicationContext,UsuarioDB::class.java, "usuariodb").build()

            }

            Toast.makeText(this, R.string.creada, Toast.LENGTH_LONG).show()


        }


        //INTRODUCIR DATOS
        button4.setOnClickListener{

            val intent = Intent(this, Insertar::class.java)
            startActivity(intent)


        }


        //CONSULTAR DATOS
        button5.setOnClickListener {

            val intent = Intent(this, Consultar::class.java)
            startActivity(intent)


        }


        //VOLVER AL ACTIVITY MAIN
        button6.setOnClickListener {

            finish()

        }

    }


}





