package com.raphael.mock.payload.responses;

public record CotacaoResponseSimple(
        String dataCotacao,
        Double valorCotacao,
        Integer codigoMoeda) {
}
