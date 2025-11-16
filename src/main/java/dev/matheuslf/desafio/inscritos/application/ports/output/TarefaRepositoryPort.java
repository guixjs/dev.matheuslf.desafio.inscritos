package dev.matheuslf.desafio.inscritos.application.ports.output;

import dev.matheuslf.desafio.inscritos.application.domain.models.Tarefa;

public interface TarefaRepositoryPort {

  Tarefa salvar(Tarefa tarefa);
}
