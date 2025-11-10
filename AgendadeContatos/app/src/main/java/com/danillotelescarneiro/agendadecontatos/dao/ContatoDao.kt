package com.danillotelescarneiro.agendadecontatos.dao

import androidx.room.Dao
import androidx.room.Insert
import com.danillotelescarneiro.agendadecontatos.model.Contato

@Dao
interface ContatoDao {

    @Insert
    fun gravar(contato: Contato)

}