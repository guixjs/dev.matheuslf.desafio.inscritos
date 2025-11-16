package dev.matheuslf.desafio.inscritos.adapter.input.controller.tarefas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.matheuslf.desafio.inscritos.adapter.input.controller.tarefas.dto.CriarTarefaDTORequest;
import dev.matheuslf.desafio.inscritos.adapter.input.controller.tarefas.dto.TarefaResponseDTO;
import dev.matheuslf.desafio.inscritos.adapter.input.controller.tarefas.dto.mapper.TarefaMapperInput;
import dev.matheuslf.desafio.inscritos.application.ports.input.tarefas.CriarTarefaUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

  private final CriarTarefaUseCase criarTarefaUseCase;

  public TarefaController(CriarTarefaUseCase criarTarefaUseCase) {
    this.criarTarefaUseCase = criarTarefaUseCase;
  }

  @PostMapping("/nova")
  public ResponseEntity<TarefaResponseDTO> criarTarefa(@RequestBody @Valid CriarTarefaDTORequest request) {

    var tarefaCriada = this.criarTarefaUseCase.criarTarefa(request.projetoId(),
        TarefaMapperInput.fromDtoToDomain(request));
    var response = TarefaMapperInput.fromDomainToDTO(tarefaCriada);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);

  }

}
