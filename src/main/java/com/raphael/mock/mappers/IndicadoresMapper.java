package com.raphael.mock.mappers;

import com.raphael.mock.model.Indicadores;
import com.raphael.mock.payload.responses.IndicadoresResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IndicadoresMapper {
    @Mapping(source = "codigoMoeda", target = "codigoMoeda")
    @Mapping(source = "dataInicio", target = "dataInicio")
    @Mapping(source = "dataFim", target = "dataFim")
    IndicadoresResponse toDTO(Indicadores indicadores);

}
