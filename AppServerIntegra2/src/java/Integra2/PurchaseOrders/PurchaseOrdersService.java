/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integra2.PurchaseOrders;

import Integra2.BasicUrls;
import Integra2.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
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
    
        
    @PUT
    @Produces("application/json")
    @Path("/")
    public Response createOrder(PurchaseOrder order){        
        
        HttpRequest response = HttpRequest.put(PUT_ORDER_URL).contentType("application/json")
                .form("proveedor", order.proveedor)
                .form("sku", order.sku)
                .form("precioUnitario", order.precioUnitario)
                .form("cantidad", order.cantidad)
                .form("canal", "b2b") //Fixed
                .form("cliente", "2") //Fixed
                .form("fechaEntrega", order.fechaEntrega);
        
        return Response.status(response.code()).entity(response.body()).build();
    }
    
    @POST
    @Produces("application/json")
    @Path("/accept/{id}")
    public Response acceptOrder(){
        return null;
    }
    
    @POST
    @Produces("application/json")
    @Path("/reject/{id}")
    public Response rejectOrder(){
        return null;
    }
    
    @DELETE
    @Produces("application/json")
    @Path("/")
    public Response cancelOrder(){
        return null;
    }
    
    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getOrder(@PathParam("id") String orderId){
        HttpRequest response = HttpRequest.get(GET_ORDER_URL + orderId).contentType("application/json");
        return Response.status(response.code()).entity(response.body()).build();
    }
}
