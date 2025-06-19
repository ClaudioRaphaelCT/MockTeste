package com.raphael.mock.service;

import com.raphael.mock.mappers.CotacaoMapper;
import com.raphael.mock.model.Cotacao;
import com.raphael.mock.payload.requests.CotacaoRequest;
import com.raphael.mock.payload.responses.ApiResponses;
import com.raphael.mock.payload.responses.CotacaoResponse;
import com.raphael.mock.repositories.CotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CotacaoService {
    @Autowired
    CotacaoMapper mapper;
    @Autowired
    CotacaoRepository repository;

    public ApiResponses<CotacaoResponse> insert(CotacaoRequest request) {
        Cotacao cotacao = Cotacao.builder()
                .dataCotacao(request.dataCotacao())
                .valorCotacao(request.valorCotacao())
                .codigoMoeda(request.codigoMoeda())
                .build();
        Cotacao saved = repository.save(cotacao);
        CotacaoResponse response = mapper.toDTO(saved);
        return ApiResponses.insertMessage(response);
    }

    public ApiResponses<List<CotacaoResponse>> findAll() {
        List<Cotacao> cotacaoList = repository.findAll();
        List<CotacaoResponse> response = mapper.toDTOList(cotacaoList);
        return ApiResponses.findAllMessage(response);
    }

    public ApiResponses<Void> delete(Long id) {
        repository.deleteById(id);
        return ApiResponses.deleteMessage();
    }
}
