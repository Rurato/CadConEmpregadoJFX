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
public class Secretario extends Empregado {
    private String turno;
    
    public Secretario(String n, double s, String dc, String turno) {
        super(n, s, dc);
        this.turno=turno;
    }
    
    public String getTurno(){
        return this.turno;
    }
    public void setTurn(String t){
        this.turno=t;
    }
    
    
}
