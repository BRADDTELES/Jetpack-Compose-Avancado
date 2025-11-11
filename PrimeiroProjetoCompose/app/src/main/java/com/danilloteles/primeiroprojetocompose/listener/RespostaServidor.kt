package com.danilloteles.primeiroprojetocompose.listener

interface RespostaServidor {
    
    fun onSucess(mensagem: String)
    fun onFailure(erro: String)
    
}