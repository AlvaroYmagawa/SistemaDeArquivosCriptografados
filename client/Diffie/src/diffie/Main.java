/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diffie;

import java.io.IOException;

/**
 *
 * @author ld_si
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Node alice = new Node();
        Node bob = new Node();

        alice.setReceiverPublicKey(bob.getPublickey());

        bob.setReceiverPublicKey(alice.getPublickey());

        String data = "hello";

        String enc = alice.encrypt(data);

        System.out.println("hello is coverted to "+enc);

        System.out.println(enc+" is converted to "+bob.decrypt(enc));

    }
}
