/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sdk.Config;

import Utils.ReferenceGenerator;

public class TransactionData {
    protected String referenceNumber;
    protected String clientNumber;
    protected String paymentAmount;
    protected String otp;
    protected String externalReference;

    private TransactionData(String clientNumber, String paymentAmount, String otp, String externalReference) {
        this.otp = otp;
        this.paymentAmount = paymentAmount;
        this.clientNumber = clientNumber;
        this.externalReference = externalReference;
    }

    public static TransactionData from(String clientNumber, String paymentAmount, String otp, String externalReference) {
        return new TransactionData(clientNumber, paymentAmount, otp, externalReference);
    }

    public String getClientNumber() {
        return clientNumber;
    }

    public TransactionData setClientNumber(String clientNumber) {
        this.clientNumber = clientNumber;
        return this;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public TransactionData setAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
        return this;
    }

    public String getOtp() {
        return otp;
    }

    public TransactionData setOtp(String otp) {
        this.otp = otp;
        return this;
    }

    public String getReferenceNumber() {
        if (referenceNumber == null) {
            referenceNumber = ReferenceGenerator.getRandomRef();
        }
        return referenceNumber;
    }

    public TransactionData setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
        return this;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public TransactionData setExternalReference(String externalReference) {
        this.externalReference = externalReference;
        return this;
    }
}
