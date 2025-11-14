package dev.matheuslf.desafio.inscritos.application.domain.models;

import java.time.LocalDate;

public class Tarefa {
  private Long id;
  private Long titulo;
  private String descricao;
  private Status status;
  private Prioridade prioridade;
  private LocalDate dataLimite;
  private Long projetoId;

  public Tarefa(Long id, Long titulo, String descricao, Status status, Prioridade prioridade, LocalDate dataLimite,
      Long projetoId) {
    this.id = id;
    this.titulo = titulo;
    this.descricao = descricao;
    this.status = status;
    this.prioridade = prioridade;
    this.dataLimite = dataLimite;
    this.projetoId = projetoId;
  }

  public Long getId() {
    return id;
  }

  public Long getTitulo() {
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

  public Long getProjetoId() {
    return projetoId;
  }

}
