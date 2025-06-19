package com.raphael.mock.payload.requests;

public record CotacaoRequest(
        String dataCotacao,
        Double valorCotacao,
        Integer codigoMoeda) {
}
