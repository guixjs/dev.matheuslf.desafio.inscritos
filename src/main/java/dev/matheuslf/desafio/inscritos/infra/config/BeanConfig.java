package dev.matheuslf.desafio.inscritos.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.projetos.repository.ProjetoRepositoryImpl;
import dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.projetos.repository.ProjetoRepositoryJPA;
import dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.tarefas.repository.TarefaRepositoryImpl;
import dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.tarefas.repository.TarefaRepositoryJPA;
import dev.matheuslf.desafio.inscritos.application.domain.services.projetos.FacadeProjeto;
import dev.matheuslf.desafio.inscritos.application.domain.services.projetos.impl.BuscarPorIdService;
import dev.matheuslf.desafio.inscritos.application.domain.services.projetos.impl.CriarProjetoService;
import dev.matheuslf.desafio.inscritos.application.domain.services.projetos.impl.ListarTodosProjetosService;
import dev.matheuslf.desafio.inscritos.application.domain.services.tarefas.FacadeTarefa;
import dev.matheuslf.desafio.inscritos.application.domain.services.tarefas.impl.CriarTarefaService;
import dev.matheuslf.desafio.inscritos.application.domain.services.tarefas.impl.ListarTodasTarefasService;
import dev.matheuslf.desafio.inscritos.application.ports.input.projetos.BuscarPorIdUseCase;
import dev.matheuslf.desafio.inscritos.application.ports.input.projetos.CriarProjetoUseCase;
import dev.matheuslf.desafio.inscritos.application.ports.input.projetos.ListarTodosProjetosUseCase;
import dev.matheuslf.desafio.inscritos.application.ports.input.tarefas.CriarTarefaUseCase;
import dev.matheuslf.desafio.inscritos.application.ports.input.tarefas.ListarTodasTarefasUseCase;
import dev.matheuslf.desafio.inscritos.application.ports.output.ProjetoRepositoryPort;
import dev.matheuslf.desafio.inscritos.application.ports.output.TarefaRepositoryPort;

@Configuration
public class BeanConfig {

  @Bean
  public ProjetoRepositoryPort projetoRepositoryPort(ProjetoRepositoryJPA jpaRepository) {
    return new ProjetoRepositoryImpl(jpaRepository);
  }

  @Bean
  public CriarProjetoUseCase criarProjetoUseCase(ProjetoRepositoryPort projetoRepository) {
    return new CriarProjetoService(projetoRepository);
  }

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
  public ListarTodosProjetosUseCase listarTodosProjetosUseCase(ProjetoRepositoryPort projetoRepository) {
    return new ListarTodosProjetosService(projetoRepository);
  }

  @Bean
  public ListarTodasTarefasUseCase listarTodasTarefasUseCase(TarefaRepositoryPort tarefaRepository) {
    return new ListarTodasTarefasService(tarefaRepository);
  }

  @Bean
  public BuscarPorIdUseCase buscarPorIdUseCase(ProjetoRepositoryPort projetoRepository) {
    return new BuscarPorIdService(projetoRepository);
  }

  @Bean
  public FacadeProjeto facadeProjeto(CriarProjetoUseCase criarProjetoUseCase, ListarTodosProjetosUseCase listar,
      BuscarPorIdUseCase buscarPorIdUseCase) {
    return new FacadeProjeto(criarProjetoUseCase, listar, buscarPorIdUseCase);
  }

  @Bean
  public FacadeTarefa facadeTarefa(CriarTarefaUseCase criarTarefaUseCase,
      ListarTodasTarefasUseCase listarTodasTarefasUseCase) {
    return new FacadeTarefa(criarTarefaUseCase, listarTodasTarefasUseCase);
  }
}
