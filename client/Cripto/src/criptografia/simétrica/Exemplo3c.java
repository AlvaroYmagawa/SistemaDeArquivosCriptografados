/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criptografia.simétrica;

/**
 *
 * @author ld_si
 */
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.ASCIIUtility;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.crypto.SecretKey;

public class Exemplo3c {

    public static void main(String[] args) throws IOException {

        
        FileOutputStream arqOutC = new FileOutputStream("C:\\Users\\Aluno\\Desktop\\testeC.txt");
        FileOutputStream arqOutD = new FileOutputStream("C:\\Users\\Aluno\\Desktop\\testeD.txt");
        DataOutputStream gravarArqC = new DataOutputStream(arqOutC);
        DataOutputStream gravarArqD = new DataOutputStream(arqOutD);
        File file = new File("C:\\Users\\Aluno\\Desktop\\teste.txt");
        File cfile = new File("C:\\Users\\Aluno\\Desktop\\testeC.txt");
        SecretKey key = Criptografia.simetricKey();

        gravarArqC.write(Criptografia.simetricCript(getBytes(file), key));

        gravarArqD.write(Criptografia.simetricDecript(getBytes(cfile), key));


    }

    public static byte[] getBytes(File file) {
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
}
