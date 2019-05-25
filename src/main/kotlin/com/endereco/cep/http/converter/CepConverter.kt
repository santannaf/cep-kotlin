package com.endereco.cep.http.converter

import com.endereco.cep.http.data.request.CepRequest
import com.endereco.cep.http.data.response.CepResponse
import com.endereco.cep.usecase.data.request.CepUseCaseRequest
import com.endereco.cep.usecase.data.response.CepUseCaseResponse

interface CepConverter {

    fun converterToRequest(cep: String): CepRequest
    fun converterToUseCaseRequest(request: CepRequest): CepUseCaseRequest
    fun converterToResponse(useCaseResponse: CepUseCaseResponse): CepResponse
}