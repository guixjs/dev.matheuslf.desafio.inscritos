package dev.matheuslf.desafio.inscritos.application.ports.input.tarefas;

import java.util.List;

import dev.matheuslf.desafio.inscritos.application.domain.models.Tarefa;

public interface ListarTodasTarefasUseCase {
  List<Tarefa> listar();
}
