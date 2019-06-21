/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diffie;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author ld_si
 */
public class ChaveSimetrica {
    private SecretKey chave;

    public ChaveSimetrica() {
        try {
            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            SecretKey chaveDES = keygenerator.generateKey();
            this.chave = chaveDES;
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Erro - ChaveSimetrica.class: " + ex.getMessage());
        }
    }
    
    public String toString(SecretKey key){
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }
    
    public SecretKey toSecretKey(String key){
        byte[] decodedKey = Base64.getDecoder().decode(key);
        return new SecretKeySpec(decodedKey, 0, decodedKey.length, "DES");
    }
    
    public SecretKey getChave() {
        return chave;
    }

    public void setChave(SecretKey chave) {
        this.chave = chave;
    }
    
}
