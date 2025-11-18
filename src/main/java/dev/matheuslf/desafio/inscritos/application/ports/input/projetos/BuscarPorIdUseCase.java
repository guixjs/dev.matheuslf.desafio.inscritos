package dev.matheuslf.desafio.inscritos.application.ports.input.projetos;

import dev.matheuslf.desafio.inscritos.application.domain.models.Projeto;

public interface BuscarPorIdUseCase {
  Projeto buscarPorId(Long id);
}
