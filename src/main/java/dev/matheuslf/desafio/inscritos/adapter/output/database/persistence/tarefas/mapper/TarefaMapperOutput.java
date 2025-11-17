package dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.tarefas.mapper;

import dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.tarefas.entity.TarefaJPA;
import dev.matheuslf.desafio.inscritos.application.domain.models.Tarefa;

public class TarefaMapperOutput {

  public static Tarefa fromEntityToDomain(TarefaJPA entity) {
    return new Tarefa(
        entity.getId(),
        entity.getTitulo(),
        entity.getDescricao(),
        entity.getStatus(),
        entity.getPrioridade(),
        entity.getDataLimite(),
        null);

  }
}
