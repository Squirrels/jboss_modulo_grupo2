/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integra2.Bank;

/**
 *
 * @author jamatte
 */
public class GetAccountStatement {
    public float inicio;
    public float fin;
    public String id;
    public int limit;
    
    public GetAccountStatement(){}
    
    public GetAccountStatement(float inicio, float fin, String id, int limit){
        this.inicio = inicio;
        this.fin = fin;
        this.id = id;
        this.limit = limit;
    }
    
    public GetAccountStatement(float inicio, float fin, String id){
        this(inicio, fin, id, -1);
    }
}
