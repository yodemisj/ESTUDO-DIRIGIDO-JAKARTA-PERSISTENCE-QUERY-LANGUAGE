/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.yodemis.grupostrabalho;

import java.time.LocalDate;

/**
 * Classe MembroDto
 * @author yodem
 */
public class MembroDto {
    private String grupo;
    private String membro;
    private LocalDate entrada;

    public MembroDto() {
    }

    public MembroDto(String grupo, String membro, LocalDate entrada) {
        this.grupo = grupo;
        this.membro = membro;
        this.entrada = entrada;
    }
    
    public MembroDto(String grupo, String membro) {
        this.grupo = grupo;
        this.membro = membro;
    }
    
    

    //<editor-fold defaultstate="collapsed" desc="Getters e Setters">
    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getMembro() {
        return membro;
    }

    public void setMembro(String membro) {
        this.membro = membro;
    }

    public LocalDate getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDate entrada) {
        this.entrada = entrada;
    }
//</editor-fold>
    
    

}
