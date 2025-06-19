package com.raphael.mock.service;

import com.raphael.mock.mappers.CotacaoMapper;
import com.raphael.mock.mappers.IndicadoresMapper;
import com.raphael.mock.model.Cotacao;
import com.raphael.mock.model.Indicadores;
import com.raphael.mock.payload.requests.IndicadoresRequest;
import com.raphael.mock.payload.responses.ApiResponses;
import com.raphael.mock.payload.responses.CotacaoResponseSimple;
import com.raphael.mock.payload.responses.IndicadoresResponse;
import com.raphael.mock.repositories.CotacaoRepository;
import com.raphael.mock.repositories.IndicadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IndicadoresService {
    @Autowired
    IndicadoresRepository repository;
    @Autowired
    IndicadoresMapper mapper;
    @Autowired
    CotacaoRepository cotacaoRepository;
    @Autowired
    CotacaoMapper cotacaoMapper;

    public ApiResponses<IndicadoresResponse> insert(IndicadoresRequest request) {
        Indicadores indicadores = Indicadores.builder()
                .codigoMoeda(request.codigoMoeda())
                .dataInicio(request.dataInicio())
                .dataFim(request.dataFim())
                .build();
        repository.save(indicadores);
        IndicadoresResponse response = mapper.toDTO(indicadores);
        return ApiResponses.insertMessage(response);
    }

    public List<CotacaoResponseSimple> buscarPorCodigo(IndicadoresRequest request) {
        List<Cotacao> cotacoes = cotacaoRepository.findByCodigoMoeda(request.codigoMoeda());
        List<CotacaoResponseSimple> responseList = cotacoes.stream().map(cotacaoMapper::toDTOSimple).collect(Collectors.toList());
        return responseList;
    }
}
