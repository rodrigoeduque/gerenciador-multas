package br.com.rodrigoeduque.gerenciadorMultas.controller.dto;

import br.com.rodrigoeduque.gerenciadorMultas.model.Carro;
import br.com.rodrigoeduque.gerenciadorMultas.model.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

public class CarroRequest {

    @NotBlank
    private String placa;

    @NotBlank
    @Length(min = 11, max = 11)
    private String renavan;

    @NotBlank
    private String marca;

    @NotBlank
    private String modelo;

    @NotNull
    @Positive
    private Integer ano;

    @NotNull
    @Positive
    private BigDecimal valor;

    public CarroRequest(String placa, String renavan, String marca, String modelo, Integer ano, BigDecimal valor) {
        this.placa = placa;
        this.renavan = renavan;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valor = valor;
    }

    @Deprecated
    public CarroRequest() {
    }

    public String getPlaca() {
        return placa;
    }

    public String getRenavan() {
        return renavan;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Carro toCarro(Cliente cliente) {
        return new Carro(placa, renavan, marca, modelo, ano, valor, cliente);
    }
}
