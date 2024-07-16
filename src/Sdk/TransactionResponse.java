/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sdk;

import org.json.JSONObject;

public class TransactionResponse implements TransactionResponseInterface {
    private int status;
    private String message;
    private String transactionId;

    private TransactionResponse(int status, String message, String transactionId) {
        this.status = status;
        this.message = message;
        this.transactionId = transactionId;
    }

    public static TransactionResponse fromXMLResponse(JSONObject xmlResponse) {
        return new TransactionResponse(
            xmlResponse.getInt("status"),
            xmlResponse.getString("message"),
            xmlResponse.getString("transID")
        );
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public String getTransactionId() {
        return transactionId;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
