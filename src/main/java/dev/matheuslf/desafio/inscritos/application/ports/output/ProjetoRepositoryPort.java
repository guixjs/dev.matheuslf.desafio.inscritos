package dev.matheuslf.desafio.inscritos.application.ports.output;

import java.util.List;

import dev.matheuslf.desafio.inscritos.application.domain.models.Projeto;

public interface ProjetoRepositoryPort {
  Projeto salvar(Projeto projeto);

  Projeto buscarPorId(Long id);

  List<Projeto> listarTodos();

  Projeto buscarPorIdDetalhado(Long id);
}
