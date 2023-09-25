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
public class PessoaBean implements PessoaBeanLocal {
    @PersistenceContext
    EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void save(Pessoa pessoa) {
        em.persist(pessoa);
    }
    
    @Override
    public List<Pessoa> findAllPessoaQuery(){
        return (List<Pessoa>)em.createQuery("SELECT p FROM Pessoa p").getResultList();
    }

    @Override
    public List<Pessoa> findAllPessoaTypedQuery() {
        return em.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList();
    }
    
    @Override
    public List<Pessoa> findAllPessoaNamedQuery() {
        return em.createNamedQuery("Pessoa.findAll", Pessoa.class).getResultList();
    }

    @Override
    public List<String> findNomePessoaQuery() {
        return (List<String>)em.createQuery("SELECT p.nome FROM Pessoa p").getResultList();
    }

    @Override
    public List<String> findNomePessoaTypedQuery() {
        return (List<String>)em.createQuery("SELECT p.nome, p.endereco FROM Pessoa p").getResultList();
    }
    @Override
    public List<String> findNomePessoaNamedQuery() {
        return em.createNamedQuery("Pessoa.findName", String.class).getResultList();
    }
    
    
    @Override
    public List<Pessoa> findNomeEnderecoPessoaQuery() {
        return (List<Pessoa>)em.createQuery("SELECT p.nome, p.endereco FROM Pessoa p").getResultList();
    }

    @Override
    public List<Object[]> findNomeEnderecoPessoaTypedQuery() {
        return em.createQuery("SELECT p.nome, p.endereco FROM Pessoa p", Object[].class).getResultList();
    }

    @Override
    public List<Object[]> findNomeEnderecoPessoaNamedQuery() {
        return em.createNamedQuery("Pessoa.findNomeEndereco", Object[].class).getResultList();
    }

    @Override
    public List<Pessoa> findPessoaByTipoLogradouroQuery(TipoLogradouro tipoLogradouro) {
        return (List<Pessoa>)em.createQuery("SELECT p FROM Pessoa p WHERE p.endereco.tipoLogradouro = :tipoLogradouro")
                .setParameter("tipoLogradouro", tipoLogradouro).getResultList();
    }

    @Override
    public List<Pessoa> findPessoaByTipoLogradouroTypedQuery(TipoLogradouro tipoLogradouro) {
        return em.createQuery("SELECT p FROM Pessoa p WHERE p.endereco.tipoLogradouro = :tipoLogradouro", Pessoa.class)
                .setParameter("tipoLogradouro", tipoLogradouro).getResultList();
    }

    @Override
    public List<Pessoa> findPessoaByTipoLogradouroNamedQuery(TipoLogradouro tipoLogradouro) {
        return em.createNamedQuery("Pessoa.findByTipoLogradouro",Pessoa.class)
                .setParameter("tipoLogradouro", tipoLogradouro).getResultList();
    }

    @Override
    public List<Pessoa> findPessoasSemTipoLogradouroQuery(TipoLogradouro tipoLogradouro) {
        return (List<Pessoa>)em.createQuery("SELECT p FROM Pessoa p WHERE p.endereco.tipoLogradouro != :tipoLogradouro")
                .setParameter("tipoLogradouro", tipoLogradouro).getResultList();
    }

    @Override
    public List<Pessoa> findPessoasSemTipoLogradouroTypedQuery(TipoLogradouro tipoLogradouro) {
        return em.createQuery("SELECT p FROM Pessoa p WHERE p.endereco.tipoLogradouro != :tipoLogradouro", Pessoa.class)
                .setParameter("tipoLogradouro", tipoLogradouro).getResultList();
    }

    @Override
    public List<Pessoa> findPessoasSemTipoLogradouroNamedQuery(TipoLogradouro tipoLogradouro) {
        return em.createNamedQuery("Pessoa.findPessoasSemTipoLogradouro", Pessoa.class)
                .setParameter("tipoLogradouro", tipoLogradouro).getResultList();
    }

    @Override
    public List<Pessoa> findNomeTelefonesPessoasQuery() {
        return (List<Pessoa>)em.createQuery("SELECT p.nome, t FROM Pessoa p JOIN p.telefones t")
                .getResultList();
        
    }

    @Override
    public List<Object[]> findNomeTelefonesPessoasTypedQuery() {
        return em.createQuery("SELECT p.nome, t FROM Pessoa p JOIN p.telefones t", Object[].class)
                .getResultList();

    }

    @Override
    public List<Object[]> findNomeTelefonesPessoasNamedQuery() {
        return em.createNamedQuery("Pessoas.findNomeTelefones", Object[].class)
                .getResultList();
    }

    @Override
    public List<Pessoa> findPessoasBydataNascimentoTypedQuery(LocalDate data1, LocalDate data2) {
        return em.createQuery("SELECT p FROM Pessoa p WHERE p.nascimento >= :data1 AND p.nascimento <= :data2", Pessoa.class)
                .setParameter("data1",data1).setParameter("data2",data2).getResultList();
    }

    @Override
    public List<Pessoa> findPessoasByDDDTypedQuery(Byte DDD) {
        return em.createQuery("SELECT p FROM Pessoa p JOIN p.telefones t WHERE t.ddd = :DDD", Pessoa.class)
                .setParameter("DDD", DDD)
                .getResultList();
    }

    @Override
    public List<Pessoa> findPessoasSemTelefoneTypedQuery() {
        return em.createQuery("SELECT p FROM Pessoa p WHERE p.telefones IS EMPTY",Pessoa.class)
                .getResultList();
    }


    @Override
    public List<Object[]> countTelefonesPessoaTypedQuery() {
        return em.createQuery("SELECT p.nome, COUNT(p) FROM Pessoa p JOIN p.telefones t GROUP BY p.nome",Object[].class).getResultList();
    }
    


}
