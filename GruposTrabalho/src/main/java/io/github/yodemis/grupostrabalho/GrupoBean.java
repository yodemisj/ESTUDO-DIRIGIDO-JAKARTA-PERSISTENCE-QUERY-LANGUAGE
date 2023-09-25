/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package io.github.yodemis.grupostrabalho;

import java.time.LocalDate;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author yodem
 */
@Stateless
public class GrupoBean implements GrupoBeanLocal {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Grupo> findGruposInativosTypedQuery() {
        return em.createQuery("SELECT g FROM Grupo g WHERE g.ativo = false", Grupo.class).getResultList();
    }

    @Override
    public List<Object[]> findLiderGruposTypedQuery() {
        return em.createQuery("SELECT g.lider.nome, g.nome FROM Grupo g",Object[].class).getResultList();
    }

    @Override
    public List<Object[]> findNomeMembroGrupoTypedQuery(String nomegrupo) {
        return em.createQuery("SELECT a.pessoa.nome FROM Grupo g JOIN g.atuacoes a "
                + "WHERE g.nome = :nomegrupo AND a.grupo.id = g.id ORDER BY a.pessoa.nome DESC",Object[].class)
                .setParameter("nomegrupo", nomegrupo).getResultList();
    }

    @Override
    public List<Grupo> findGrupoByliderTypedQuery(String nomelider) {
        return em.createQuery("SELECT g FROM Grupo g WHERE g.lider.nome = :nomelider", Grupo.class)
                .setParameter("nomelider", nomelider).getResultList();
    }

    @Override
    public List<Object[]> findAtuacaoGrupoByNomeTypedQuery(String nome) {
        return em.createQuery("SELECT g.nome, a.inicio, a.termino FROM Grupo g JOIN g.atuacoes a "
                + "WHERE a.pessoa.nome = :nome",Object[].class)
                .setParameter("nome", nome).getResultList();
    }

    @Override
    public List<Grupo> findGruposBySubstringTypedQuery(String substring) {
        return em.createQuery("SELECT g FROM Grupo g WHERE g.nome LIKE :substring",Grupo.class)
                .setParameter("substring", "%" + substring + "%").getResultList();
    }

    @Override 
    public List<Object[]> countMebrosGruposTypedQuery() {
        return em.createQuery("SELECT g.nome, COUNT(DISTINCT a.pessoa.id) FROM Grupo g JOIN g.atuacoes a GROUP BY g.nome", Object[].class).getResultList();
    }

    @Override
    public List<Object[]> findGruposByQuantidadeAtuacaoTypedQuery(int qtd) {
        return em.createQuery("SELECT g.nome, COUNT(a) AS qtdA FROM Grupo g JOIN g.atuacoes a GROUP BY g.nome HAVING COUNT(a) >= :qtd", Object[].class)
                .setParameter("qtd", (long)qtd).getResultList();
    }

    @Override
    public List<Object[]> findMembrosByDataAtuacaoTypedQuery(List<Long> grupoIds, LocalDate dataInicio) {
        return em.createQuery(
        "SELECT DISTINCT p.nome FROM Pessoa p JOIN p.atuacoes a WHERE a.inicio >= :dataInicio AND a.grupo.id IN :grupoIds", Object[].class)
        .setParameter("grupoIds", grupoIds)
        .setParameter("dataInicio", dataInicio).getResultList();
    }
    // NEW io.github.yodemis.grupostrabalho.MembroDto (g.nome, a.pessoa.nome, a.inicio)
    @Override
    public List<MembroDto> findMembrosDtoByDataAtuacaoTypedQuery(List<Long> gruposId2, LocalDate dataInicio2) {
        
        return em.createQuery(
        "SELECT NEW io.github.yodemis.grupostrabalho.MembroDto (g.nome, a.pessoa.nome, a.inicio) FROM Grupo g JOIN g.atuacoes a WHERE g.id IN :grupoIds AND g.id = a.grupo.id AND a.inicio >= :dataInicio ORDER BY g.nome, a.inicio",MembroDto.class)
        .setParameter("grupoIds", gruposId2)
        .setParameter("dataInicio", dataInicio2).getResultList();
    }

    @Override
    public List<MembroDto> findMembrosDtoSemDataFimTypedQuery() {
        return em.createQuery(
        "SELECT NEW io.github.yodemis.grupostrabalho.MembroDto (g.nome, a.pessoa.nome) "
                + "FROM Grupo g JOIN g.atuacoes a WHERE a.termino = null ",MembroDto.class)
                .getResultList();
    }
    
    
    @Override
    public List<Object[]> findGruposNomeLiderMembrosTypedQuery() {
        return em.createQuery(
        "SELECT g.nome, g.lider.nome, a.pessoa.nome FROM Grupo g JOIN g.atuacoes a ORDER BY g.nome, g.lider.nome, a.pessoa.nome",Object[].class)
                .getResultList();
    }
    


}