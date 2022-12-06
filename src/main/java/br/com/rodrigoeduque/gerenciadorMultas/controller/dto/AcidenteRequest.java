package br.com.rodrigoeduque.gerenciadorMultas.controller.dto;

import br.com.rodrigoeduque.gerenciadorMultas.model.Acidente;
import br.com.rodrigoeduque.gerenciadorMultas.model.Carro;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class AcidenteRequest {

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAcontecimento;
    @NotBlank
    private String cidade;
    @NotBlank
    private String estado;
    @NotBlank
    private String logradouro;
    @NotBlank
    private String bairro;
    @NotBlank
    private String cep;
    @NotBlank
    private String observacoes;

    public AcidenteRequest() {
    }

    public AcidenteRequest(LocalDate dataAcontecimento, String cidade, String estado, String logradouro, String bairro, String cep, String observacoes) {
        this.dataAcontecimento = dataAcontecimento;
        this.cidade = cidade;
        this.estado = estado;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
        this.observacoes = observacoes;
    }

    public Acidente toAcidente(Carro carro) {
        return new Acidente(dataAcontecimento, cidade, estado, logradouro, bairro, cep, observacoes, carro);
    }

    public LocalDate getDataAcontecimento() {
        return dataAcontecimento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public String getObservacoes() {
        return observacoes;
    }
}
