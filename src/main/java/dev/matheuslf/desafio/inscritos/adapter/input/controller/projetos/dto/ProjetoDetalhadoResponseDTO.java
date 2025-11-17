package dev.matheuslf.desafio.inscritos.adapter.input.controller.projetos.dto;

import java.time.LocalDate;
import java.util.List;

import dev.matheuslf.desafio.inscritos.adapter.input.controller.tarefas.dto.TarefaResumoResponseDTO;

public record ProjetoDetalhadoResponseDTO(
    Long id,
    String nome,
    String descricao,
    LocalDate dataInicio,
    LocalDate dataFim,
    Long qtdTarefas,
    Long qtdTarefasPendentes,
    Long qtdTarefasEmAndamento,
    Long qtdTarefasConcluidas,
    List<TarefaResumoResponseDTO> tarefas) {

}
