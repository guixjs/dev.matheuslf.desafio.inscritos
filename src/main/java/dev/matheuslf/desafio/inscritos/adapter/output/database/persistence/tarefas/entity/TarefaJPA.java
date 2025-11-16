package dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.tarefas.entity;

import java.time.LocalDate;

import dev.matheuslf.desafio.inscritos.application.domain.models.Prioridade;
import dev.matheuslf.desafio.inscritos.application.domain.models.Status;
import dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.projetos.entity.ProjetoJPA;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "tarefas")
public class TarefaJPA {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String titulo;
  private String descricao;

  @Enumerated(EnumType.STRING)
  private Status status;

  @Enumerated(EnumType.STRING)
  private Prioridade prioridade;
  private LocalDate dataLimite;

  @ManyToOne
  @JoinColumn(name = "projeto_id", nullable = false)
  private ProjetoJPA projeto;

  public TarefaJPA() {
  }

  public TarefaJPA(String titulo, String descricao, Status status, Prioridade prioridade, LocalDate dataLimite,
      ProjetoJPA projeto) {
    this.titulo = titulo;
    this.descricao = descricao;
    this.status = status;
    this.prioridade = prioridade;
    this.dataLimite = dataLimite;
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

  public ProjetoJPA getProjeto() {
    return projeto;
  }

}
