package model.businessObject;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Cripto {

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

        } catch (IOException | IllegalBlockSizeException | BadPaddingException ex) {

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
