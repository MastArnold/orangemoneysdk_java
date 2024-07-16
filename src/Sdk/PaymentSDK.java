/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sdk;

import Sdk.Exception.TransactionException;

/**
 * 
 * @author Jonathan
 */
public class PaymentSDK {
    private TransactionInterface transaction;

    public PaymentSDK(TransactionInterface transaction) {
        this.transaction = transaction;
    }

    public TransactionResponse handlePayment() throws TransactionException {
        return (TransactionResponse) transaction.processPayment();
    }
}

