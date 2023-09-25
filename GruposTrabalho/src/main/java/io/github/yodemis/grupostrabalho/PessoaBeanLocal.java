/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package io.github.yodemis.grupostrabalho;

import java.time.LocalDate;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author yodem
 */
@Local
public interface PessoaBeanLocal {
    public void save(Pessoa pessoa);
    
    List<Pessoa> findAllPessoaQuery();
    
    List<Pessoa> findAllPessoaTypedQuery();
    
    List<Pessoa> findAllPessoaNamedQuery();
    
    List<String> findNomePessoaQuery();
    
    List<String> findNomePessoaTypedQuery();
    
    List<String> findNomePessoaNamedQuery();
    
    List<Pessoa> findNomeEnderecoPessoaQuery();
    
    List<Object[]> findNomeEnderecoPessoaTypedQuery();
    
    List<Object[]> findNomeEnderecoPessoaNamedQuery();
    
    List<Pessoa> findPessoaByTipoLogradouroQuery(TipoLogradouro tipoLogradouro);
    
    List<Pessoa> findPessoaByTipoLogradouroTypedQuery(TipoLogradouro tipoLogradouro);
    
    List<Pessoa> findPessoaByTipoLogradouroNamedQuery(TipoLogradouro tipoLogradouro);
    
    List<Pessoa> findPessoasSemTipoLogradouroQuery(TipoLogradouro tipoLogradouro);
    
    List<Pessoa> findPessoasSemTipoLogradouroTypedQuery(TipoLogradouro tipoLogradouro);
    
    List<Pessoa> findPessoasSemTipoLogradouroNamedQuery(TipoLogradouro tipoLogradouro);
    
    List<Pessoa> findNomeTelefonesPessoasQuery();
    
    List<Object[]> findNomeTelefonesPessoasTypedQuery();
    
    List<Object[]> findNomeTelefonesPessoasNamedQuery();
    
    List<Pessoa> findPessoasBydataNascimentoTypedQuery(LocalDate data1, LocalDate data2);    
    
    List<Pessoa> findPessoasByDDDTypedQuery(Byte DDD);    
    
    List<Pessoa> findPessoasSemTelefoneTypedQuery();  
    
    List<Object[]> countTelefonesPessoaTypedQuery();
    

}
