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
public class Convert {
    public static int stringToInt(String senha) {
        int valorint = Character.getNumericValue(senha.charAt(0));
        for (int i = 1; i < senha.length(); i++) {
            valorint += Character.getNumericValue(senha.charAt(i));
        }
        System.out.println("Senha em inteiro: "+valorint);
        return valorint;
    }
}
