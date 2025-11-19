package dev.matheuslf.desafio.inscritos.adapter.input.controller.tarefas;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.matheuslf.desafio.inscritos.adapter.input.controller.tarefas.dto.CriarTarefaRequestDTO;
import dev.matheuslf.desafio.inscritos.adapter.input.controller.tarefas.dto.TarefaResponseDTO;
import dev.matheuslf.desafio.inscritos.adapter.input.controller.tarefas.dto.TarefaResumoResponseDTO;
import dev.matheuslf.desafio.inscritos.adapter.input.controller.tarefas.dto.mapper.TarefaMapperInput;
import dev.matheuslf.desafio.inscritos.application.domain.services.tarefas.FacadeTarefa;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

  private final FacadeTarefa tarefaFacade;

  public TarefaController(FacadeTarefa tarefaFacade) {
    this.tarefaFacade = tarefaFacade;
  }

  @PostMapping("/nova")
  public ResponseEntity<TarefaResponseDTO> criarTarefa(@RequestBody @Valid CriarTarefaRequestDTO request) {

    var tarefaCriada = this.tarefaFacade.criarTarefa(request.projetoId(),
        TarefaMapperInput.fromDtoToDomain(request));
    var response = TarefaMapperInput.fromDomainToDTO(tarefaCriada);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);

  }

  @GetMapping()
  public ResponseEntity<List<TarefaResumoResponseDTO>> listarTodos() {
    var lista = this.tarefaFacade.listarTodas();
    if (lista.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    var response = lista.stream().map(t -> TarefaMapperInput.fromDomainToDTOResumido(t)).toList();

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @PostMapping("/{id}/concluida")
  public String marcarTarefaComoConcluida(@PathVariable Long id) {
    return "";
  }

}
