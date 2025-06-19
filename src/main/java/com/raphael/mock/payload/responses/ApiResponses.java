package com.raphael.mock.payload.responses;

import java.util.List;

public record ApiResponses<T>(
        String message,
        T data
) {
    public static <T> ApiResponses<T> insertMessage(T cotacao) {
        return new ApiResponses<>(
                "Cotacao adicionada com sucesso.",
                cotacao
        );
    }

    public static <T> ApiResponses<List<T>> findAllMessage(List<T> cotacaoList) {
        return new ApiResponses<>(
                "Requisição realizada com sucesso.",
                cotacaoList
        );
    }

    public static <T> ApiResponses<Void> deleteMessage() {
        return new ApiResponses<>(
                "Cotacao deletada com sucesso.",
                null
        );
    }

}
