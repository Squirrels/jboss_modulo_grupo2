/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integra2.PurchaseOrders;

/**
 *
 * @author Guillermo
 */
public class PurchaseOrder {
    public String proveedor;
    public String sku;
    public String precioUnitario;
    public String cantidad;
    public String fechaEntrega;
    
    public PurchaseOrder(){}
    
    public PurchaseOrder(String proveedor, String sku, String precioUnitario, String cantidad, String fechaEntrega){
        this.proveedor = proveedor;
        this.sku = sku;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.fechaEntrega = fechaEntrega;
    }
}
