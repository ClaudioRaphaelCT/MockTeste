package com.raphael.mock.payload.responses;

public record IndicadoresResponse(
        Long id,
        Integer codigoMoeda,
        String dataInicio,
        String dataFim) {
}
