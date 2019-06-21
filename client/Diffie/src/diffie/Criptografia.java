/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diffie;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author ld_si
 */
public class Criptografia {
    public static SecretKey simetricKey(){
        try {
            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            SecretKey chaveDES = keygenerator.generateKey();
            return chaveDES;
        } catch (NoSuchAlgorithmException ex) {
            return null;
        }
    }
    public static byte[] simetricCript(byte[] txtPuro, byte[] chave) {

        try {

            System.out.println("Chave recebida:"+chave);

            Cipher cifraDES;

            // Cria a cifra 
            cifraDES = Cipher.getInstance("DES/ECB/PKCS5Padding");

            // Inicializa a cifra para o processo de encriptação
            cifraDES.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(chave, 0, chave.length, "DES"));
            

            // Texto puro
           //byte[] txtPuro = "Exemplo de texto puro".getBytes();


            // Texto encriptado
            byte[] textoEncriptado = cifraDES.doFinal(txtPuro);
   
            return textoEncriptado;
           
            
            


        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            System.out.println("Erro cript");
            return null;
        }
        
    }
    
     public static byte[] simetricDecript(byte[] txtPuro, byte[] chave) {

        try {

           

            Cipher cifraDES;

            // Cria a cifra 
            cifraDES = Cipher.getInstance("DES/ECB/PKCS5Padding");

            // Inicializa a cifra também para o processo de decriptação
            cifraDES.init(Cipher.DECRYPT_MODE, new SecretKeySpec(chave, 0, chave.length, "DES"));

            // Decriptografa o texto
            byte[] textoDecriptografado = cifraDES.doFinal(txtPuro);
            System.out.println(textoDecriptografado.toString());
            return textoDecriptografado;


        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            System.out.println("Erro drecipt");
            return null;
        }

    }

}
