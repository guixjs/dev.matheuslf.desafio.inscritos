package dev.matheuslf.desafio.inscritos.application.domain.exceptions;

public class ProjetoNaoEncontradoException extends RuntimeException {
  public ProjetoNaoEncontradoException(Long id) {
    super("Projeto com ID " + id + " não encontrado.");
  }

}
