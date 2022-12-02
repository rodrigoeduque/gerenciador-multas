package br.com.rodrigoeduque.gerenciadorMultas.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String placa;

    @Column(nullable = false)
    private String renavan;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private Integer ano;

    @Column(nullable = false)
    private BigDecimal valor;

    @ManyToOne(optional = false)
    private Cliente cliente;

    @Deprecated
    public Carro() {
    }

    public Carro(String placa,
                 String renavan,
                 String marca,
                 String modelo,
                 Integer ano,
                 BigDecimal valor,
                 Cliente cliente) {
        this.placa = placa;
        this.renavan = renavan;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valor = valor;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }
}
