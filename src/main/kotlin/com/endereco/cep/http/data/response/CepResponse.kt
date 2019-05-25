package com.endereco.cep.http.data.response

data class CepResponse(
    val logradouro: String?,
    val complemento: String?,
    val bairro: String?,
    val localidade: String?,
    val uf: String?){
}