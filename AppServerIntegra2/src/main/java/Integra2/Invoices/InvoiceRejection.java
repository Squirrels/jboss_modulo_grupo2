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
    
    public String factura;
    public String rechazo;
    
    public InvoiceRejection() {};
    
    public InvoiceRejection(String factura, String rechazo){
        this.factura = factura;
        this.rechazo = rechazo;
    }
}
