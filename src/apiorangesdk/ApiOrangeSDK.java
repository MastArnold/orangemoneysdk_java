/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiorangesdk;

import Sdk.Config.TransactionData;
import Sdk.Exception.TransactionException;
import Sdk.OrangeMoneyAPI;
import Sdk.PaymentSDK;
import Sdk.TransactionResponse;

/**
 *
 * @author Jonathan
 */
public class ApiOrangeSDK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            OrangeMoneyAPI orangeApi = new OrangeMoneyAPI("MO-YAN", "password", "Orange@123")
                    .withTransactionData(TransactionData.from("65426926", "1000", "087163", "12345"))
                    //.withCustomReference("123456778") // optional
                    .useProdApi() // for production
                    .withoutSSLVerification(); // if you have any troubleshoot with ssl verification (not recommended)

            PaymentSDK paymentSDK = new PaymentSDK(orangeApi);
            TransactionResponse response = paymentSDK.handlePayment();
            System.out.println("Merci pour votre achat !");
            System.out.println("Transaction ID: " + response.getTransactionId());
        } catch (TransactionException e) {
            System.out.println("Oups! Impossible de procéder au payement.");
            System.out.println("Message d'erreur sur la requête: " + e.getMessage());
            System.out.println("Code d'erreur sur la requête: " + e.getCode());
        }
    }
    
}
