package com.example.pacdesarrollo

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Usuario::class],
    version = 1
)

abstract class UsuarioDB : RoomDatabase() {

    abstract fun usuarioDao(): UsuarioDao


}