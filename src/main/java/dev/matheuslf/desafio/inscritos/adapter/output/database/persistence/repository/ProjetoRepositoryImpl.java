package dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.repository;

import dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.entity.ProjetoJPA;
import dev.matheuslf.desafio.inscritos.application.domain.models.Projeto;
import dev.matheuslf.desafio.inscritos.application.ports.output.ProjetoRepositoryPort;

public class ProjetoRepositoryImpl implements ProjetoRepositoryPort {

  private final ProjetoRepositoryJPA jpaRepository;

  public ProjetoRepositoryImpl(ProjetoRepositoryJPA jpaRepository) {
    this.jpaRepository = jpaRepository;
  }

  @Override
  public Projeto salvar(Projeto projeto) {
    var projetoSalvo = this.jpaRepository.save(
        new ProjetoJPA(projeto.getNome(), projeto.getDescricao(), projeto.getDataInicio(), projeto.getDataFim()));

    return new Projeto(projetoSalvo.getId(), projetoSalvo.getNome(), projetoSalvo.getDescricao(),
        projetoSalvo.getDataInicio(),
        projetoSalvo.getDataFim());
  }

}
