package dev.matheuslf.desafio.inscritos.application.ports.input.projetos;

import dev.matheuslf.desafio.inscritos.application.domain.models.Projeto;

public interface CriarProjetoUseCase {

  Projeto execute(Projeto projeto);
}
