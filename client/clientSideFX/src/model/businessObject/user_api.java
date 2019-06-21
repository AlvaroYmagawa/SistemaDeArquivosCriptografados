/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.businessObject;


import model.valueObject.User;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 *
 * @author artur
 */
public interface user_api {
    
    @POST("/api/session.json")
    Call<User> Signin (@Body User sign);

    //EXEMPLO DE COMO PASSAR HEADER(ONDE SERA INSERIDO O TOKEN)
    @POST("/api/session.json")
    Call<User> GetUserAuthenticated(@HeaderMap Map<String, String> map);
}
