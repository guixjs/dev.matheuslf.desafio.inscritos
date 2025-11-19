package dev.matheuslf.desafio.inscritos.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.projetos.repository.ProjetoRepositoryJPA;
import dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.tarefas.repository.TarefaRepositoryImpl;
import dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.tarefas.repository.TarefaRepositoryJPA;
import dev.matheuslf.desafio.inscritos.application.domain.services.tarefas.FacadeTarefa;
import dev.matheuslf.desafio.inscritos.application.domain.services.tarefas.impl.CriarTarefaService;
import dev.matheuslf.desafio.inscritos.application.domain.services.tarefas.impl.ListarTodasTarefasService;
import dev.matheuslf.desafio.inscritos.application.ports.input.tarefas.CriarTarefaUseCase;
import dev.matheuslf.desafio.inscritos.application.ports.input.tarefas.ListarTodasTarefasUseCase;
import dev.matheuslf.desafio.inscritos.application.ports.output.ProjetoRepositoryPort;
import dev.matheuslf.desafio.inscritos.application.ports.output.TarefaRepositoryPort;

@Configuration
public class TarefaBeanConfig {

  @Bean
  public CriarTarefaUseCase criarTarefaUseCase(ProjetoRepositoryPort projetoRepository,
      TarefaRepositoryPort tarefaRepository) {
    return new CriarTarefaService(tarefaRepository, projetoRepository);
  }

  @Bean
  public TarefaRepositoryPort tarefaRepository(TarefaRepositoryJPA tarefaRepositoryJPA,
      ProjetoRepositoryJPA projetoRepositoryJPA) {
    return new TarefaRepositoryImpl(tarefaRepositoryJPA, projetoRepositoryJPA);

  }

  @Bean
  public ListarTodasTarefasUseCase listarTodasTarefasUseCase(TarefaRepositoryPort tarefaRepository) {
    return new ListarTodasTarefasService(tarefaRepository);
  }

  @Bean
  public FacadeTarefa facadeTarefa(CriarTarefaUseCase criarTarefaUseCase,
      ListarTodasTarefasUseCase listarTodasTarefasUseCase) {
    return new FacadeTarefa(criarTarefaUseCase, listarTodasTarefasUseCase);
  }
}
