package dev.matheuslf.desafio.inscritos.application.domain.services.projetos.impl;

import dev.matheuslf.desafio.inscritos.application.domain.models.Projeto;
import dev.matheuslf.desafio.inscritos.application.ports.input.projetos.BuscarPorIdUseCase;
import dev.matheuslf.desafio.inscritos.application.ports.output.ProjetoRepositoryPort;

public class BuscarPorIdService implements BuscarPorIdUseCase {

  private final ProjetoRepositoryPort projetoRepository;

  public BuscarPorIdService(ProjetoRepositoryPort projetoRepository) {
    this.projetoRepository = projetoRepository;
  }

  @Override
  public Projeto execute(Long id) {
    return this.projetoRepository.buscarPorIdDetalhado(id);
  }

}
