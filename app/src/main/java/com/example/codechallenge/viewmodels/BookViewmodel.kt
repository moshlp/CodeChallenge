package com.example.codechallenge.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.codechallenge.model.Book
import com.example.codechallenge.network.BookRepository

class BookViewmodel : ViewModel() {

    private var repository: BookRepository = BookRepository()

    fun getBooks(): LiveData<List<Book>> {
        return repository.getBooks()
    }
}