package dev.matheuslf.desafio.inscritos.application.domain.services.projetos.impl;

import dev.matheuslf.desafio.inscritos.application.domain.models.AtualizarProjetoDomain;
import dev.matheuslf.desafio.inscritos.application.domain.models.Projeto;
import dev.matheuslf.desafio.inscritos.application.ports.input.projetos.AtualizarProjetoUseCase;
import dev.matheuslf.desafio.inscritos.application.ports.output.ProjetoRepositoryPort;

public class AtualizarProjetoService implements AtualizarProjetoUseCase {

  private final ProjetoRepositoryPort projetoRepository;

  public AtualizarProjetoService(ProjetoRepositoryPort projetoRepository) {
    this.projetoRepository = projetoRepository;
  }

  @Override
  public Projeto execute(Long id, AtualizarProjetoDomain projetoAtualizado) {
    Projeto existente = this.projetoRepository.buscarPorId(id);

    if (projetoAtualizado.getNome() != null) {
      existente.setNome(projetoAtualizado.getNome());
    }
    if (projetoAtualizado.getDescricao() != null) {
      existente.setDescricao(projetoAtualizado.getDescricao());
    }
    if (projetoAtualizado.getDataFim() != null) {
      existente.setDataFim(projetoAtualizado.getDataFim());
    }

    return this.projetoRepository.salvar(existente);
  }

}
