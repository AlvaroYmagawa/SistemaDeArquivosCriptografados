package model.businessObject;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class Hash {

    public static String gen(String senha) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
            
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }
            String senhahex = hexString.toString();
            
            System.out.println(senhahex);
            return senhahex;
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            System.out.println("Hash:gen - Erro: "+ex.getMessage());
            return null;
        }
    }

}
