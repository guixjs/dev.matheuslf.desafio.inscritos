package dev.matheuslf.desafio.inscritos.adapter.input.controller.tarefas.dto;

import java.time.LocalDate;

import dev.matheuslf.desafio.inscritos.application.domain.models.Prioridade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CriarTarefaRequestDTO(
        @NotBlank(message = "O título da tarefa é obrigatório") @Size(min = 5, message = "O título da tarefa deve ter no mínimo 5 caracteres") @Size(max = 150, message = "O título da tarefa deve ter no máximo 150 caracteres") String titulo,
        String descricao,
        @NotNull(message = "É obrigatório informar a prioridade da tarefa") Prioridade prioridade,
        @NotNull(message = "A data limite da tarefa é obrigatória") LocalDate dataLimite,
        @NotNull(message = "O id do projeto é obrigatório") Long projetoId) {

}
