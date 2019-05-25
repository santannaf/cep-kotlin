package com.endereco.cep.http

import com.endereco.cep.http.converter.CepConverter
import com.endereco.cep.http.data.request.CepRequest
import com.endereco.cep.http.data.response.CepResponse
import com.endereco.cep.usecase.CepUseCase
import com.endereco.cep.usecase.data.request.CepUseCaseRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.constraints.NotNull

@RestController
class CepController(private val converter: CepConverter, private val useCase: CepUseCase) {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/endereco/{cep}")
    fun findAddress(@NotNull @PathVariable cep: String): ResponseEntity<CepResponse> {

        val request: CepRequest = converter.converterToRequest(cep)
        val useCaseRequest: CepUseCaseRequest = converter.converterToUseCaseRequest(request)
        val response: CepResponse = converter.converterToResponse(useCase.findAddressByZipCode(useCaseRequest))

        return ResponseEntity<CepResponse>(response, HttpStatus.OK);
    }





}