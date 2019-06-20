/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criptografia.simétrica;

import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 *
 * @author Aluno
 */
public class Teste {

    public static void main(String[] args) {
        
        ChaveSimetrica chave = new ChaveSimetrica();
        CriptSim.simetricCript(
                new File("D:\\MEGA\\git\\"
                        + "SistemaDeArquivosCriptografados\\client\\"
                        + "Cripto\\src\\criptografia\\simétrica\\texto.txt"), 
                chave.getChave(), 
                "D:\\MEGA\\git\\SistemaDeArquivosCriptografados\\"
                        + "client\\Cripto\\src\\criptografia\\"
                        + "simétrica\\textoC.txt");
        CriptSim.simetricDecript(
                new File("D:\\MEGA\\git\\"
                        + "SistemaDeArquivosCriptografados\\client\\"
                        + "Cripto\\src\\criptografia\\simétrica\\"
                        + "textoC.txt"), 
                chave.getChave(), "D:\\MEGA\\git\\"
                        + "SistemaDeArquivosCriptografados\\"
                        + "client\\Cripto\\src\\criptografia\\"
                        + "simétrica\\textoD.txt");

    }
}
