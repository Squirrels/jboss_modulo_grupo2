/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integra2.Bank;

import Integra2.Bank.Account.BadParametersException;
import Integra2.Bank.Account.Cartola;
import Integra2.Bank.Account.Cuenta;
import Integra2.Bank.Account.CuentaBanco;
import Integra2.Bank.Account.CuentaBancoArray;
import Integra2.Bank.Account.Cuenta_Service;
import Integra2.Bank.Account.ErrorException;
import Integra2.Bank.Account.GetCartola;
import Integra2.Bank.Transaction.CrearTransaccion;
import Integra2.Bank.Transaction.Transaccion;
import Integra2.Bank.Transaction.Trx;
import Integra2.Bank.Transaction.Trx_Service;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Guillermo
 */
@Path("Bank")
public class BankResource {
    
    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getAccount(@PathParam("id") String accountId) throws BadParametersException, ErrorException{
        
        try { // Call Web Service Operation
            Cuenta_Service service = new Cuenta_Service();
            Cuenta port = service.getCuentaPort();
            
            // TODO process result here
            CuentaBancoArray result = port.getCuenta(accountId);
            List<CuentaBanco> accountList = result.getItem();
            CuentaBanco bankAccount = accountList.get(0);
            String json = "{\"saldo\":" + bankAccount.getSaldo() + "}";
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            String json = "{\"error\":\"" + ex.toString() + "\"}";
            return Response.status(501).tag(json).type(MediaType.APPLICATION_JSON).build();
        } 
    }

    @POST
    @Produces("application/json")
    @Path("/cartola")
    public Response getCartola(ClassGetCartola CgetCartola) throws BadParametersException, ErrorException{
        
        try { // Call Web Service Operation
            Cuenta_Service service = new Cuenta_Service();
            Cuenta port = service.getCuentaPort();
            // TODO initialize WS operation arguments here
            GetCartola cartola = new GetCartola();
            cartola.setInicio(CgetCartola.inicio);
            cartola.setFin(CgetCartola.fin);
            cartola.setId(CgetCartola.id);
            cartola.setLimit(CgetCartola.limit);

            // TODO process result here
            Cartola result = port.getCartola(cartola);
            return Response.ok("Result = " + result, MediaType.TEXT_PLAIN).build();
            
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        
        return Response.status(501).build();
        
    }
    
    
    @PUT
    @Produces("application/json")
    @Path("/Transactions/")
    public Response createTransaction(CreateTransaction createTransaction){
        
        try { // Call Web Service Operation
            Trx_Service service = new Trx_Service();
            Trx port = service.getTrxPort();
            // TODO initialize WS operation arguments here
            CrearTransaccion trx = new CrearTransaccion();
            
            trx.setDestino(createTransaction.destino);
            trx.setOrigen(createTransaction.origen);
            trx.setMonto(createTransaction.monto);
            
            // TODO process result here
            Transaccion result = port.crearTransaccion(trx);
            return Response.ok("Result = " + result, MediaType.TEXT_PLAIN).build();
            
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        
        return Response.status(501).build();

    
        
}
}
