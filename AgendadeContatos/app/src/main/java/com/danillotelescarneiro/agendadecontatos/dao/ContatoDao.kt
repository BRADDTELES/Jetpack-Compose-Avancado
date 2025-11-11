package com.danillotelescarneiro.agendadecontatos.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.danillotelescarneiro.agendadecontatos.model.Contato

@Dao
interface ContatoDao {

    @Insert
    fun gravar(contato: Contato)

    @Query("SELECT * FROM tabela_contatos ORDER BY nome ASC")
    suspend fun getContatos(): MutableList<Contato>

    @Query("UPDATE tabela_contatos SET nome = :novoNome, sobrenome = :novoSobrenome, idade = :novaIdade, celular = :novoCelular WHERE uid = :id")
    fun atualizar(id: Int, novoNome: String, novoSobrenome: String, novaIdade: String, novoCelular: String)

}