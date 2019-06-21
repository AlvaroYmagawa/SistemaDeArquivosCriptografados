/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.businessObject;


import retrofit2.Retrofit;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author artur
 */
public class RetrofitCore {
    static final String BASE_URL = "http://serverseguranca.herokuapp.com/";
    
    
    public static Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();


        headers.put("X-User-Token", "TOKEN AQUI");
        headers.put("X-User-Email", "EMAIL AQUI");

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
 
}
