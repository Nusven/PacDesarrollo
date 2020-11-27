package com.example.pacdesarrollo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_servicios.*

class Servicios : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servicios)


    }

    override fun onResume() {
        super.onResume()

        //Crear servicio
        button7.setOnClickListener{


            //Nueva activity para controlar el servicio

            val intent = Intent(this, ServicioCreado::class.java)
            startActivity(intent)


        }

        //Detener el servicio
        button8.setOnClickListener(){

            Reproductor.stopService(this)

        }



        button9.setOnClickListener {

            finish()

        }
    }
}