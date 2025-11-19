package dev.matheuslf.desafio.inscritos.application.domain.services.projetos;

import java.util.List;

import dev.matheuslf.desafio.inscritos.application.domain.models.Projeto;
import dev.matheuslf.desafio.inscritos.application.ports.input.projetos.BuscarPorIdUseCase;
import dev.matheuslf.desafio.inscritos.application.ports.input.projetos.CriarProjetoUseCase;
import dev.matheuslf.desafio.inscritos.application.ports.input.projetos.ListarTodosProjetosUseCase;

public class FacadeProjeto {

  private final CriarProjetoUseCase criar;
  private final ListarTodosProjetosUseCase listar;
  private final BuscarPorIdUseCase buscar;

  public FacadeProjeto(CriarProjetoUseCase criarProjetoUseCase, ListarTodosProjetosUseCase listar,
      BuscarPorIdUseCase buscarPorId) {
    this.listar = listar;
    this.criar = criarProjetoUseCase;
    this.buscar = buscarPorId;
  }

  public Projeto criarProjeto(Projeto projeto) {
    return this.criar.execute(projeto);
  }

  public List<Projeto> listarTodos() {
    return this.listar.execute();
  }

  public Projeto buscarPorId(Long id) {
    return this.buscar.execute(id);
  }

}
