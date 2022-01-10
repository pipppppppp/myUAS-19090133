package com.example.uas19090133.api

import com.example.uas19090133.model.CreateRPost
import com.example.uas19090133.model.RComment
import com.example.uas19090133.model.RPost
import retrofit2.Call
import retrofit2.http.*

interface Api {
    //    @GET("posts")
//    fun getPost(): Call<ArrayList<PostResponse>>

    //manipulas url dengan query
    //manipulasi query bisa menggunakan kebih dari 1 query, tergantung api yg dituju
    @GET("posts")
    fun getPost(
        @Query("userId") userId: Int,
        @Query("id") id: Int): Call<ArrayList<RPost>>

    //manipulasi id
    @GET("posts/{id}/comments")
    fun  getComments(@Path("id") postId: Int): Call<ArrayList<RComment>>

    @FormUrlEncoded
    @POST("posts")
    fun createPost(
        @Field("userId") userId: Int,
        @Field("title") title: String,
        @Field("body") text: String
    ): Call<CreateRPost>
    // UPDATE
    @FormUrlEncoded
    @PUT("posts/{id}")
    fun putPosts(
        @Path("id") id: Int, //-> untuk url
        @Field("userId") userId: Int,
        @Field("id") idField: Int, //-> untuk update
        @Field("title") title: String?,
        @Field("body") text: String?
    ): Call<RPost>

    @FormUrlEncoded
    @PATCH("posts/{id}")
    fun patchPosts(
        @Path("id") id: Int, //-> untuk url
        @Field("userId") userId: Int,
        @Field("id") idField: Int, //-> untuk update
        @Field("title") title: String?,
        @Field("body") text: String?
    ): Call<RPost>

    //DELETE
    @DELETE("posts/{no}") //value didalam {} harus sama dengan bawahnya
    fun deletePosts(@Path("no") id: Int): Call<Void>

}