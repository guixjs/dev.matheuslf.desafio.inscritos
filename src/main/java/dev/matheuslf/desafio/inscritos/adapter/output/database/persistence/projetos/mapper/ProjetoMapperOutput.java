package dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.projetos.mapper;

import java.util.List;

import dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.projetos.entity.ProjetoJPA;
import dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.tarefas.mapper.TarefaMapperOutput;
import dev.matheuslf.desafio.inscritos.application.domain.models.Projeto;
import dev.matheuslf.desafio.inscritos.application.domain.models.Tarefa;

public class ProjetoMapperOutput {

  public static Projeto fromJpaToDomain(ProjetoJPA jpa) {
    Projeto projeto = new Projeto(
        jpa.getId(),
        jpa.getNome(),
        jpa.getDescricao(),
        jpa.getDataInicio(),
        jpa.getDataFim());

    List<Tarefa> tarefas = jpa.getTarefas().stream()
        .map(TarefaMapperOutput::fromJpaToDomain)
        .toList();

    tarefas.forEach(projeto::adicionarTarefa);

    return projeto;
  }

  public static ProjetoJPA fromDomainToJpa(Projeto domain) {
    return new ProjetoJPA(
        domain.getNome(),
        domain.getDescricao(),
        domain.getDataInicio(),
        domain.getDataFim());
  }
}
