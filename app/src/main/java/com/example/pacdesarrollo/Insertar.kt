package com.example.pacdesarrollo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_insertar.*
import kotlinx.coroutines.launch

class Insertar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertar)

    }

    override fun onResume() {
        super.onResume()

        button10.setOnClickListener{

            val nombre = editText.text.toString()
            val apell = editText2.text.toString()
            val edad = editText3.text.toString().toInt()

            val usuario = Usuario(0, nombre, apell,edad)


            lifecycleScope.launch {
                val db = Room.databaseBuilder(applicationContext,UsuarioDB::class.java, "usuariodb").build()

                db.usuarioDao().inserta(usuario)


            }
            finish()

        }


    }
}