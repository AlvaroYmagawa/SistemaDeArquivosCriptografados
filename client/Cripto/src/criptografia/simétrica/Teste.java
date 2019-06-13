/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criptografia.simétrica;

import java.io.File;
import javax.crypto.SecretKey;

/**
 *
 * @author Aluno
 */
public class Teste {
    public static void main(String[] args) {
        SecretKey key = CriptSim.simetricKey();
        CriptSim.simetricCript(new File("C:\\Users\\ld_si\\Criptografia\\src\\criptografia\\texto.txt"), key, "C:\\Users\\ld_si\\Criptografia\\src\\criptografia\\textoC.txt");
        CriptSim.simetricDecript(new File("C:\\Users\\ld_si\\Criptografia\\src\\criptografia\\textoC.txt"), key, "C:\\Users\\ld_si\\Criptografia\\src\\criptografia\\textoD.txt");
    }
}
