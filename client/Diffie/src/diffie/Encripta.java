/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diffie;

/**
 *
 * @author ld_si
 */
import javax.crypto.*;
import javax.crypto.spec.*;

public class Encripta {
    public static void test(byte[] mensagem, byte[] chave) {
    try {
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");


      // Usando chave de 128-bits (16 bytes)

      System.out.println("Tamanho da chave: " + chave.length);

      // Encriptando...
      cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(chave, "AES"));
      byte[] encrypted = cipher.doFinal(mensagem);
        System.out.println("Original: "+new String(mensagem));
      // Decriptando...
      cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(chave, "AES"));
      byte[] decrypted = cipher.doFinal(encrypted);

      System.out.println("Crifrado: "+new String(encrypted));
      System.out.println("Decifrado: "+new String(decrypted));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}