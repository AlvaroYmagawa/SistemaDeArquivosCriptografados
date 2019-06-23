/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataAcessObject;

import java.util.Map;
import model.valueObject.Archive;
import model.valueObject.Sharing;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 *
 * @author ld_si
 */
public interface sharing_api {
    @POST("/api/sharing.json")
    Call<Sharing> newSharing(@HeaderMap Map<String, String> map, @Body Sharing sharing);
}
