/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cadconempregadojfx;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author joaog
 */
public class Empregado {
    protected String nome;
    protected double salario;
    protected String dataContratacao;
    
    public Empregado(String n, double s, String dc){
        this.nome = n;
        this.salario = s;
        this.dataContratacao = dc;
    }
    
    public String getNome(){
        return this.nome;
    }
    public double getSalario(){
        return this.salario;
    }
    public String getDataContratacao(){
        return this.dataContratacao;
    }
    public void aumentoSalarial(double percentual){
        this.salario=this.salario+(this.salario*(percentual/100));
    }
    
    public Object[] obterdados(){
        return new Object[] {this.nome,this.salario,this.dataContratacao};
    }
}
