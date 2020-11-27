package com.example.pacdesarrollo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{


            Toast.makeText(this, R.string.activity2, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Datos::class.java)
            startActivity(intent)

        }

        button2.setOnClickListener{

            val intent = Intent(this, Servicios::class.java)
            startActivity(intent)

        }
    }
}