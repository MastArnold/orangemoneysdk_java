/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package http;

import Sdk.Config.Credentials;
import Sdk.Config.TransactionData;

/**
 *
 * @author Jonathan
 */
public class RequestBody {
    public static String from(Credentials credentials, TransactionData transactionData) {
        return "<?xml version='1.0' encoding='UTF-8'?>" +
               "<COMMAND>" +
               "<TYPE>OMPREQ</TYPE>" +
               "<customer_msisdn>" + transactionData.getClientNumber() + "</customer_msisdn>" +
               "<merchant_msisdn>" + credentials.getMerchant() + "</merchant_msisdn>" +
               "<api_username>" + credentials.getUsername() + "</api_username>" +
               "<api_password>" + credentials.getPassword() + "</api_password>" +
               "<amount>" + transactionData.getPaymentAmount() + "</amount>" +
               "<PROVIDER>101</PROVIDER>" +
               "<PROVIDER2>101</PROVIDER2>" +
               "<PAYID>12</PAYID>" +
               "<PAYID2>12</PAYID2>" +
               "<otp>" + transactionData.getOtp() + "</otp>" +
               "<reference_number>" + transactionData.getReferenceNumber() + "</reference_number>" +
               "<ext_txn_id>" + transactionData.getExternalReference() + "</ext_txn_id>" +
               "</COMMAND>";
    }
}
