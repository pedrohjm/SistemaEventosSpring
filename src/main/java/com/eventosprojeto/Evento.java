package com.eventosprojeto;

import java.util.Date;
import java.util.List;

public class Evento {
    private int id;
    private String nome;
    private Date data;
    private String local;
    private String descricao;
    private Usuario organizador;
    private List<Usuario> listaParticipantes;
    private int qtdIngressos;

    public Evento(int id, String nome, Date data, String local, String descricao,
                  Usuario organizador, List<Usuario> listaParticipantes, int qtdIngressos) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.descricao = descricao;
        this.organizador = organizador;
        this.listaParticipantes = listaParticipantes;
        this.qtdIngressos = qtdIngressos;
    }

    // Getters e Setters

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Usuario organizador) {
        this.organizador = organizador;
    }

    public List<Usuario> getListaParticipantes() {
        return listaParticipantes;
    }

    public void setListaParticipantes(List<Usuario> listaParticipantes) {
        this.listaParticipantes = listaParticipantes;
    }

    public int getQtdIngressos() {
        return qtdIngressos;
    }

    public void setQtdIngressos(int qtdIngressos) {
        this.qtdIngressos = qtdIngressos;
    }
}
