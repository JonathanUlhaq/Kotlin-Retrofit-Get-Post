package com.belajar.belajarpostkotlin

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiEndPoint {
    @GET("todos")
    public fun getTodos():Call<TodosModel>

    @FormUrlEncoded
    @POST("todos/add")
    public fun createTodos(@Field("todo") todo:String, @Field("id")id:Int, @Field("completed")completed:Boolean
                           , @Field("userId")userId:Int) : Call<SubmitModel>
}