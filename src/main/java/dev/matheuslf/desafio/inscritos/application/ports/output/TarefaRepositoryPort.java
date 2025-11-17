package dev.matheuslf.desafio.inscritos.application.ports.output;

import java.util.List;

import dev.matheuslf.desafio.inscritos.application.domain.models.Tarefa;

public interface TarefaRepositoryPort {

  Tarefa salvar(Tarefa tarefa);

  List<Tarefa> listarTodas();
}
