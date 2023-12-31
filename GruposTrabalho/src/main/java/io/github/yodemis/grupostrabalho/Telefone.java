/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.yodemis.grupostrabalho;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * Classe Telefone
 * @author yodem
 */
@Entity
public class Telefone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Byte ddd;
    @Column
    private Integer numero;
    
    //<editor-fold defaultstate="collapsed" desc="Getters e Setters">
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getDdd() {
        return ddd;
    }

    public void setDdd(Byte ddd) {
        this.ddd = ddd;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

//</editor-fold>

    @Override
    public String toString() {
        return "Telefone{" + "ddd=" + ddd 
                + ", numero=" + numero 
                + '}';
    }
    
    
    

}
