package dev.matheuslf.desafio.inscritos.adapter.input.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.matheuslf.desafio.inscritos.adapter.input.controller.dto.CriarProjetoDTORequest;
import dev.matheuslf.desafio.inscritos.application.domain.models.Projeto;
import dev.matheuslf.desafio.inscritos.application.ports.input.CriarProjetoUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

  private final CriarProjetoUseCase criarProjetoUseCase;

  public ProjetoController(CriarProjetoUseCase criarProjetoUseCase) {
    this.criarProjetoUseCase = criarProjetoUseCase;
  }

  @PostMapping("/novo")
  public Projeto criarProjeto(@RequestBody @Valid CriarProjetoDTORequest request) {

    Projeto projeto = new Projeto(null,
        request.nome(),
        request.descricao(),
        request.dataInicio(),
        request.dataFim());

    return criarProjetoUseCase.criarProjeto(projeto);
  }

}
