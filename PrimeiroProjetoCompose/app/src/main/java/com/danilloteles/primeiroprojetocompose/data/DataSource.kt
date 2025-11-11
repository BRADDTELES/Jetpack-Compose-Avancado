package com.danilloteles.primeiroprojetocompose.data

import com.danilloteles.primeiroprojetocompose.listener.RespostaServidor

class DataSource {
    
    fun login(email: String, senha: String, respostaServidor: RespostaServidor) {
        if ( email.isEmpty() || senha.isEmpty() ) {
            respostaServidor.onFailure("Preencha todos os campos!")
        } else if (  email == "admin@gmail.com" && senha == "123456"  ) {
            respostaServidor.onSucess("Sucesso ao fazer o login!")
        } else {
            respostaServidor.onFailure("Erro ao fazer o login no sistema!")
        }
    }
    
}