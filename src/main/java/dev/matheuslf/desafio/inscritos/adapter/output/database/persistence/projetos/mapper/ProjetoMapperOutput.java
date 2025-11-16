package dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.projetos.mapper;

import dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.projetos.entity.ProjetoJPA;
import dev.matheuslf.desafio.inscritos.application.domain.models.Projeto;

public class ProjetoMapperOutput {

  public static Projeto fromJpaToDomain(ProjetoJPA jpa) {
    return new Projeto(
        jpa.getId(),
        jpa.getNome(),
        jpa.getDescricao(),
        jpa.getDataInicio(),
        jpa.getDataFim());
  }

  public static ProjetoJPA fromDomainToJpa(Projeto domain) {
    return new ProjetoJPA(
        domain.getNome(),
        domain.getDescricao(),
        domain.getDataInicio(),
        domain.getDataFim());
  }
}
