package com.example.codechallenge

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.codechallenge.adapters.RecyclerAdapter
import com.example.codechallenge.viewmodels.BookViewmodel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mRecyclerView : RecyclerView
    val mAdapter : RecyclerAdapter = RecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar.visibility = View.VISIBLE

        val viewmodel =  ViewModelProviders.of(this).get(BookViewmodel::class.java)

        viewmodel.getBooks().observe(this, Observer { books ->
            if (books.isNotEmpty()){
                mAdapter.RecyclerAdapter(books, this)
                mRecyclerView.adapter = mAdapter
                mAdapter.notifyDataSetChanged()
            }
            progressBar.visibility = View.GONE
        })

        setUpRecyclerView()
    }

    fun setUpRecyclerView(){
        mRecyclerView = findViewById(R.id.rv_books) as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.adapter = mAdapter
    }
}
