package com.example.codechallenge.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.codechallenge.R
import com.example.codechallenge.model.Book
import com.squareup.picasso.Picasso

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var books: List<Book> = ArrayList()
    lateinit var context: Context

    fun RecyclerAdapter(books : List<Book>, context: Context){
        this.books = books
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.book_item, parent, false))
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val item = books.get(position)
        holder.bind(item, context)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById(R.id.tv_title) as TextView
        val author = view.findViewById(R.id.tv_author) as TextView
        val image = view.findViewById(R.id.ivCover) as ImageView

        fun bind(book: Book, context: Context) {
            title.text = book.title
            author.text = book.author
            if (!book.imageURL.isEmpty()) {
                image.loadUrl(book.imageURL)
            }
        }

        fun ImageView.loadUrl(url: String) {
            Picasso.with(context).load(url).into(this)
        }
    }


}