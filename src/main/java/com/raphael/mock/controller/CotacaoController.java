package com.raphael.mock.controller;

import com.raphael.mock.payload.requests.CotacaoRequest;
import com.raphael.mock.payload.responses.ApiResponses;
import com.raphael.mock.payload.responses.CotacaoResponse;
import com.raphael.mock.service.CotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cotacao/v1")
public class CotacaoController {

    @Autowired
    CotacaoService service;

    @PostMapping
    public ResponseEntity<ApiResponses<CotacaoResponse>> insert(@RequestBody CotacaoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(request));
    }

    @GetMapping
    public ResponseEntity<ApiResponses<List<CotacaoResponse>>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping
    public ResponseEntity<ApiResponses<Void>> deleteById(@RequestParam("id") Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
