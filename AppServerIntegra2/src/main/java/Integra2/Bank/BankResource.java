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
import Integra2.Bank.Transaction.TransaccionArray;
import Integra2.Bank.Transaction.Trx;
import Integra2.Bank.Transaction.Trx_Service;
import java.util.Iterator;
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
    @Path("/Accounts/{id}")
    public Response getAccount(@PathParam("id") String accountId) throws BadParametersException, ErrorException{
        
        try { // Call Web Service Operation
            Cuenta_Service service = new Cuenta_Service();
            Cuenta port = service.getCuentaPort();
            
            // TODO process result here
            CuentaBancoArray result = port.getCuenta(accountId);
            List<CuentaBanco> accountList = result.getItem();
            CuentaBanco bankAccount = accountList.get(0);
            String id = bankAccount.getId();
            String group = bankAccount.getGrupo();
            int balance = bankAccount.getSaldo();
            String json = "{\"id\":\"" + id + "\","
                    + "\"grupo\":\"" + group + "\","
                    + "\"saldo\":" + balance + "}";
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            String json = "{\"error\":\"" + ex.toString() + "\"}";
            return Response.status(501).tag(json).type(MediaType.APPLICATION_JSON).build();
        } 
    }

    @POST
    @Produces("application/json")
    @Path("/AccountStatements/")
    public Response getCartola(GetAccountStatement accountStatementData) throws BadParametersException, ErrorException{
        
        try { // Call Web Service Operation
            Cuenta_Service service = new Cuenta_Service();
            Cuenta port = service.getCuentaPort();
            // TODO initialize WS operation arguments here
            GetCartola cartola = new GetCartola();
            cartola.setInicio(accountStatementData.inicio);
            cartola.setFin(accountStatementData.fin);
            cartola.setId(accountStatementData.id);
            
            //Optional Limit
            if(accountStatementData.limit != -1)
                cartola.setLimit(accountStatementData.limit);

            // TODO process result here
            Cartola result = port.getCartola(cartola);
            
            List<Integra2.Bank.Account.Transaccion> transactions = result.getTransacciones();
            String json = "";
            Iterator<Integra2.Bank.Account.Transaccion> iterator = transactions.iterator();
            
            int i = 0;
            int size = transactions.size();
            while(iterator.hasNext()){
                Integra2.Bank.Account.Transaccion transaction = iterator.next();
                if(transaction.getOrigen().compareTo(accountStatementData.id) == 0
                        ||  transaction.getDestino().compareTo(accountStatementData.id) == 0){
                    String id = transaction.getId();
                    String from = transaction.getOrigen();
                    String to = transaction.getDestino();
                    int amount = transaction.getMonto();
                    String date = transaction.getUpdatedAt();
                    String v = transaction.getV();
                    
                    json = json + "{\"id\":\"" + id + "\","
                    + "\"origen\":\"" + from + "\","
                    + "\"destino\":\"" + to + "\","
                    + "\"monto\":" + amount + ","
                    + "\"updatedAt\":\"" + date + "\","
                    + "\"v\":\"" + v + "\""
                    +"},";
                }
            }
            json = json.substring(0, json.length()-1);
            json = "{\"transacciones\":[" + json + "]}";
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
            
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            String json = "{\"error\":\"" + ex.toString() + "\"}";
            return Response.status(501).tag(json).type(MediaType.APPLICATION_JSON).build();
        }
        
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
            
            String id = result.getId();
            String from = result.getOrigen();
            String to = result.getDestino();
            int amount = result.getMonto();
            String date = result.getUpdatedAt();
            String v = result.getV();
            String json = "{\"id\":\"" + id + "\","
                    + "\"origen\":\"" + from + "\","
                    + "\"destino\":\"" + to + "\","
                    + "\"monto\":" + amount + ","
                    + "\"updatedAt\":\"" + date + "\","
                    + "\"v\":\"" + v + "\""
                    +"}";
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
            
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            String json = "{\"error\":\"" + ex.toString() + "\"}";
            return Response.status(501).tag(json).type(MediaType.APPLICATION_JSON).build();
        }           
    }
    
    @GET
    @Produces("application/json")
    @Path("/Transactions/{id}")
    public Response getTransaction(@PathParam("id")String transactionId){
        
        try { // Call Web Service Operation
            Trx_Service service = new Trx_Service();
            Trx port = service.getTrxPort();
            // TODO process result here
            TransaccionArray result = port.getTransaccion(transactionId);
            Transaccion transaction = result.getItem().get(0);
            
            String id = transaction.getId();
            String from = transaction.getOrigen();
            String to = transaction.getDestino();
            int amount = transaction.getMonto();
            String date = transaction.getUpdatedAt();
            String v = transaction.getV();
            String json = "{\"id\":\"" + id + "\","
                    + "\"origen\":\"" + from + "\","
                    + "\"destino\":\"" + to + "\","
                    + "\"monto\":" + amount + ","
                    + "\"updatedAt\":\"" + date + "\","
                    + "\"v\":\"" + v + "\""
                    +"}";
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            String json = "{\"error\":\"" + ex.toString() + "\"}";
            return Response.status(501).tag(json).type(MediaType.APPLICATION_JSON).build();
        }

    }
}
