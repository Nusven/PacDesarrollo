package com.example.pacdesarrollo

import androidx.room.*

@Dao
interface UsuarioDao {

    @Query("SELECT * FROM Usuario")
    suspend fun consulta(): List<Usuario>

    @Insert
    suspend fun inserta(usuario: Usuario)


}