package dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.projetos.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.tarefas.entity.TarefaJPA;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

  @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  private List<TarefaJPA> tarefas = new ArrayList<>();

  public ProjetoJPA(String nome, String descricao, LocalDate dataInicio, LocalDate dataFim) {
    this.nome = nome;
    this.descricao = descricao;
    this.dataInicio = dataInicio;
    this.dataFim = dataFim;
  }

  public ProjetoJPA() {
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

  public List<TarefaJPA> getTarefas() {
    return tarefas;
  }
}
