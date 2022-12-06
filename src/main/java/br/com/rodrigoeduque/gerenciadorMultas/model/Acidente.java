package br.com.rodrigoeduque.gerenciadorMultas.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Acidente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate dataAcontecimento;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String observacoes;

    @ManyToOne(optional = false)
    private Carro carro;

    public Acidente(LocalDate dataAcontecimento, String cidade, String estado, String logradouro, String bairro, String cep, String observacoes, Carro carro) {
        this.dataAcontecimento = dataAcontecimento;
        this.cidade = cidade;
        this.estado = estado;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
        this.observacoes = observacoes;
        this.carro = carro;
    }

    @Deprecated
    public Acidente() {
    }

    public Long getId() {
        return id;
    }
}
