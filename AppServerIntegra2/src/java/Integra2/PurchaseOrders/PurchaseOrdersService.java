/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integra2.PurchaseOrders;

import Integra2.BasicUrls;
import Integra2.HttpRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
/**
 *
 * @author Guillermo
 */
@Path("PurchaseOrders")
public class PurchaseOrdersService {
    
    //
    private static final String PUT_ORDER_URL = BasicUrls.PURCHASE_ORDER_SERVER + "/crear"; //PUT
    private static final String ACCEPT_ORDER_URL = BasicUrls.PURCHASE_ORDER_SERVER + "/recepcionar/"; //POST
    private static final String REJECT_ORDER_URL = BasicUrls.PURCHASE_ORDER_SERVER + "/rechazar/"; //POST
    private static final String CANCEL_ORDER_URL = BasicUrls.PURCHASE_ORDER_SERVER + "/anular/"; //DELETE
    private static final String GET_ORDER_URL = BasicUrls.PURCHASE_ORDER_SERVER + "/obtener/"; //GET
    //private static final String DISPATCH_ORDER_URL = BasicUrls.PURCHASE_ORDER_SERVER + "";
    
    
    @GET
    @Produces("application/json")
    @Path("/{id}")
    public String getOrder(@PathParam("id") String orderId){
        
        HttpRequest response = HttpRequest.get(GET_ORDER_URL + orderId).contentType("application/json");
        return response.body();
    }
}
