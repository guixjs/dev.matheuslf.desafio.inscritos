package dev.matheuslf.desafio.inscritos.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.projetos.repository.ProjetoRepositoryImpl;
import dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.projetos.repository.ProjetoRepositoryJPA;
import dev.matheuslf.desafio.inscritos.application.domain.services.projetos.FacadeProjeto;
import dev.matheuslf.desafio.inscritos.application.domain.services.projetos.impl.BuscarPorIdService;
import dev.matheuslf.desafio.inscritos.application.domain.services.projetos.impl.CriarProjetoService;
import dev.matheuslf.desafio.inscritos.application.domain.services.projetos.impl.DeletarProjetoService;
import dev.matheuslf.desafio.inscritos.application.domain.services.projetos.impl.ListarTodosProjetosService;
import dev.matheuslf.desafio.inscritos.application.ports.input.projetos.BuscarPorIdUseCase;
import dev.matheuslf.desafio.inscritos.application.ports.input.projetos.CriarProjetoUseCase;
import dev.matheuslf.desafio.inscritos.application.ports.input.projetos.DeletarProjetoUseCase;
import dev.matheuslf.desafio.inscritos.application.ports.input.projetos.ListarTodosProjetosUseCase;
import dev.matheuslf.desafio.inscritos.application.ports.output.ProjetoRepositoryPort;

@Configuration
public class ProjetoBeanConfig {

  @Bean
  public ProjetoRepositoryPort projetoRepositoryPort(ProjetoRepositoryJPA jpaRepository) {
    return new ProjetoRepositoryImpl(jpaRepository);
  }

  @Bean
  public CriarProjetoUseCase criarProjetoUseCase(ProjetoRepositoryPort projetoRepository) {
    return new CriarProjetoService(projetoRepository);
  }

  @Bean
  public ListarTodosProjetosUseCase listarTodosProjetosUseCase(ProjetoRepositoryPort projetoRepository) {
    return new ListarTodosProjetosService(projetoRepository);
  }

  @Bean
  public BuscarPorIdUseCase buscarPorIdUseCase(ProjetoRepositoryPort projetoRepository) {
    return new BuscarPorIdService(projetoRepository);
  }

  @Bean
  public DeletarProjetoUseCase deletarProjetoUseCase(ProjetoRepositoryPort projetoRepository) {
    return new DeletarProjetoService(projetoRepository);
  }

  @Bean
  public FacadeProjeto facadeProjeto(CriarProjetoUseCase criarProjetoUseCase, ListarTodosProjetosUseCase listarUseCase,
      BuscarPorIdUseCase buscarPorIdUseCase, DeletarProjetoUseCase deletarUseCase) {
    return new FacadeProjeto(criarProjetoUseCase, listarUseCase, buscarPorIdUseCase, deletarUseCase);
  }
}
