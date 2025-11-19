package dev.matheuslf.desafio.inscritos.application.domain.services.projetos.impl;

import dev.matheuslf.desafio.inscritos.application.domain.models.Projeto;
import dev.matheuslf.desafio.inscritos.application.ports.input.projetos.CriarProjetoUseCase;
import dev.matheuslf.desafio.inscritos.application.ports.output.ProjetoRepositoryPort;

public class CriarProjetoService implements CriarProjetoUseCase {

  private final ProjetoRepositoryPort projetoRepository;

  public CriarProjetoService(ProjetoRepositoryPort projetoRepository) {
    this.projetoRepository = projetoRepository;
  }

  @Override
  public Projeto execute(Projeto projeto) {
    return this.projetoRepository.salvar(projeto);
  }

}
