package com.raphael.mock.controller;

import com.raphael.mock.payload.requests.IndicadoresRequest;
import com.raphael.mock.payload.responses.ApiResponses;
import com.raphael.mock.payload.responses.CotacaoResponseSimple;
import com.raphael.mock.payload.responses.IndicadoresResponse;
import com.raphael.mock.service.IndicadoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/indicadores")
public class IndicadoresController {

    @Autowired
    IndicadoresService service;

    @PostMapping
    public ResponseEntity<ApiResponses<IndicadoresResponse>> insert(@RequestBody IndicadoresRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(request));
    }

    @PostMapping("/cotacao")
    public ResponseEntity<List<CotacaoResponseSimple>> buscarPorCodigoMoeda(@RequestBody IndicadoresRequest request) {
        return ResponseEntity.ok(service.buscarPorCodigo(request));
    }
}
