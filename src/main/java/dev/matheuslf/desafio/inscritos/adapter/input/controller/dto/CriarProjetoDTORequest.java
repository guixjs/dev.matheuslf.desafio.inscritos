package dev.matheuslf.desafio.inscritos.adapter.input.controller.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CriarProjetoDTORequest(
        @NotBlank(message = "O nome do projeto é obrigatório") @Size(min = 3, message = "O nome do projeto deve ter no mínimo 3 caracteres") @Size(max = 100, message = "O nome do projeto deve ter no máximo 100 caracteres") String nome,

        @NotBlank(message = "A descrição do projeto é obrigatória") String descricao,
        @NotNull(message = "A data de início do projeto é obrigatória") LocalDate dataInicio,
        LocalDate dataFim) {

}
