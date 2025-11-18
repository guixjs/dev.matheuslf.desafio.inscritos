package dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.projetos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.projetos.entity.ProjetoJPA;

public interface ProjetoRepositoryJPA extends JpaRepository<ProjetoJPA, Long> {

  @Query("""
      SELECT p FROM ProjetoJPA p
      LEFT JOIN FETCH p.tarefas
      WHERE p.id = :id
      """)
  Optional<ProjetoJPA> buscarProjetoPorIdDetalhado(Long id);
}
