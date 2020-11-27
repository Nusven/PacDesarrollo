package com.example.pacdesarrollo


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_servicio_creado.*


class ServicioCreado : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servicio_creado)
        Reproductor.starService(this)
        Toast.makeText(this,"Servicio iniciado", Toast.LENGTH_SHORT).show()

    }

    override fun onResume() {
        super.onResume()


        //Iniciar reproduccion
        btinicio.setOnClickListener(){
            Reproductor.reproduce()
        }

        //Detener reproduccion
        btstop.setOnClickListener(){
            Reproductor.pausa()
        }

        //Bloquear
        btsleep.setOnClickListener(){
            Reproductor.bloquea()
        }


        btatras.setOnClickListener(){
            finish()
        }

    }
}