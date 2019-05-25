package com.endereco.cep.usecase.impl

import com.endereco.cep.gateway.CepGateway
import com.endereco.cep.gateway.data.request.CepGatewayRequest
import com.endereco.cep.usecase.CepUseCase
import com.endereco.cep.usecase.converter.CepUseCaseConverter
import com.endereco.cep.usecase.data.request.CepUseCaseRequest
import com.endereco.cep.usecase.data.response.CepUseCaseResponse
import org.springframework.stereotype.Component

@Component
class CepUseCaseImpl(private val converter: CepUseCaseConverter, private val gateway: CepGateway): CepUseCase {

    override fun findAddressByZipCode(useCaseRequest: CepUseCaseRequest): CepUseCaseResponse {

        val gatewayRequest: CepGatewayRequest = converter.converterToGatewayRequest(useCaseRequest)
        val response: CepUseCaseResponse = converter.converterToUseCaseResponse(gateway.findAddress(gatewayRequest))

        return response
    }
}