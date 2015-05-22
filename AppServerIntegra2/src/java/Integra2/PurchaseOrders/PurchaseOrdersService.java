/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integra2.PurchaseOrders;

import Integra2.BasicUrls;

/**
 *
 * @author Guillermo
 */
public class PurchaseOrdersService {
    
    //
    private static final String PUT_ORDER_URL = BasicUrls.PURCHASE_ORDER_SERVER + "/crear"; //PUT
    private static final String ACCEPT_ORDER_URL = BasicUrls.PURCHASE_ORDER_SERVER + "/recepcionar/"; //POST
    private static final String REJECT_ORDER_URL = BasicUrls.PURCHASE_ORDER_SERVER + "/rechazar/"; //POST
    private static final String CANCEL_ORDER_URL = BasicUrls.PURCHASE_ORDER_SERVER + "/anular/"; //DELETE
    private static final String GET_ORDER_URL = BasicUrls.PURCHASE_ORDER_SERVER + "/obtener/"; //GET
    //private static final String DISPATCH_ORDER_URL = BasicUrls.PURCHASE_ORDER_SERVER + "";
}
