package model.valueObject;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Sharing implements Serializable {

    @SerializedName("id")
    private int id;

    @SerializedName("idUser")
    private int idUser;

    @SerializedName("idArchive")
    private int idArchive;

    @SerializedName("permition")
    private String permition;

    public Sharing() {
    }

    public Sharing(int id, int idUser, int idArchive, String permition) {
        this.id = id;
        this.idUser = idUser;
        this.idArchive = idArchive;
        this.permition = permition;
    }

    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdArchive() {
        return idArchive;
    }

    public void setIdArchive(int idArchive) {
        this.idArchive = idArchive;
    }

    public String getPermition() {
        return permition;
    }

    public void setPermition(String permition) {
        this.permition = permition;
    }

}
