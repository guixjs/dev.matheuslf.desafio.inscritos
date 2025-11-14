package dev.matheuslf.desafio.inscritos.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.repository.ProjetoRepositoryImpl;
import dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.repository.ProjetoRepositoryJPA;
import dev.matheuslf.desafio.inscritos.application.domain.services.projetos.CriarProjetoService;
import dev.matheuslf.desafio.inscritos.application.ports.input.CriarProjetoUseCase;
import dev.matheuslf.desafio.inscritos.application.ports.output.ProjetoRepositoryPort;

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
}
