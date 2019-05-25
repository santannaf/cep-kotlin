package com.endereco.cep.http.converter.impl

import com.endereco.cep.http.converter.CepConverter
import com.endereco.cep.http.data.request.CepRequest
import com.endereco.cep.http.data.response.CepResponse
import com.endereco.cep.usecase.data.request.CepUseCaseRequest
import com.endereco.cep.usecase.data.response.CepUseCaseResponse
import org.springframework.stereotype.Component

@Component
class CepConverterImpl: CepConverter {

    override fun converterToResponse(useCaseResponse: CepUseCaseResponse): CepResponse {
        return CepResponse(
                useCaseResponse.logradouro,
                useCaseResponse.complemento,
                useCaseResponse.bairro,
                useCaseResponse.localidade,
                useCaseResponse.uf
        )
    }

    override fun converterToRequest(cep: String): CepRequest {
        return CepRequest(cep)
    }

    override fun converterToUseCaseRequest(request: CepRequest): CepUseCaseRequest {
        return CepUseCaseRequest(request.cep)
    }
}