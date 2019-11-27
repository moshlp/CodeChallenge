package com.example.codechallenge.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.codechallenge.model.Book
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookRepository {

    fun getBooks(): LiveData<List<Book>> {
        val data = MutableLiveData<List<Book>>()
        val service = BookApiService.create()
        service.getBooks().enqueue(object : Callback<List<Book>> {
            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                data.value = ArrayList()
                if (response.isSuccessful) {
                    data.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                data.value = ArrayList()
            }
        })
        return data
    }

}