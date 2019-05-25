package com.endereco.cep.gateway.impl

import com.endereco.cep.gateway.CepGateway
import com.endereco.cep.gateway.data.request.CepGatewayRequest
import com.endereco.cep.gateway.data.response.CepGatewayResponse
import org.springframework.http.*
import org.springframework.stereotype.Component
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestTemplate
import java.util.*

@Component
class CepGatewayImpl(private val restTemplate: RestTemplate): CepGateway {

    override fun findAddress(gatewayRequest: CepGatewayRequest): CepGatewayResponse {

        val response: ResponseEntity<CepGatewayResponse> = restTemplate.exchange("https://viacep.com.br/ws/" + gatewayRequest.cep + "/json/",
                HttpMethod.GET,
                HttpEntity<String>("", getHeaders()),
                CepGatewayResponse::class.java)

        val gatewayResponse =  CepGatewayResponse(response.body?.logradouro,
                response.body?.complemento,
                response.body?.bairro,
                response.body?.localidade,
                response.body?.uf
                )

        return gatewayResponse
    }

    private fun getHeaders(): HttpHeaders {

        val headers = HttpHeaders()
        headers.accept = Arrays.asList(MediaType.APPLICATION_JSON)
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36")

        return headers
    }
}