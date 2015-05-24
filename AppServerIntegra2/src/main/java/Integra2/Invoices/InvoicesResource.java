/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integra2.Invoices;

import Integra2.BasicUrls;
import Integra2.HttpRequest;
import java.util.concurrent.ExecutionException;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.client.ClientRequest;

/**
 *
 * @author Guillermo
 */
@Path("Invoices")
public class InvoicesResource {
    private static final String ISSUE_INVOICE_URL = BasicUrls.INVOICE_SERVER; //PUT
    private static final String GET_INVOICE_URL = BasicUrls.INVOICE_SERVER; //GET
    private static final String PAY_INVOICE_URL = BasicUrls.INVOICE_SERVER + "/pay/"; //POST
    private static final String REJECT_INVOICE_URL = BasicUrls.INVOICE_SERVER + "/reject/"; //POST
    private static final String CANCEL_INVOICE_URL = BasicUrls.INVOICE_SERVER + "/cancel/"; //POST

    @PUT
    @Produces("application/json")
    @Path("/{id}")
    public Response issueInvoice(Invoice invoice){
        HttpRequest response = HttpRequest.put(ISSUE_INVOICE_URL).contentType("application/json")
                .form("order", invoice.order);
        
        return Response.status(response.code()).entity(response.body()).build();
    }
    
    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getInvoice(@PathParam("id") String invoiceId){
        HttpRequest response = HttpRequest.get(GET_INVOICE_URL + invoiceId).contentType("application/json");
        return Response.status(response.code()).entity(response.body()).build();
    }
    
    @POST
    @Produces("application/json")
    @Path("/pay/")
    public Response payInvoice(InvoicePayment payment){
        HttpRequest response = HttpRequest.get(PAY_INVOICE_URL).contentType("application/json")
                .form("factura", payment.factura);
        return Response.status(response.code()).entity(response.body()).build();
    }
    
    @POST
    @Produces("application/json")
    @Path("/reject/")
    public Response rejectInvoice(InvoiceRejection reason){
        HttpRequest response = HttpRequest.post(REJECT_INVOICE_URL).contentType("application/json")
                .form("factura", reason.factura)
                .form("rechazo", reason.rechazo);
        return Response.status(response.code()).entity(response.body()).build();
    }
    
    @POST
    @Produces("application/json")
    @Path("/cancel/")
    public Response cancelInvoice(InvoiceCancellation reason){
        HttpRequest response = HttpRequest.post(CANCEL_INVOICE_URL).contentType("application/json")
                .form("factura", reason.factura)
                .form("anulacion", reason.anulacion);
        return Response.status(response.code()).entity(response.body()).build();
    }
}
