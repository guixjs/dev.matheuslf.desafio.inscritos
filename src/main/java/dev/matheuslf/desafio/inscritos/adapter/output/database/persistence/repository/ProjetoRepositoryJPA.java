package dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.entity.ProjetoJPA;

public interface ProjetoRepositoryJPA extends JpaRepository<ProjetoJPA, Long> {

}
