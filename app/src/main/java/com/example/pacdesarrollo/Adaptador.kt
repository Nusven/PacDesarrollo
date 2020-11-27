package com.example.pacdesarrollo

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.listausuarios.view.*

class Adaptador(private val nContext: Context, private val listaUsuario: List<Usuario>) :ArrayAdapter<Usuario>(nContext, 0, listaUsuario) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layout = LayoutInflater.from(nContext).inflate(R.layout.listausuarios,parent,false)

        val usuario = listaUsuario[position]

        layout.idUsuario.text = usuario.idUsuario.toString()
        layout.nombre.text = usuario.nombre
        layout.apellido.text = usuario.apellido
        layout.edad.text = usuario.edad.toString()

        return layout
    }

    fun actualizar (){
        this.notifyDataSetChanged()
    }

}






