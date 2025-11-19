package dev.matheuslf.desafio.inscritos.application.domain.services.projetos.impl;

import dev.matheuslf.desafio.inscritos.application.ports.input.projetos.DeletarProjetoUseCase;
import dev.matheuslf.desafio.inscritos.application.ports.output.ProjetoRepositoryPort;

public class DeletarProjetoService implements DeletarProjetoUseCase {

  private final ProjetoRepositoryPort projetoRepository;

  public DeletarProjetoService(ProjetoRepositoryPort projetoRepository) {
    this.projetoRepository = projetoRepository;
  }

  @Override
  public void execute(Long id) {
    this.projetoRepository.deletar(id);
  }

}
