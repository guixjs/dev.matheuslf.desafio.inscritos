package dev.matheuslf.desafio.inscritos.application.ports.input.tarefas;

import dev.matheuslf.desafio.inscritos.application.domain.models.Tarefa;

public interface CriarTarefaUseCase {

  Tarefa criarTarefa(Long idProjeto, Tarefa tarefa);
}
