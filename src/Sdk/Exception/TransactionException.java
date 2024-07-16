/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sdk.Exception;

/**
 * 
 * @author Jonathan
 */
public class TransactionException extends Exception {
    private final int code;

    public TransactionException(String message, int code) {
        super(message);
        this.code = code;
    }

    public TransactionException(String message, Throwable cause) {
        super(message, cause);
        this.code = -1;
    }

    public int getCode() {
        return code;
    }
}

