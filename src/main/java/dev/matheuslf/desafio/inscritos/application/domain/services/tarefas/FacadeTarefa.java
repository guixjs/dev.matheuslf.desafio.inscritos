package dev.matheuslf.desafio.inscritos.application.domain.services.tarefas;

import java.util.List;

import dev.matheuslf.desafio.inscritos.application.domain.models.Tarefa;
import dev.matheuslf.desafio.inscritos.application.ports.input.tarefas.CriarTarefaUseCase;
import dev.matheuslf.desafio.inscritos.application.ports.input.tarefas.ListarTodasTarefasUseCase;

public class FacadeTarefa {

  private final CriarTarefaUseCase criar;
  private final ListarTodasTarefasUseCase listar;

  public FacadeTarefa(CriarTarefaUseCase criarTarefaUseCase, ListarTodasTarefasUseCase listar) {
    this.criar = criarTarefaUseCase;
    this.listar = listar;
  }

  public Tarefa criarTarefa(Long idProjeto, Tarefa tarefa) {
    return this.criar.execute(idProjeto, tarefa);
  }

  public List<Tarefa> listarTodas() {
    return this.listar.execute();
  }
}
