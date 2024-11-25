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
public class Gerente extends Empregado {
    private double bonus;

    public Gerente(String n, double s, String dc) {
        super(n, s, dc);
    }
    
    public void setBonus(double b){
        this.bonus=b;
    }
    @Override
    public double getSalario(){
        return this.bonus+this.salario;
    }
    
    @Override
    public Object[] obterdados(){
        return new Object[] {this.nome,getSalario(),this.dataContratacao};
    }
}
