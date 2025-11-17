package dev.matheuslf.desafio.inscritos.adapter.input.controller.projetos;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.matheuslf.desafio.inscritos.adapter.input.controller.projetos.dto.CriarProjetoDTORequest;
import dev.matheuslf.desafio.inscritos.adapter.input.controller.projetos.dto.ProjetoDetalhadoResponseDTO;
import dev.matheuslf.desafio.inscritos.adapter.input.controller.projetos.dto.ProjetoResponseDTO;
import dev.matheuslf.desafio.inscritos.adapter.input.controller.projetos.dto.mapper.ProjetoMapperInput;
import dev.matheuslf.desafio.inscritos.application.ports.input.projetos.CriarProjetoUseCase;
import dev.matheuslf.desafio.inscritos.application.ports.input.projetos.ListarTodosProjetosUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

  private final CriarProjetoUseCase criarProjetoUseCase;
  private final ListarTodosProjetosUseCase listarProjetos;

  public ProjetoController(CriarProjetoUseCase criarProjetoUseCase, ListarTodosProjetosUseCase listar) {
    this.listarProjetos = listar;
    this.criarProjetoUseCase = criarProjetoUseCase;
  }

  @PostMapping("/novo")
  public ResponseEntity<ProjetoResponseDTO> criarProjeto(@RequestBody @Valid CriarProjetoDTORequest request) {
    var projetoCriado = criarProjetoUseCase.criarProjeto(ProjetoMapperInput.fromDTOToDomain(request));
    var responseDTO = ProjetoMapperInput.fromDomainToDTO(projetoCriado);
    return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
  }

  @GetMapping()
  public ResponseEntity<List<ProjetoResponseDTO>> listarTodos() {
    var lista = this.listarProjetos.listarTodos();
    if (lista.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    var listaDTO = lista.stream().map(ProjetoMapperInput::fromDomainToDTO).toList();
    return ResponseEntity.ok().body(listaDTO);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProjetoDetalhadoResponseDTO> buscarDetalhesPorId(@PathVariable Long id) {
    return null;

  }
}
