/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB31/SingletonEjbClass.java to edit this template
 */
package io.github.yodemis.grupostrabalho;

import java.time.LocalDate;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
/**
 *
 * @author yodem
 */
@Singleton
@Startup
public class CargaDados implements CargaDadosLocal {
    @Inject
    private PessoaBeanLocal pb;
    
    @PostConstruct
    @Override   
    public void popularBanco() {
    // Criação e persistência de objetos
             
        //<editor-fold defaultstate="collapsed" desc="Pessoa1">
        
        // Pessoa 1
        
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Ana Zaira");
        pessoa1.setEmail("ana@mail.com");
        pessoa1.setNascimento(LocalDate.of(2001,1,1));
            // Telefone 1
        Telefone telefone1 = new Telefone();
        telefone1.setDdd((byte)11);
        telefone1.setNumero(11111111);
            // Telefone 2
        Telefone telefone2 = new Telefone();
        telefone2.setDdd((byte)12);
        telefone2.setNumero(12121212);
            // Telefone 3
        Telefone telefone3 = new Telefone();
        telefone3.setDdd((byte)13);
        telefone3.setNumero(13131313);
        
        Endereco endereco1 = new Endereco();
        endereco1.setBairro("Humberto");
        endereco1.setLogradouro("1");
        endereco1.setNumero(1111);
        endereco1.setTipoLogradouro(TipoLogradouro.RUA);
        
        
        pessoa1.getTelefones().add(telefone1);       
        pessoa1.getTelefones().add(telefone2);
        pessoa1.getTelefones().add(telefone3);
        pessoa1.setEndereco(endereco1);
        
//</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="pessoa2">

        // Pessoa 2
        
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Beatriz Yana");
        pessoa2.setEmail("beatriz@mail.com");
        pessoa2.setNascimento(LocalDate.of(2002,2,2));
            // Telefone 4
        Telefone telefone4 = new Telefone();
        telefone4.setDdd((byte)22);
        telefone4.setNumero(22222222);
            // Endereco 2
        Endereco endereco2 = new Endereco();
        endereco2.setBairro("Doisberto");
        endereco2.setLogradouro("2");
        endereco2.setNumero(2222);
        endereco2.setTipoLogradouro(TipoLogradouro.AVENIDA);
        
        pessoa2.getTelefones().add(telefone4);
        pessoa2.setEndereco(endereco2);
//</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="pessoa3">

    
        // Pessoa 3
        
        Pessoa pessoa3 = new Pessoa();
        pessoa3.setNome("Cecília Xerxes");
        pessoa3.setEmail("cecilia@mail.com");
        pessoa3.setNascimento(LocalDate.of(2003,3,3));
        
            // Endereco 3
        Endereco endereco3 = new Endereco();
        endereco3.setBairro("Trêsberto");
        endereco3.setLogradouro("3");
        endereco3.setNumero(3333);
        endereco3.setTipoLogradouro(TipoLogradouro.AVENIDA);
   

        pessoa3.setEndereco(endereco3);
//</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="pessoa4">


        // Pessoa 4
        
        Pessoa pessoa4 = new Pessoa();
        pessoa4.setNome("Débora Wendel");
        pessoa4.setEmail("debora@mail.com");
        pessoa4.setNascimento(LocalDate.of(2004,4,4));
            // Telefone 5
        Telefone telefone5 = new Telefone();
        telefone5.setDdd((byte)44);
        telefone5.setNumero(44444444);
            // Telefone 6
        Telefone telefone6 = new Telefone();
        telefone6.setDdd((byte)45);
        telefone6.setNumero(45454545);
            // Endereco 4
        Endereco endereco4 = new Endereco();
        endereco4.setBairro("Quatroberto");
        endereco4.setLogradouro("4");
        endereco4.setNumero(4444);
        endereco4.setTipoLogradouro(TipoLogradouro.PRACA);
        
        pessoa4.setEndereco(endereco4);
        pessoa4.getTelefones().add(telefone5);
        pessoa4.getTelefones().add(telefone6);
//</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Grupo1">

        
        // Grupo 1
        
        Grupo grupo1 = new Grupo();
        grupo1.setAtivo(Boolean.FALSE);
        grupo1.setNome("Estudo I");
        grupo1.setLider(pessoa1);
        pessoa1.getLidera().add(grupo1);
        
        // Atuacao 1 01/01/2011 a 11/11/2021
        
        Atuacao atuacao1 = new Atuacao();
        atuacao1.setInicio(LocalDate.of(2011,1,1));        
        atuacao1.setTermino(LocalDate.of(2021,11,11));
        atuacao1.setGrupo(grupo1);
        atuacao1.setPessoa(grupo1.getLider());
        pessoa1.getAtuacoes().add(atuacao1);
        
        // Atuacao 2    01/01/2012 a 11/11/2022
        
        Atuacao atuacao2 = new Atuacao();
        atuacao2.setInicio(LocalDate.of(2012,1,1));        
        atuacao2.setTermino(LocalDate.of(2022,11,11));
        atuacao2.setGrupo(grupo1);
        atuacao2.setPessoa(pessoa1);
        pessoa1.getAtuacoes().add(atuacao2);

        
        // Atuacao 3    02/01/2012 a 12/01/2021
        
        Atuacao atuacao3 = new Atuacao();
        atuacao3.setInicio(LocalDate.of(2012,1,2));        
        atuacao3.setTermino(LocalDate.of(2021,1,12));
        atuacao3.setGrupo(grupo1);
        atuacao3.setPessoa(pessoa2);
        pessoa2.getAtuacoes().add(atuacao3);
        
        // Atuacao 4    03/01/2013 a 13/01/2021
        
        Atuacao atuacao4 = new Atuacao();
        atuacao4.setInicio(LocalDate.of(2013,1,3));        
        atuacao4.setTermino(LocalDate.of(2022,1,13));
        atuacao4.setGrupo(grupo1);
        atuacao4.setPessoa(pessoa3);
        pessoa3.getAtuacoes().add(atuacao4);
        
        // Atuacao 5    04/01/2014 a 14/01/2021
        
        Atuacao atuacao5 = new Atuacao();
        atuacao5.setInicio(LocalDate.of(2014,1,4));        
        atuacao5.setTermino(LocalDate.of(2022,1,14));
        atuacao5.setGrupo(grupo1);
        atuacao5.setPessoa(pessoa4);
        pessoa4.getAtuacoes().add(atuacao5);
        
        grupo1.getAtuacoes().add(atuacao1);
        grupo1.getAtuacoes().add(atuacao2);
        grupo1.getAtuacoes().add(atuacao3);
        grupo1.getAtuacoes().add(atuacao4);
        grupo1.getAtuacoes().add(atuacao5);

        
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Grupo2">


        // Grupo 2
        Grupo grupo2 = new Grupo();
        grupo2.setAtivo(Boolean.TRUE);
        grupo2.setNome("Estudo II");
        grupo2.setLider(pessoa2);
        pessoa2.getLidera().add(grupo2);
        
        // Atuacao 6    02/01/2012 a indefinido
        
        Atuacao atuacao6 = new Atuacao();
        atuacao6.setInicio(LocalDate.of(2012,1,2));        
        atuacao6.setGrupo(grupo2);
        atuacao6.setPessoa(grupo2.getLider());
        pessoa2.getAtuacoes().add(atuacao6);
        
        // Atuacao 7    02/01/2012 a indefinido
        
        Atuacao atuacao7 = new Atuacao();
        atuacao7.setInicio(LocalDate.of(2012,1,2));
        atuacao7.setGrupo(grupo2);
        atuacao7.setPessoa(pessoa4);
        pessoa2.getAtuacoes().add(atuacao7);
        
        grupo2.getAtuacoes().add(atuacao6);
        grupo2.getAtuacoes().add(atuacao7);
        
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Grupo3">

        // Grupo 3
        Grupo grupo3 = new Grupo();
        grupo3.setAtivo(Boolean.FALSE);
        grupo3.setNome("Estudo III");
        grupo3.setLider(pessoa3);
        pessoa3.getLidera().add(grupo3);
        
        
        // Atuacao 8 03/01/2012 a 13/01/2023
        
        Atuacao atuacao8 = new Atuacao();
        atuacao8.setInicio(LocalDate.of(2012,1,3));        
        atuacao8.setTermino(LocalDate.of(2023,1,13));
        atuacao8.setGrupo(grupo3);
        atuacao8.setPessoa(grupo3.getLider());
        pessoa3.getAtuacoes().add(atuacao8);
        
        // Atuacao 9    03/01/2012 a 13/01/2023
        
        Atuacao atuacao9 = new Atuacao();
        atuacao9.setInicio(LocalDate.of(2012,1,3));        
        atuacao9.setTermino(LocalDate.of(2023,1,13));
        atuacao9.setGrupo(grupo3);
        atuacao9.setPessoa(pessoa4);
        pessoa4.getAtuacoes().add(atuacao9);
        
        grupo3.getAtuacoes().add(atuacao8);
        grupo3.getAtuacoes().add(atuacao9);
        
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Grupo4">

        // Grupo 4
        Grupo grupo4 = new Grupo();
        grupo4.setAtivo(Boolean.TRUE);
        grupo4.setNome("Estudo IV");
        grupo4.setLider(pessoa2);
        pessoa3.getLidera().add(grupo4);
        
        // Atuacao 10 04/01/2012 a 14/01/2024
        
        Atuacao atuacao10 = new Atuacao();
        atuacao10.setInicio(LocalDate.of(2012,1,4));        
        atuacao10.setTermino(LocalDate.of(2024,1,14));
        atuacao10.setGrupo(grupo4);
        atuacao10.setPessoa(grupo4.getLider());
        pessoa2.getAtuacoes().add(atuacao10);
        
        // Atuacao 11    04/01/2012 a 14/01/2024
        
        Atuacao atuacao11 = new Atuacao();
        atuacao11.setInicio(LocalDate.of(2012,1,4));        
        atuacao11.setTermino(LocalDate.of(2024,1,14));
        atuacao11.setGrupo(grupo4);
        atuacao11.setPessoa(pessoa3);
        pessoa3.getAtuacoes().add(atuacao11);
        
        // Atuacao 12   04/01/2012 a 14/01/2024
        
        Atuacao atuacao12 = new Atuacao();
        atuacao12.setInicio(LocalDate.of(2012,1,4));        
        atuacao12.setTermino(LocalDate.of(2024,1,14));
        atuacao12.setGrupo(grupo4);
        atuacao12.setPessoa(pessoa4);
        pessoa4.getAtuacoes().add(atuacao12);
        
        grupo4.getAtuacoes().add(atuacao10);
        grupo4.getAtuacoes().add(atuacao11);
        grupo4.getAtuacoes().add(atuacao12);


//</editor-fold>
        
        pb.save(pessoa1);          
        pb.save(pessoa2);
        pb.save(pessoa3);
        pb.save(pessoa4);

    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
