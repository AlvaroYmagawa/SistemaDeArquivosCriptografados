/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criptografia.simétrica;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 *
 * @author Aluno
 */
public class CriptSim {
   public static SecretKey simetricKey(){
        try {
            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            SecretKey chaveDES = keygenerator.generateKey();
            return chaveDES;
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("key error"+ex.getMessage());
            return null;
        }
    }
   
    private static byte[] getBytes(File file) {
        int len = (int) file.length();
        byte[] sendBuf = new byte[len];
        FileInputStream inFile = null;
        try {
            inFile = new FileInputStream(file);
            inFile.read(sendBuf, 0, len);

        } catch (FileNotFoundException fnfex) {

        } catch (IOException ioex) {

        }
        return sendBuf;
    }
    public static void simetricCript(File file, SecretKey chaveDES, String dest) {

        try {

           

            Cipher cifraDES;

            // Cria a cifra 
            cifraDES = Cipher.getInstance("DES/ECB/PKCS5Padding");

            // Inicializa a cifra para o processo de encriptação
            cifraDES.init(Cipher.ENCRYPT_MODE, chaveDES);

          

            byte[] byteFile = getBytes(file);
            // Texto encriptado
            byte[] resultFile = cifraDES.doFinal(byteFile);
   

            FileOutputStream arqOutC = new FileOutputStream(dest);
            DataOutputStream gravarArqC = new DataOutputStream(arqOutC);
            gravarArqC.write(resultFile);
            
            arqOutC.close();
            gravarArqC.close();

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
            System.out.println("Erro cript");

        } catch (FileNotFoundException ex) {
           Logger.getLogger(CriptSim.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException | IllegalBlockSizeException | BadPaddingException ex) {
           Logger.getLogger(CriptSim.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }
    
     public static void simetricDecript(File file, SecretKey chaveDES, String dest) {

        try {

           

            Cipher cifraDES;

         
            cifraDES = Cipher.getInstance("DES/ECB/PKCS5Padding");

            // Inicializa a cifra também para o processo de decriptação
            cifraDES.init(Cipher.DECRYPT_MODE, chaveDES);
            
            byte[] byteFile = getBytes(file);
            // Decriptografa o texto
            byte[] resultFile = cifraDES.doFinal(byteFile);
            
            FileOutputStream arqOutD = new FileOutputStream(dest);
            DataOutputStream gravarArqD = new DataOutputStream(arqOutD);
            gravarArqD.write(resultFile);
            
            arqOutD.close();
            gravarArqD.close();
            

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            System.out.println("Erro drecipt");

        } catch (FileNotFoundException ex) {
          
       } catch (IOException ex) {
           
       }

    }  
}
