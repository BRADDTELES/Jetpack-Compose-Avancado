package com.danilloteles.buscadordecep.ui.theme.datasource

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import javax.inject.Inject

class Servidor @Inject constructor() {

    val httpClient = HttpClient{
        install(ContentNegotiation){
            json()
        }
    }

    suspend fun buscarCep(
        cep: String,
        respostaDoServidor: (String, String, String, String) -> Unit,
        mensagemErro: (String) -> Unit
    ) {

        val respostaServidor = httpClient.get(
            urlString = "https://viacep.com.br/ws/${cep}/json/"
        )

        try {
            if (respostaServidor.status.value == 200) {
                val endereco = Json.parseToJsonElement(respostaServidor.bodyAsText()).jsonObject
                val logradouro = endereco["logradouro"]!!.jsonPrimitive.content
                val bairro = endereco["bairro"]!!.jsonPrimitive.content
                val localidade = endereco["localidade"]!!.jsonPrimitive.content
                val uf = endereco["uf"]!!.jsonPrimitive.content
                respostaDoServidor(logradouro, bairro, localidade, uf)
            } else {
                mensagemErro("Cep inválido")
            }
        } catch (e: Exception) {
            Log.e("Erro de servidor", "${e.message}")
        }

    }
}