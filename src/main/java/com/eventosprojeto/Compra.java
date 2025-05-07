package com.eventosprojeto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Compra {
    private int id;
    private LocalDate data;
    private LocalTime hora;
    private String formaPagamento;
    private String status;

    private Usuario comprador;
    private List<TipoIngresso> ingressos;

    public Compra(int id, LocalDate data, LocalTime hora, String formaPagamento, String status,
                  Usuario comprador, List<TipoIngresso> ingressos) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.formaPagamento = formaPagamento;
        this.status = status;
        this.comprador = comprador;
        this.ingressos = ingressos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Usuario getComprador() {
        return comprador;
    }

    public void setComprador(Usuario comprador) {
        this.comprador = comprador;
    }

    public List<TipoIngresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(List<TipoIngresso> ingressos) {
        this.ingressos = ingressos;
    }

    // Getters e Setters
}
