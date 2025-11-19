package dev.matheuslf.desafio.inscritos.application.domain.services.projetos.impl;

import java.util.List;

import dev.matheuslf.desafio.inscritos.application.domain.models.Projeto;
import dev.matheuslf.desafio.inscritos.application.ports.input.projetos.ListarTodosProjetosUseCase;
import dev.matheuslf.desafio.inscritos.application.ports.output.ProjetoRepositoryPort;

public class ListarTodosProjetosService implements ListarTodosProjetosUseCase {

  private final ProjetoRepositoryPort projetoRepository;

  public ListarTodosProjetosService(ProjetoRepositoryPort projetoRepository) {
    this.projetoRepository = projetoRepository;
  }

  @Override
  public List<Projeto> execute() {
    return projetoRepository.listarTodos();
  }

}
