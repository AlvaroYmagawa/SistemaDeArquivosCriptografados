/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.businessObject;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ld_si
 */
public class Diffie {

    private int p = 997;  //número primo pré definido na aplicação
    private int g = 5; //número inteiro pré definido na aplicação
    private int senhaAliceInt;
    private String senhaAlice = new String(Integer.toString(senhaAliceInt));
    private int senhaBobInt = Convert.stringToInt("bob45178");
    private String senhaBob = new String(Integer.toString(senhaBobInt));
    private BigInteger aliceCorPrivada = new BigInteger(senhaAlice);
    private BigInteger bobCorPrivada = new BigInteger(senhaBob);
   
    /**
     * @param args the command line arguments
     */
    public Diffie(String senha1) {
        this.senhaAliceInt = Convert.stringToInt(senha1);
    }
    
    public void test(){
        try {
            System.out.println("a = " + aliceCorPrivada);
            
            BigDecimal aliceCommon = publicKey();
            
            BigDecimal bobCommon = bobCommon();
            
            BigDecimal alicePrivada = alicePrivada(bobCommon);
            BigDecimal bobPrivada = bobPrivada(aliceCommon);
            
            System.out.println("Alice P: " + alicePrivada.toString());
            System.out.println("Bob P: " + bobPrivada.toString());
            
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            
            
            byte[] encodedhashA = new byte[32];
            encodedhashA = digest.digest(
                    alicePrivada.toString().getBytes(StandardCharsets.UTF_8));
            
            
            byte[] encodedhashB = digest.digest(
                    bobPrivada.toString().getBytes(StandardCharsets.UTF_8));
            
//            byte[] arquivo = new String("Leandro").getBytes();
//            System.out.println("Alice ");
//            AES.test(arquivo, encodedhashA);
//            System.out.println("Bob ");
//            AES.test(arquivo, encodedhashB);
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Diffie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void genKeyA(){
        
    }
    public BigDecimal alicePrivada(BigDecimal bobCommon) {
        BigDecimal bi = BigDecimal.valueOf(bobCommon.doubleValue()).pow(aliceCorPrivada.intValue());
        System.out.println(bobCommon + "^" + aliceCorPrivada + " = " + (bi.doubleValue() % 23));
        return new BigDecimal(bi.remainder(BigDecimal.valueOf(p)).doubleValue());
    }

    public BigDecimal bobPrivada(BigDecimal aliceCommon) {
        BigDecimal bi = BigDecimal.valueOf(aliceCommon.doubleValue()).pow(bobCorPrivada.intValue());
        System.out.println(aliceCommon + "^" + bobCorPrivada + " = " + (bi.doubleValue() % 23));
        return new BigDecimal(bi.remainder(BigDecimal.valueOf(p)).doubleValue());
    }

    public BigDecimal publicKey() {
        BigDecimal G = new BigDecimal(this.g);
        BigDecimal bi = G.pow(aliceCorPrivada.intValue());
        return new BigDecimal(bi.remainder(new BigDecimal(p)).doubleValue());
    }
    
  

    public BigDecimal bobCommon() {
        BigDecimal bi = new BigDecimal(this.g).pow(bobCorPrivada.intValue());
        return new BigDecimal(bi.remainder(new BigDecimal(p)).doubleValue());
    }

}
