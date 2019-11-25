package com.example.codechallenge.network

import com.example.codechallenge.model.Book
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface BookApiService {

    companion object {
        fun create(): BookApiService {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(
                    GsonConverterFactory.create())
                .baseUrl("http://de-coding-test.s3.amazonaws.com/")
                .build()

            return retrofit.create(BookApiService::class.java)
        }
    }

    @GET("books.json")
    fun getBooks() : Call<List<Book>>
}