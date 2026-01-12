package com.brian.delivery.delivery_api.model;

import jakarta.persistence.*;

@Entity
public class Destinatario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;

    // Relación ManyToOne: Muchos destinatarios pueden vivir en la misma dirección (CEP)
    @ManyToOne
    private Localizacao localizacao;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Localizacao getLocalizacao() { return localizacao; }
    public void setLocalizacao(Localizacao localizacao) { this.localizacao = localizacao; }
}