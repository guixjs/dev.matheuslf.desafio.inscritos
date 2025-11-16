package dev.matheuslf.desafio.inscritos.application.domain.models;

import java.time.LocalDate;

public class Tarefa {
  private Long id;
  private String titulo;
  private String descricao;
  private Status status;
  private Prioridade prioridade;
  private LocalDate dataLimite;
  private Projeto projeto;

  public Tarefa(Long id, String titulo, String descricao, Status status, Prioridade prioridade, LocalDate dataLimite) {
    this.id = id;
    this.titulo = titulo;
    this.descricao = descricao;
    this.status = status;
    this.prioridade = prioridade;
    this.dataLimite = dataLimite;
  }

  public Tarefa(Long id, String titulo, String descricao, Status status, Prioridade prioridade, LocalDate dataLimite,
      Projeto projeto) {
    this.id = id;
    this.titulo = titulo;
    this.descricao = descricao;
    this.status = status;
    this.prioridade = prioridade;
    this.dataLimite = dataLimite;
    this.projeto = projeto;
  }

  public void setProjeto(Projeto projeto) {
    this.projeto = projeto;
  }

  public Long getId() {
    return id;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getDescricao() {
    return descricao;
  }

  public Status getStatus() {
    return status;
  }

  public Prioridade getPrioridade() {
    return prioridade;
  }

  public LocalDate getDataLimite() {
    return dataLimite;
  }

  public Projeto getProjeto() {
    return projeto;
  }

}
