package dev.matheuslf.desafio.inscritos.application.ports.output;

import dev.matheuslf.desafio.inscritos.application.domain.models.Projeto;

public interface ProjetoRepositoryPort {
  Projeto salvar(Projeto projeto);
}
