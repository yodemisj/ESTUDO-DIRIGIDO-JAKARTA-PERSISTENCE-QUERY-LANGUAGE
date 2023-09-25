/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.yodemis.grupostrabalho;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;


/**
 * Classe Pessoa
 * @author yodem
 */
@Entity
@NamedQueries({
    @NamedQuery(
       name = "Pessoa.findAll",
       query = "SELECT p FROM Pessoa p"),
    @NamedQuery(
       name = "Pessoa.findName",
       query = "SELECT p.nome FROM Pessoa p"),
    @NamedQuery(
       name = "Pessoa.findNomeEndereco",
       query = "SELECT p.nome, p.endereco FROM Pessoa p"),
    @NamedQuery(
       name = "Pessoa.findByTipoLogradouro",
       query = "SELECT p FROM Pessoa p WHERE p.endereco.tipoLogradouro = :tipoLogradouro"),
    @NamedQuery(
       name = "Pessoa.findPessoasSemTipoLogradouro",
       query = "SELECT p FROM Pessoa p WHERE p.endereco.tipoLogradouro != :tipoLogradouro"),
    @NamedQuery(
       name = "Pessoas.findNomeTelefones",
       query = "SELECT p.nome, t FROM Pessoa p JOIN p.telefones t")
})
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 65)
    private String nome;
    
    @Column(length = 250)
    private String email;
    
    private LocalDate nascimento;
    
    @Transient
    private Byte idade;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name= "pessoa_id")
    private List<Telefone> telefones;
    
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Atuacao> atuacoes;
    
    @OneToOne(cascade = CascadeType.ALL
            , fetch = FetchType.EAGER)
    private Endereco endereco;
    
    @OneToMany(mappedBy = "lider"
            , cascade = CascadeType.ALL)
    private List<Grupo> lidera;

    public Pessoa() {
        this.telefones = new ArrayList<>() ;
        this.atuacoes = new ArrayList<>();
        this.lidera = new ArrayList<>();
    }

    //<editor-fold defaultstate="collapsed" desc="Getters e setters">

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
        this.setIdade();
    }

    public Byte getIdade() {
        this.setIdade();
        return idade;
    }

    public void setIdade() {
        int anos = Period.between(nascimento, LocalDate.now()).getYears();
        this.idade = (byte) anos;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Atuacao> getAtuacoes() {
        return atuacoes;
    }

    public void setAtuacoes(List<Atuacao> atuacoes) {
        this.atuacoes = atuacoes;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Grupo> getLidera() {
        return lidera;
    }

    public void setLidera(List<Grupo> lidera) {
        this.lidera = lidera;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id 
                + ", nome=" + nome 
                + ", email=" + email 
                + ", nascimento=" + nascimento 
                + ", idade=" + idade 
                + ", telefones=" + telefones 
                + ", atuacoes=" + atuacoes 
                + ", endereco=" + endereco 
                + ", lidera=" + lidera 
                + '}';
    }
    
    

}
