/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integra2.Invoices;

/**
 *
 * @author Andres
 */
public class InvoiceRejection {
    
    public String id;
    public String motivo;
    
    public InvoiceRejection() {};
    
    public InvoiceRejection(String id, String motivo){
        this.id = id;
        this.motivo = motivo;
    }
}
