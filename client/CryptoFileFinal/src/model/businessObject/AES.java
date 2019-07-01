/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.businessObject;

/**
 *
 * @author ld_si
 */
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.*;
import javax.crypto.spec.*;

public class AES {
    private static String cifrado;
    private static String Decifrado;
    
    
     public static String encrypt(byte[] content, byte[] privateKey) {
            try {
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                System.out.println("Tamanho da chave: " + privateKey.length);

                cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(privateKey, "AES"));
                byte[] encrypted = cipher.doFinal(content);
                return encrypted.toString();
            } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
                System.out.println("Erro - " + ex.getMessage());
                return null;
            }
        }

    

    

    public static String decrypt(byte[] content, byte[] privateKey) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            System.out.println("Tamanho da chave: " + privateKey.length);

            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(privateKey, "AES"));
            byte[] encrypted = cipher.doFinal(content);
            return encrypted.toString();
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            System.out.println("Erro - " + ex.getMessage());
            return null;
        }
    }


}
