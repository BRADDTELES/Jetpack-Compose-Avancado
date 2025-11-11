package com.danilloteles.primeiroprojetocompose.repositorio

import com.danilloteles.primeiroprojetocompose.data.DataSource
import com.danilloteles.primeiroprojetocompose.listener.RespostaServidor
import javax.inject.Inject

class RepositorioMain @Inject constructor(
    private val dataSource: DataSource
) {

    fun login(email: String, senha: String, repostaServidor: RespostaServidor){
        dataSource.login(email = email, senha = senha, respostaServidor = repostaServidor)
    }

}