package dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.tarefas.entity.TarefaJPA;

public interface TarefaRepositoryJPA extends JpaRepository<TarefaJPA, Long> {
  
}
