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
public class Executivo extends Gerente {
    private double bonusCoopartivipacao;
    
    public Executivo(String n, double s, String dc) {
        super(n, s, dc);
    }
    
    public void setBonusCooparticipacao(double b){
        this.bonusCoopartivipacao=b;
    }
    @Override
    public double getSalario(){
        return this.bonusCoopartivipacao+this.salario;
    }
    
    @Override
    public Object[] obterdados(){
        return new Object[] {this.nome,getSalario(),this.dataContratacao};
    }
}
