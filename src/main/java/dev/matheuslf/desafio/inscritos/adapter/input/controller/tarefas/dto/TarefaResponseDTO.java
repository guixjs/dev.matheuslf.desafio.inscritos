package dev.matheuslf.desafio.inscritos.adapter.input.controller.tarefas.dto;

import java.time.LocalDate;

import dev.matheuslf.desafio.inscritos.adapter.input.controller.projetos.dto.ProjetoResponseDTO;
import dev.matheuslf.desafio.inscritos.application.domain.models.Prioridade;
import dev.matheuslf.desafio.inscritos.application.domain.models.Status;

public record TarefaResponseDTO(
    Long id,
    String titulo,
    String descricao,
    Status status,
    Prioridade prioridade,
    LocalDate dataLimite,
    ProjetoResponseDTO projeto) {

}
