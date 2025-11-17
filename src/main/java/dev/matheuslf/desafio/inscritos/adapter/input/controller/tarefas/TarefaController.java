package dev.matheuslf.desafio.inscritos.adapter.input.controller.tarefas;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.matheuslf.desafio.inscritos.adapter.input.controller.tarefas.dto.CriarTarefaDTORequest;
import dev.matheuslf.desafio.inscritos.adapter.input.controller.tarefas.dto.TarefaResponseDTO;
import dev.matheuslf.desafio.inscritos.adapter.input.controller.tarefas.dto.TarefaResumoResponseDTO;
import dev.matheuslf.desafio.inscritos.adapter.input.controller.tarefas.dto.mapper.TarefaMapperInput;
import dev.matheuslf.desafio.inscritos.application.ports.input.tarefas.CriarTarefaUseCase;
import dev.matheuslf.desafio.inscritos.application.ports.input.tarefas.ListarTodasTarefasUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

  private final CriarTarefaUseCase criarTarefaUseCase;
  private final ListarTodasTarefasUseCase listarTarefas;

  public TarefaController(CriarTarefaUseCase criarTarefaUseCase, ListarTodasTarefasUseCase listar) {
    this.criarTarefaUseCase = criarTarefaUseCase;
    this.listarTarefas = listar;
  }

  @PostMapping("/nova")
  public ResponseEntity<TarefaResponseDTO> criarTarefa(@RequestBody @Valid CriarTarefaDTORequest request) {

    var tarefaCriada = this.criarTarefaUseCase.criarTarefa(request.projetoId(),
        TarefaMapperInput.fromDtoToDomain(request));
    var response = TarefaMapperInput.fromDomainToDTO(tarefaCriada);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);

  }

  @GetMapping()
  public ResponseEntity<List<TarefaResumoResponseDTO>> listarTodos() {
    var lista = this.listarTarefas.listar();
    if (lista.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    var response = lista.stream().map(t -> TarefaMapperInput.fromDomainToDTOResumido(t)).toList();

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

}
