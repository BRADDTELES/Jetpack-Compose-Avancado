package com.danillotelescarneiro.agendadecontatos.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.danillotelescarneiro.agendadecontatos.model.Contato

@Dao
interface ContatoDao {

    @Insert
    fun gravar(contato: Contato)

    @Query("SELECT * FROM tabela_contatos ORDER BY nome ASC")
    suspend fun getContatos(): MutableList<Contato>

}