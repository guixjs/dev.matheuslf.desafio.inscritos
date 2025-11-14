package dev.matheuslf.desafio.inscritos.application.domain.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Projeto {

  private Long id;
  private String nome;
  private String descricao;
  private LocalDate dataInicio;
  private LocalDate dataFim;
  private List<Tarefa> tarefas = new ArrayList<>();

  public Projeto(Long id, String nome, String descricao, LocalDate dataInicio, LocalDate dataFim) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.dataInicio = dataInicio;
    this.dataFim = dataFim;
  }

  public Long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public LocalDate getDataInicio() {
    return dataInicio;
  }

  public LocalDate getDataFim() {
    return dataFim;
  }

  public List<Tarefa> getTarefas() {
    return tarefas;
  }
}
