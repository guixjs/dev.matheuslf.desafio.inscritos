package dev.matheuslf.desafio.inscritos.application.ports.input.projetos;

import java.util.List;

import dev.matheuslf.desafio.inscritos.application.domain.models.Projeto;

public interface ListarTodosProjetosUseCase {
  List<Projeto> execute();
}
