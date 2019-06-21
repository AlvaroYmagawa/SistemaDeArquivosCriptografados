/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diffie;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author ld_si
 */
public class Primo {

    public static void main(String[] args) {
        
        while(true){
            BigInteger i = new BigInteger(1000000024,new Random(new RandomValue().getRandomCode()));
            System.out.println(i.intValue());
        }
    }
}
