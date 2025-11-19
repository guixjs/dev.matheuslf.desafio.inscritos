package dev.matheuslf.desafio.inscritos.application.domain.services.tarefas.impl;

import java.util.List;

import dev.matheuslf.desafio.inscritos.application.domain.models.Tarefa;
import dev.matheuslf.desafio.inscritos.application.ports.input.tarefas.ListarTodasTarefasUseCase;
import dev.matheuslf.desafio.inscritos.application.ports.output.TarefaRepositoryPort;

public class ListarTodasTarefasService implements ListarTodasTarefasUseCase {

  private final TarefaRepositoryPort tarefaRepository;

  public ListarTodasTarefasService(TarefaRepositoryPort tarefaRepository) {
    this.tarefaRepository = tarefaRepository;
  }

  @Override
  public List<Tarefa> execute() {
    return this.tarefaRepository.listarTodas();
  }

}
