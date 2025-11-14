package dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "projetos")
public class ProjetoJPA {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String nome;
  private String descricao;
  private LocalDate dataInicio;
  private LocalDate dataFim;

  public ProjetoJPA(String nome, String descricao, LocalDate dataInicio, LocalDate dataFim) {
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

}
