package com.example.obra.model;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Obra {
    private int id;
    private String nome;
    private String autor;
    private BigDecimal preco;
    @JsonProperty("ja_foi_vendida")
    private boolean jaFoiVendida;

    public Obra() {
    }

    public Obra(int id, String nome, String autor, BigDecimal preco, boolean jaFoiVendida) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.preco = preco;
        this.jaFoiVendida = jaFoiVendida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public boolean jaFoiVendida() {
        return jaFoiVendida;
    }

    public void setJaFoiVendida(boolean jaFoiVendida) {
        this.jaFoiVendida = jaFoiVendida;
    }
}