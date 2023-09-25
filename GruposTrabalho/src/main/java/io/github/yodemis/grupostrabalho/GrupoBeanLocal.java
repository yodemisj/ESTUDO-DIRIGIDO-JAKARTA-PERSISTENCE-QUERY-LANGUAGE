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
public interface GrupoBeanLocal {
    public List<Grupo> findGruposInativosTypedQuery();
    
    public List<Object[]> findLiderGruposTypedQuery();
    
    public List<Object[]> findNomeMembroGrupoTypedQuery(String nomegrupo);    
    
    public List<Grupo> findGrupoByliderTypedQuery(String nomelider);
    
    public List<Object[]> findAtuacaoGrupoByNomeTypedQuery(String nome);

    public List<Grupo> findGruposBySubstringTypedQuery(String substring);
    
    public List<Object[]> countMebrosGruposTypedQuery();
    
    public List<Object[]> findGruposByQuantidadeAtuacaoTypedQuery(int qtd);
    
    public List<Object[]> findMembrosByDataAtuacaoTypedQuery(List<Long> grupoIds, LocalDate dataInicio);

    public List<MembroDto> findMembrosDtoByDataAtuacaoTypedQuery(List<Long> gruposId2, LocalDate dataInicio2);

    public List<MembroDto> findMembrosDtoSemDataFimTypedQuery();

    public List<Object[]> findGruposNomeLiderMembrosTypedQuery();
    

    
}
