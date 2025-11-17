package dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.tarefas.repository;

import java.util.List;

import dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.projetos.repository.ProjetoRepositoryJPA;
import dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.tarefas.entity.TarefaJPA;
import dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.tarefas.mapper.TarefaMapperOutput;
import dev.matheuslf.desafio.inscritos.application.domain.models.Projeto;
import dev.matheuslf.desafio.inscritos.application.domain.models.Tarefa;
import dev.matheuslf.desafio.inscritos.application.ports.output.TarefaRepositoryPort;

public class TarefaRepositoryImpl implements TarefaRepositoryPort {

  private final TarefaRepositoryJPA tarefaRepositoryJPA;
  private final ProjetoRepositoryJPA projetoRepositoryJPA;

  public TarefaRepositoryImpl(TarefaRepositoryJPA tarefaRepositoryJPA, ProjetoRepositoryJPA projetoRepositoryJPA) {
    this.projetoRepositoryJPA = projetoRepositoryJPA;
    this.tarefaRepositoryJPA = tarefaRepositoryJPA;
  }

  @Override
  public Tarefa salvar(Tarefa tarefa) {

    Projeto projeto = tarefa.getProjeto();

    var projetoJpa = projetoRepositoryJPA.getReferenceById(projeto.getId());

    var tarefaEntity = new TarefaJPA(tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getStatus(),
        tarefa.getPrioridade(), tarefa.getDataLimite(), projetoJpa);
    var tarefaSalva = tarefaRepositoryJPA.save(tarefaEntity);
    return new Tarefa(tarefaSalva.getId(), tarefaSalva.getTitulo(), tarefaSalva.getDescricao(),
        tarefaSalva.getStatus(), tarefaSalva.getPrioridade(), tarefaSalva.getDataLimite(), projeto);

  }

  @Override
  public List<Tarefa> listarTodas() {
    return this.tarefaRepositoryJPA.findAll()
        .stream()
        .map(t -> TarefaMapperOutput.fromEntityToDomain(t))
        .toList();
  }

}
