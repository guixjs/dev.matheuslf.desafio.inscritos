package dev.matheuslf.desafio.inscritos.adapter.input.controller.projetos;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.matheuslf.desafio.inscritos.adapter.input.controller.projetos.dto.AtualizarProjetoRequestDTO;
import dev.matheuslf.desafio.inscritos.adapter.input.controller.projetos.dto.CriarProjetoRequestDTO;
import dev.matheuslf.desafio.inscritos.adapter.input.controller.projetos.dto.ProjetoDetalhadoResponseDTO;
import dev.matheuslf.desafio.inscritos.adapter.input.controller.projetos.dto.ProjetoResponseDTO;
import dev.matheuslf.desafio.inscritos.adapter.input.controller.projetos.dto.mapper.ProjetoMapperInput;
import dev.matheuslf.desafio.inscritos.application.domain.services.projetos.FacadeProjeto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

  private final FacadeProjeto projetoFacade;

  public ProjetoController(FacadeProjeto projetoFacade) {
    this.projetoFacade = projetoFacade;
  }

  @PostMapping("/novo")
  public ResponseEntity<ProjetoResponseDTO> criarProjeto(@RequestBody @Valid CriarProjetoRequestDTO request) {
    var projetoCriado = projetoFacade.criarProjeto(ProjetoMapperInput.fromDTOToDomain(request));
    var responseDTO = ProjetoMapperInput.fromDomainToDTO(projetoCriado);
    return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
  }

  @GetMapping()
  public ResponseEntity<List<ProjetoResponseDTO>> listarTodos() {
    var lista = this.projetoFacade.listarTodos();
    if (lista.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    var listaDTO = lista.stream().map(ProjetoMapperInput::fromDomainToDTO).toList();
    return ResponseEntity.ok().body(listaDTO);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProjetoDetalhadoResponseDTO> buscarDetalhesPorId(@PathVariable Long id) {
    var projetoDTO = ProjetoMapperInput.fromDomainToDetalhadoDTO(this.projetoFacade.buscarPorId(id));
    return ResponseEntity.status(HttpStatus.OK).body(projetoDTO);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletarProjeto(@PathVariable Long id) {
    this.projetoFacade.deletar(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProjetoResponseDTO> atualizarProjeto(@PathVariable Long id,
      @RequestBody AtualizarProjetoRequestDTO dto) {
    var response = this.projetoFacade.atualizar(id, ProjetoMapperInput.fromAtualizarDTOToAtualizarDomain(dto));
    return ResponseEntity.status(HttpStatus.OK).body(ProjetoMapperInput.fromDomainToDTO(response));
  }
}
