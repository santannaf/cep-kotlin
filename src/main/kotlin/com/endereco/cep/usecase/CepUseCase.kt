package com.endereco.cep.usecase

import com.endereco.cep.usecase.data.request.CepUseCaseRequest
import com.endereco.cep.usecase.data.response.CepUseCaseResponse

interface CepUseCase {

    fun findAddressByZipCode(useCaseRequest: CepUseCaseRequest): CepUseCaseResponse
}