package dev.matheuslf.desafio.inscritos.adapter.input.controller.projetos.dto;

import java.time.LocalDate;

public record ProjetoResponseDTO(Long id, String nome, String descricao, LocalDate dataInicio, LocalDate dataFim) {

}
