package com.raphael.mock.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "indicadores")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Indicadores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "codigo_moeda")
    private Integer codigoMoeda;
    @Column(name = "data_inicio")
    private String dataInicio;
    @Column(name = "data_fim")
    private String dataFim;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_moeda", referencedColumnName = "codigo_moeda", insertable = false, updatable = false)
    private List<Cotacao> cotacoes;

    @PrePersist
    protected void setCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }
}
