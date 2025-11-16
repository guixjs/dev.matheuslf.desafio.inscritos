package dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.projetos.repository;

import dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.projetos.entity.ProjetoJPA;
import dev.matheuslf.desafio.inscritos.application.domain.exceptions.ProjetoNaoEncontradoException;
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


  @Override
  public Projeto buscarPorId(Long id) {
    var projetoJPA = this.jpaRepository.findById(id).orElseThrow(() -> new ProjetoNaoEncontradoException(id));

    return new Projeto(projetoJPA.getId(), projetoJPA.getNome(), projetoJPA.getDescricao(),
        projetoJPA.getDataInicio(), projetoJPA.getDataFim());
  }

}
