package dev.matheuslf.desafio.inscritos.adapter.input.controller.projetos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.matheuslf.desafio.inscritos.adapter.input.controller.projetos.dto.CriarProjetoDTORequest;
import dev.matheuslf.desafio.inscritos.adapter.input.controller.projetos.dto.ProjetoResponseDTO;
import dev.matheuslf.desafio.inscritos.adapter.input.controller.projetos.dto.mapper.ProjetoMapperInput;
import dev.matheuslf.desafio.inscritos.application.ports.input.projetos.CriarProjetoUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

  private final CriarProjetoUseCase criarProjetoUseCase;

  public ProjetoController(CriarProjetoUseCase criarProjetoUseCase) {
    this.criarProjetoUseCase = criarProjetoUseCase;
  }

  @PostMapping("/novo")
  public ResponseEntity<ProjetoResponseDTO> criarProjeto(@RequestBody @Valid CriarProjetoDTORequest request) {
    var projetoCriado = criarProjetoUseCase.criarProjeto(ProjetoMapperInput.fromDTOToDomain(request));
    var responseDTO = ProjetoMapperInput.fromDomainToDTO(projetoCriado);
    return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
  }
}
