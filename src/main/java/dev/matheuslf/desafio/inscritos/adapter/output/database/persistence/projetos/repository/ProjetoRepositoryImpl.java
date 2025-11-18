package dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.projetos.repository;

import java.util.List;
import dev.matheuslf.desafio.inscritos.adapter.output.database.persistence.projetos.mapper.ProjetoMapperOutput;
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
    var projetoSalvo = this.jpaRepository.save(ProjetoMapperOutput.fromDomainToJpa(projeto));
    return ProjetoMapperOutput.fromJpaToDomain(projetoSalvo);
  }

  @Override
  public Projeto buscarPorId(Long id) {
    var projetoJPA = this.jpaRepository.findById(id)
        .orElseThrow(() -> new ProjetoNaoEncontradoException(id));
    return ProjetoMapperOutput.fromJpaToDomain(projetoJPA);
  }

  @Override
  public List<Projeto> listarTodos() {
    var projetosJPA = this.jpaRepository.findAll();
    return projetosJPA.stream()
        .map(p -> ProjetoMapperOutput.fromJpaToDomain(p))
        .toList();
  }

  @Override
  public Projeto buscarPorIdDetalhado(Long id) {
    var projetoJpaOpt = this.jpaRepository.buscarProjetoPorIdDetalhado(id);
    var projetoJpa = projetoJpaOpt.orElseThrow(() -> new ProjetoNaoEncontradoException(id));
    return ProjetoMapperOutput.fromJpaToDomain(projetoJpa);

  }

}
