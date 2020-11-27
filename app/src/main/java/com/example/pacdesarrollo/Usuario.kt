package com.example.pacdesarrollo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Usuario(
    @PrimaryKey(autoGenerate = true)
    val idUsuario: Int,
    val nombre: String,
    val apellido: String,
    val edad: Int

)