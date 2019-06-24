/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataAcessObject;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.businessObject.RetrofitCore;
import model.valueObject.User;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 *
 * @author ld_si
 */
public class UserDAO {

   public static User read(User user){
       try {
           Retrofit retrofit = RetrofitCore.retrofit();
           user_api api = retrofit.create(user_api.class);
           
           Call<User> call = api.Signin(user);
           
           User u = call.execute().body();
           return u;
       } catch (IOException ex) {
           System.out.println("Erro - "+ex.getMessage());
           return null;
       }
   }

}
