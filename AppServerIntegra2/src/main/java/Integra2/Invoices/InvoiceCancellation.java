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
public class InvoiceCancellation {
    
    public String factura;
    public String anulacion;
    
    public InvoiceCancellation(){}
    
    public InvoiceCancellation(String factura, String anulacion){
        this.factura = factura;
        this.anulacion = anulacion;
    }
}
