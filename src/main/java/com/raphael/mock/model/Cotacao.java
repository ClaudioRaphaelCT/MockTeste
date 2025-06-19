package com.raphael.mock.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "cotacao")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Cotacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "data_cotacao")
    private String dataCotacao;
    @Column(name = "valor_cotacao")
    private Double valorCotacao;
    // --- Campo adicionado para o relacionamento ---
    @Column(name = "codigo_moeda")
    private Integer codigoMoeda; // Campo para ligar a cotação a um código de moeda
    // ---------------------------------------------

    @PrePersist
    protected void setCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }
}
