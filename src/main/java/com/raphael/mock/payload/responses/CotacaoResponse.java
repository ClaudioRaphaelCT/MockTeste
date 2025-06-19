package com.raphael.mock.payload.responses;

public record CotacaoResponse(
        Long id,
        String dataCotacao,
        Double valorCotacao,
        Integer codigoMoeda) {
}
