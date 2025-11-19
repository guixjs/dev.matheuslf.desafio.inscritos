package dev.matheuslf.desafio.inscritos.adapter.input.controller.projetos.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Size;

public record AtualizarProjetoRequestDTO(
    @Size(min = 3, message = "O nome do projeto deve ter no mínimo 3 caracteres") @Size(max = 100, message = "O nome do projeto deve ter no máximo 100 caracteres")String nome,
    String descricao,
    @Future LocalDate dataFim) {

}
