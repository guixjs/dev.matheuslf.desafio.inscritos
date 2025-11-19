package dev.matheuslf.desafio.inscritos.application.ports.input.projetos;

import dev.matheuslf.desafio.inscritos.application.domain.models.AtualizarProjetoDomain;
import dev.matheuslf.desafio.inscritos.application.domain.models.Projeto;

public interface AtualizarProjetoUseCase {
  Projeto execute(Long id, AtualizarProjetoDomain projetoAtualizado);
}
