package com.example.pacdesarrollo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_consultar.*
import kotlinx.coroutines.launch

class Consultar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar)

        var listAdapter:ArrayAdapter<Usuario>
        var usuario = ArrayList<Usuario>()

        lifecycleScope.launch {
            val db = Room.databaseBuilder(applicationContext,UsuarioDB::class.java, "usuariodb").build()

            usuario = db.usuarioDao().consulta() as ArrayList<Usuario>
            listAdapter = Adaptador(applicationContext,usuario)
            listalw.adapter=listAdapter

        }






    }

    override fun onResume() {
        super.onResume()

        button11.setOnClickListener{

            finish()
        }
    }


}