/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sdk.Config;

public final class Credentials {
    private String username;
    private String password;
    private String merchant;

    private Credentials(String username, String password, String merchant) {
        this.username = username;
        this.password = password;
        this.merchant = merchant;
    }

    public String getUsername() {
        return username;
    }

    public Credentials setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Credentials setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getMerchant() {
        return merchant;
    }

    public Credentials setMerchant(String merchant) {
        this.merchant = merchant;
        return this;
    }

    public static Credentials from(String username, String password, String merchant) {
        return new Credentials(username, password, merchant);
    }
}

