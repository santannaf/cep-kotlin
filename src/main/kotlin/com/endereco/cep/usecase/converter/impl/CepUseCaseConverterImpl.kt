package com.endereco.cep.usecase.converter.impl

import com.endereco.cep.gateway.data.request.CepGatewayRequest
import com.endereco.cep.gateway.data.response.CepGatewayResponse
import com.endereco.cep.usecase.converter.CepUseCaseConverter
import com.endereco.cep.usecase.data.request.CepUseCaseRequest
import com.endereco.cep.usecase.data.response.CepUseCaseResponse
import org.springframework.stereotype.Component

@Component
class CepUseCaseConverterImpl : CepUseCaseConverter {

    override fun converterToUseCaseResponse(gatewayResponse: CepGatewayResponse): CepUseCaseResponse {
        return CepUseCaseResponse(
                gatewayResponse.logradouro,
                gatewayResponse.complemento,
                gatewayResponse.bairro,
                gatewayResponse.localidade,
                gatewayResponse.uf
        )
    }

    override fun converterToGatewayRequest(useCaseRequest: CepUseCaseRequest): CepGatewayRequest {
        return CepGatewayRequest(useCaseRequest.cep)
    }
}