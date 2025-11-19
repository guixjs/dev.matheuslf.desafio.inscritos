package dev.matheuslf.desafio.inscritos.application.domain.models;

import java.time.LocalDate;

public class AtualizarProjetoDomain {
  private String nome;
  private String descricao;
  private LocalDate dataFim;

  public AtualizarProjetoDomain(String nome, String descricao, LocalDate dataFim) {
    this.nome = nome;
    this.descricao = descricao;
    this.dataFim = dataFim;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public LocalDate getDataFim() {
    return dataFim;
  }

  public void setDataFim(LocalDate dataFim) {
    this.dataFim = dataFim;
  }

}
