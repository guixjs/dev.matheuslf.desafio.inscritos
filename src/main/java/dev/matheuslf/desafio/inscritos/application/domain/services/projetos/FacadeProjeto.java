package dev.matheuslf.desafio.inscritos.application.domain.services.projetos;

import java.util.List;

import dev.matheuslf.desafio.inscritos.application.domain.models.AtualizarProjetoDomain;
import dev.matheuslf.desafio.inscritos.application.domain.models.Projeto;
import dev.matheuslf.desafio.inscritos.application.ports.input.projetos.AtualizarProjetoUseCase;
import dev.matheuslf.desafio.inscritos.application.ports.input.projetos.BuscarPorIdUseCase;
import dev.matheuslf.desafio.inscritos.application.ports.input.projetos.CriarProjetoUseCase;
import dev.matheuslf.desafio.inscritos.application.ports.input.projetos.DeletarProjetoUseCase;
import dev.matheuslf.desafio.inscritos.application.ports.input.projetos.ListarTodosProjetosUseCase;

public class FacadeProjeto {

  private final CriarProjetoUseCase criar;
  private final ListarTodosProjetosUseCase listar;
  private final BuscarPorIdUseCase buscar;
  private final DeletarProjetoUseCase deletar;
  private final AtualizarProjetoUseCase atualizar;

  public FacadeProjeto(CriarProjetoUseCase criarProjetoUseCase, ListarTodosProjetosUseCase listar,
      BuscarPorIdUseCase buscarPorId, DeletarProjetoUseCase deletar, AtualizarProjetoUseCase atualizar) {
    this.listar = listar;
    this.criar = criarProjetoUseCase;
    this.buscar = buscarPorId;
    this.deletar = deletar;
    this.atualizar = atualizar;
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

  public void deletar(Long id) {
    this.deletar.execute(id);
  }

  public Projeto atualizar(Long id, AtualizarProjetoDomain projetoAtualizado) {
    return this.atualizar.execute(id, projetoAtualizado);

  }
}
