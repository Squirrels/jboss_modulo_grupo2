/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integra2.Invoices;

/**
 *
 * @author Guillermo
 */
public class Ticket {
    //public String proveedor = "556489daefb3d7030091baab"; //Desarrollo
    public String proveedor = "55648ad2f89fed0300524ff6"; //Produccion
    public String cliente;
    public int total;
    
    public Ticket() {}
    
    public Ticket(String cliente, int total){
        this.cliente = cliente;
        this.total = total;
    }
}
