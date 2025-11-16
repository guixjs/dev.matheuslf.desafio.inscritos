package dev.matheuslf.desafio.inscritos.adapter.input.controller.tarefas;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.matheuslf.desafio.inscritos.application.domain.models.Prioridade;
import dev.matheuslf.desafio.inscritos.application.domain.models.Status;
import dev.matheuslf.desafio.inscritos.application.domain.models.Tarefa;
import dev.matheuslf.desafio.inscritos.application.ports.input.tarefas.CriarTarefaUseCase;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

  private final CriarTarefaUseCase criarTarefaUseCase;

  public TarefaController(CriarTarefaUseCase criarTarefaUseCase) {
    this.criarTarefaUseCase = criarTarefaUseCase;
  }

  @PostMapping("/nova")
  public Tarefa criarTarefa() {

    var tarefa = new Tarefa(1L, "Título da task", "Descricao", Status.PENDENTE, Prioridade.ALTA, LocalDate.now());

    return this.criarTarefaUseCase.criarTarefa(1L, tarefa);

  }

}
