package br.com.rodrigoeduque.gerenciadorMultas.model;

import jakarta.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 25)
    private String nome;

    @Column(nullable = false, length = 25)
    private String sobrenome;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(nullable = false)
    private String rg;

    @Column(nullable = false, length = 200)
    private String endereco;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, length = 14)
    private String telefone;

    public Cliente(String nome, String sobrenome, String cpf, String rg, String endereco, String email, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }

    /**
     * @deprecated construtor de uso exclusivo do hibernate
     */
    @Deprecated
    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }
}
