package dev.matheuslf.desafio.inscritos.adapter.input.controller.tarefas.dto.mapper;

import dev.matheuslf.desafio.inscritos.adapter.input.controller.projetos.dto.mapper.ProjetoMapperInput;
import dev.matheuslf.desafio.inscritos.adapter.input.controller.tarefas.dto.CriarTarefaDTORequest;
import dev.matheuslf.desafio.inscritos.adapter.input.controller.tarefas.dto.TarefaResponseDTO;
import dev.matheuslf.desafio.inscritos.application.domain.models.Status;
import dev.matheuslf.desafio.inscritos.application.domain.models.Tarefa;

public class TarefaMapperInput {

  public static Tarefa fromDtoToDomain(CriarTarefaDTORequest dto) {
    return new Tarefa(
        null,
        dto.titulo(),
        dto.descricao(),
        Status.PENDENTE,
        dto.prioridade(),
        dto.dataLimite());
  }

  public static TarefaResponseDTO fromDomainToDTO(Tarefa tarefa) {
    var projetoResponse = ProjetoMapperInput.fromDomainToDTO(tarefa.getProjeto());

    return new TarefaResponseDTO(
        tarefa.getId(),
        tarefa.getTitulo(),
        tarefa.getDescricao(),
        tarefa.getStatus(),
        tarefa.getPrioridade(),
        tarefa.getDataLimite(),
        projetoResponse);

  }
}
