/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integra2.Bank;

/**
 *
 * @author Guillermo
 */
public class CreateTransaction {
    public String destino;
    public String origen;
    public int monto;
    
    public CreateTransaction(){}
    
    public CreateTransaction(String destino, String origen, int monto){
        this.destino = destino;
        this.origen = origen;
        this.monto = monto;
    }
}
