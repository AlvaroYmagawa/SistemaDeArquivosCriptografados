/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.valueObject;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import model.businessObject.Hash;



/**
 *
 * @author artur
 */
public class User implements Serializable{
    
    @SerializedName("name")
    String Name;
    
    @SerializedName("email")
    String email;
    
    @SerializedName("password")
    String Senha;
    
    @SerializedName("authentication_token")
    String Token;
    
    
    @SerializedName("public_key")
    String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    
    

    public User() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
    }
    
    
    
}
