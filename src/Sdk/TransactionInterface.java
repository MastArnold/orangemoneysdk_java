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
public interface TransactionInterface {
    TransactionResponseInterface processPayment() throws TransactionException;
}
