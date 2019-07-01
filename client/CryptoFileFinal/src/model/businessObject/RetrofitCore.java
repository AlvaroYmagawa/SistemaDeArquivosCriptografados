/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.businessObject;


import retrofit2.Retrofit;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author artur
 */
public class RetrofitCore {
    public static final String BASE_URL = "http://serverseguranca.herokuapp.com/";
    private String email;
    private String token;
    
    public static Map<String, String> getHeaders(String email, String token) {
        Map<String, String> headers = new HashMap<>();


        headers.put("X-User-Token", token);
        headers.put("X-User-Email", email);

        return headers;
    }
    
    public static Map<String, String> getHeadersTESTE() {
        Map<String, String> headers = new HashMap<>();


        headers.put("X-User-Token", "dHYzhXa8gHUWCXhEmAeV");
        headers.put("X-User-Email", "email1@hotmail.com");

        return headers;
    }
    
    
    public static Retrofit retrofit() {
        
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        
        


        return retrofit;
    }
    
    
    public static String encodeFileToBase64Binary(File file)
           throws IOException {
 
       byte[] bytes = loadFile(file);
       byte[] encoded = Base64.getEncoder().encode(bytes);
//       byte[] mime =  Base64.getMimeEncoder().encode(bytes);
       
//       String mimeString = new String(mime);
       String encodedString = new String(encoded);
 
       String fString = "data:text/plain;base64,"+encodedString;
       return fString;

    }
    
    public static byte[] loadFile(File file) throws IOException {
       byte[] bytes;
       try (InputStream is = new FileInputStream(file)) {
           long length = file.length();
           if (length > Integer.MAX_VALUE) {
               throw new IOException("File to large " + file.getName());
           }
           bytes = new byte[(int) length];
           int offset = 0;
           int numRead = 0;
           while (offset < bytes.length
                   && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
               offset += numRead;
           }
           if (offset < bytes.length) {
               throw new IOException("Could not completely read file " + file.getName());
           }
       }
       return bytes;
   }
    
 
}
