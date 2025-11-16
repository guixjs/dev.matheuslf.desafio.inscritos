package dev.matheuslf.desafio.inscritos.application.domain.services.tarefas;

import dev.matheuslf.desafio.inscritos.application.domain.models.Projeto;
import dev.matheuslf.desafio.inscritos.application.domain.models.Tarefa;
import dev.matheuslf.desafio.inscritos.application.ports.input.tarefas.CriarTarefaUseCase;
import dev.matheuslf.desafio.inscritos.application.ports.output.ProjetoRepositoryPort;
import dev.matheuslf.desafio.inscritos.application.ports.output.TarefaRepositoryPort;

public class CriarTarefaService implements CriarTarefaUseCase {

  private final TarefaRepositoryPort tarefaRepositoryPort;
  private final ProjetoRepositoryPort projetoRepositoryPort;

  public CriarTarefaService(TarefaRepositoryPort tarefaRepositoryPort, ProjetoRepositoryPort projetoRepositoryPort) {
    this.tarefaRepositoryPort = tarefaRepositoryPort;
    this.projetoRepositoryPort = projetoRepositoryPort;
  }

  @Override
  public Tarefa criarTarefa(Long idProjeto, Tarefa tarefa) {
    Projeto projeto = projetoRepositoryPort.buscarPorId(idProjeto);
    projeto.adicionarTarefa(tarefa);
    tarefa.setProjeto(projeto);

    return tarefaRepositoryPort.salvar(tarefa);
  }

}
