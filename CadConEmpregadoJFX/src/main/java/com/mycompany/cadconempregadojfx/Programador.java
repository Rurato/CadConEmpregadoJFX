/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cadconempregadojfx;

import java.util.Date;

/**
 *
 * @author joaog
 */
public class Programador extends Empregado {
    private String areaProg;
    
    public Programador(String n, double s, String dc, String areaProg) {
        super(n, s, dc);
        this.areaProg = areaProg;
    }
    
    public void setAreaProg(String a){
        this.areaProg = a;
    }
    public String getAreaProg(){
        return this.areaProg;
    }
    
    @Override
    public Object[] obterdados(){
        return new Object[] {this.nome,this.salario,this.dataContratacao,this.areaProg};
    }
}
