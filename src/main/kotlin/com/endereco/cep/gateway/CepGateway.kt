package com.endereco.cep.gateway

import com.endereco.cep.gateway.data.request.CepGatewayRequest
import com.endereco.cep.gateway.data.response.CepGatewayResponse

interface CepGateway {

    fun findAddress(gatewayRequest: CepGatewayRequest): CepGatewayResponse
}