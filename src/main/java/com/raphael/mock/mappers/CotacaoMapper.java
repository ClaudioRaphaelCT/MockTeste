package com.raphael.mock.mappers;

import com.raphael.mock.model.Cotacao;
import com.raphael.mock.payload.responses.CotacaoResponse;
import com.raphael.mock.payload.responses.CotacaoResponseSimple;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CotacaoMapper {

    @Mapping(source = "dataCotacao", target = "dataCotacao")
    @Mapping(source = "valorCotacao", target = "valorCotacao")
    @Mapping(source = "codigoMoeda", target = "codigoMoeda")
    CotacaoResponse toDTO(Cotacao cotacao);

    @Mapping(source = "dataCotacao", target = "dataCotacao")
    @Mapping(source = "valorCotacao", target = "valorCotacao")
    @Mapping(source = "codigoMoeda", target = "codigoMoeda")
    List<CotacaoResponse> toDTOList(List<Cotacao> cotacaoList);

    // Adicione este novo método para o response simplificado
    @Mapping(source = "dataCotacao", target = "dataCotacao")
    @Mapping(source = "valorCotacao", target = "valorCotacao")
    @Mapping(source = "codigoMoeda", target = "codigoMoeda")
    CotacaoResponseSimple toDTOSimple(Cotacao cotacao); // Novo método aqui
}
