package dev.matheuslf.desafio.inscritos.adapter.input.controller.projetos.dto.mapper;

import java.util.List;

import dev.matheuslf.desafio.inscritos.adapter.input.controller.projetos.dto.CriarProjetoDTORequest;
import dev.matheuslf.desafio.inscritos.adapter.input.controller.projetos.dto.ProjetoDetalhadoResponseDTO;
import dev.matheuslf.desafio.inscritos.adapter.input.controller.projetos.dto.ProjetoResponseDTO;
import dev.matheuslf.desafio.inscritos.adapter.input.controller.tarefas.dto.TarefaResumoResponseDTO;
import dev.matheuslf.desafio.inscritos.adapter.input.controller.tarefas.dto.mapper.TarefaMapperInput;
import dev.matheuslf.desafio.inscritos.application.domain.models.Projeto;
import dev.matheuslf.desafio.inscritos.application.domain.models.Status;

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

  public static ProjetoDetalhadoResponseDTO fromDomainToDetalhadoDTO(Projeto projeto) {
    long todasTarefas = projeto.getTarefas().size();
    long tarefasConcluidas = projeto.contarTarefaPorStatus(Status.CONCLUIDA);
    long tarefasPendentes = projeto.contarTarefaPorStatus(Status.PENDENTE);
    long tarefasEmAndamento = projeto.contarTarefaPorStatus(Status.EM_ANDAMENTO);

    List<TarefaResumoResponseDTO> tarefasDoProjeto = projeto.getTarefas().stream()
        .map(TarefaMapperInput::fromDomainToDTOResumido)
        .toList();

    return new ProjetoDetalhadoResponseDTO(
        projeto.getId(),
        projeto.getNome(),
        projeto.getDescricao(),
        projeto.getDataInicio(),
        projeto.getDataFim(),
        todasTarefas,
        tarefasPendentes,
        tarefasEmAndamento,
        tarefasConcluidas,
        tarefasDoProjeto);
  }
}
