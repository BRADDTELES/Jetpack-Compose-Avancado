package com.danilloteles.primeiroprojetocompose.viewmodel

import androidx.lifecycle.ViewModel
import com.danilloteles.primeiroprojetocompose.listener.RespostaServidor
import com.danilloteles.primeiroprojetocompose.repositorio.RepositorioMain
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repositorioMain: RepositorioMain
) : ViewModel() {

    fun login(email: String, senha: String, respostaServidor: RespostaServidor) {
        repositorioMain.login(email = email, senha = senha, repostaServidor = respostaServidor)
    }

}