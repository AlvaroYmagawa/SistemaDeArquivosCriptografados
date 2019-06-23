/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataAcessObject;

import java.util.Map;
import model.valueObject.Archive;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 *
 * @author artur
 */
public interface archive_api {
    
    @POST("/api/archive.json")
    Call<Archive> newArchive(@HeaderMap Map<String, String> map, @Body Archive archive);
    
}
