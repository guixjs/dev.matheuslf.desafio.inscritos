package dev.matheuslf.desafio.inscritos.adapter.input.controller.dto.mapper;

import dev.matheuslf.desafio.inscritos.adapter.input.controller.dto.CriarProjetoDTORequest;
import dev.matheuslf.desafio.inscritos.adapter.input.controller.dto.ProjetoResponseDTO;
import dev.matheuslf.desafio.inscritos.application.domain.models.Projeto;

public class ProjetoMapperInput {

  public static Projeto fromDTOToDomain(CriarProjetoDTORequest dto) {
    return new Projeto(
        null,
        dto.nome(),
        dto.descricao(),
        dto.dataInicio(),
        dto.dataFim());
  }

  public static ProjetoResponseDTO fromDomainToDTO(Projeto projetoCriado) {
    return new ProjetoResponseDTO(
        projetoCriado.getId(),
        projetoCriado.getNome(),
        projetoCriado.getDescricao(),
        projetoCriado.getDataInicio(),
        projetoCriado.getDataFim());

  }
}
