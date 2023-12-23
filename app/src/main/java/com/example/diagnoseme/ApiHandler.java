package com.example.diagnoseme;

import java.util.List;
import java.util.List; import retrofit.Call;
import retrofit.http. Field;
import retrofit.http. FormUrlEncoded; import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

public interface ApiHandler {
    @GET("DiagnoseMe/list.php")
    Call<List<User>> getAllUsers();

    @FormUrlEncoded
    @POST("DiagnoseMe/insert.php")
    Call<User> insertUser(@Field("surname") String surename,
                          @Field("email") String email,
                          @Field("password") String password);


    @FormUrlEncoded
    @POST("DiagnoseMe/update.php")
    Call<User> updatetUser(@Field("id") int id,
                           @Field("surname") String username,
                           @Field("password") String password,
                           @Field("email") String email);


    @FormUrlEncoded
    @POST("DiagnoseMe/delete.php")
    Call <User> deleteUser(@Field("id") int id);

    @FormUrlEncoded
    @POST("DiagnoseMe/updateE.php")
    Call<User> updateUserByEmail(@Field("email") String email,
                                 @Field("surname") String username,
                                 @Field("password") String password);

    @FormUrlEncoded
    @POST("DiagnoseMe/signin.php")
    Call<User> signInUser(@Field("email") String email,
                          @Field("password") String password);

    @FormUrlEncoded
    @POST("DiagnoseMe/delete.php")
    Call<User> deleteUserByEmail(@Field("email") String email);




}
