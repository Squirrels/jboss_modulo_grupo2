/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integra2;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Guillermo
 */
@javax.ws.rs.ApplicationPath("Integra2")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(Integra2.Bank.BankResource.class);
        resources.add(Integra2.Invoices.InvoicesResource.class);
        resources.add(Integra2.Odoo.OdooResource.class);
        resources.add(Integra2.PurchaseOrders.PurchaseOrdersResource.class);
    }
    
}
