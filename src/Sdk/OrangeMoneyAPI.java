/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sdk;

import http.XMLHttp;
import http.RequestBody;
import Sdk.Config.Credentials;
import Sdk.Config.TransactionData;
import Sdk.Exception.TransactionException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/**
 * 
 * @author Jonathan
 */
public class OrangeMoneyAPI implements TransactionInterface {
    private static final String DEV_API_URL = "https://testom.orange.bf:9008/payment";
    private static final String PROD_API_URL = "https://apiom.orange.bf";

    private TransactionData transactionData;
    private Credentials credentials;
    private String apiUrl;
    private boolean withSSLVerification = XMLHttp.WITH_SSL_ENABLED;

    public OrangeMoneyAPI(String username, String password, String merchantNumber) {
        this.credentials = Credentials.from(username, password, merchantNumber);
        this.useDevApi();
    }

    @Override
    public TransactionResponseInterface processPayment() throws TransactionException {
        try {
            Map<String, Object> response = processRequest();
            int errno = (int) response.get("errno");
            String errorMessage = (String) response.get("error");
            if (errno > 0) {
                throw new TransactionException(errorMessage, errno);
            }

            TransactionResponse responseObj = TransactionResponse.fromXMLResponse((JSONObject) response.get("response"));
            if (responseObj.getStatus() != 200) {
                throw new TransactionException(responseObj.getMessage(), responseObj.getStatus());
            }

            return responseObj;
        } catch (Exception e) {
            throw new TransactionException(e.getMessage(), e);
        }
    }

    private Map<String, Object> processRequest() throws Exception {
        return XMLHttp.request(apiUrl, new ArrayList<String>(), RequestBody.from(credentials, transactionData), withSSLVerification);
    }

    public OrangeMoneyAPI withCustomReference(String reference) {
        transactionData.setReferenceNumber(reference);
        return this;
    }

    public OrangeMoneyAPI withExternalReference(String externalReference) {
        transactionData.setExternalReference(externalReference);
        return this;
    }

    public OrangeMoneyAPI withTransactionData(TransactionData transactionData) {
        this.transactionData = transactionData;
        return this;
    }

    public OrangeMoneyAPI withoutSSLVerification() {
        this.withSSLVerification = XMLHttp.WITH_SSL_DISABLED;
        return this;
    }

    public OrangeMoneyAPI useDevApi() {
        this.apiUrl = DEV_API_URL;
        return this;
    }

    public OrangeMoneyAPI useProdApi() {
        this.apiUrl = PROD_API_URL;
        return this;
    }
}

