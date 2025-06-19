package com.raphael.mock.repositories;

import com.raphael.mock.model.Cotacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CotacaoRepository extends JpaRepository<Cotacao, Long> {
    // Se preferir buscar apenas pelo codigoMoeda, sem o range de datas
    List<Cotacao> findByCodigoMoeda(Integer codigoMoeda);
}
