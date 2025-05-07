package com.eventosprojeto;

public class TipoIngresso {
    private int id;
    private String tipo;
    private double preco;

    private Evento evento;

    public TipoIngresso(int id, String tipo, double preco, Evento evento) {
        this.id = id;
        this.tipo = tipo;
        this.preco = preco;
        this.evento = evento;
    }

    // CRUD básico
    public void criar() {
        System.out.println("Criando ingresso...");
    }

    public void ler() {
        System.out.println("Lendo ingresso...");
    }

    public void atualizar() {
        System.out.println("Atualizando ingresso...");
    }

    public void deletar() {
        System.out.println("Deletando ingresso...");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    // Getters e Setters
}

