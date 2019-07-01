/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.valueObject;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 *
 * @author artur
 */
public class Archive implements Serializable{
    
    @SerializedName("id")
    int id;
    
    @SerializedName("name")
    String Name;
    
    @SerializedName("url")
    String Url;
    
    //Aqui sera inserido o arquivo em Base64 para ser enviado ao servidor.
    @SerializedName("file")
    String File;

    public Archive() {
    }

    public Archive(int id, String Name, String Url) {
        this.id = id;
        this.Name = Name;
        this.Url = Url;
    }

    public String getFile() {
        return File;
    }

    public void setFile(String File) {
        this.File = File;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }
    
    


    
}
