package com.endereco.cep.usecase.converter

import com.endereco.cep.gateway.data.request.CepGatewayRequest
import com.endereco.cep.gateway.data.response.CepGatewayResponse
import com.endereco.cep.usecase.data.request.CepUseCaseRequest
import com.endereco.cep.usecase.data.response.CepUseCaseResponse

interface CepUseCaseConverter {

    fun converterToGatewayRequest(useCaseRequest: CepUseCaseRequest): CepGatewayRequest
    fun converterToUseCaseResponse(gatewayResponse: CepGatewayResponse): CepUseCaseResponse
}