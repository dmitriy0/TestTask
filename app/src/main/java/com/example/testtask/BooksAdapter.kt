package com.example.testtask

import android.graphics.text.LineBreaker
import android.os.Build
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.testtask.databinding.BooksRecyclerViewItemBinding
import com.squareup.picasso.Picasso

class BooksAdapter(private val data: ArrayList<Book>) :
    RecyclerView.Adapter<BooksAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = BooksRecyclerViewItemBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.books_recycler_view_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = data[position]
        with(holder.binding) {
            title.text = book.title
            author.text = book.author
            price.text = "${book.price.toString()} €"
            ratingScore.text = book.rate.score.toString()
            ratingAmount.text = "(${book.rate.amount.toString()})"
            Picasso.get().load(book.image).into(image)
            card.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("title", book.title)
                bundle.putString("author", book.author)
                bundle.putString("price", book.price.toString())
                bundle.putString("ratingScore", book.rate.score.toString())
                bundle.putString("ratingAmount", book.rate.amount.toString())
                bundle.putString("image", book.image)
                App.INSTANCE.router.navigateTo(Screens.bookInfo(bundle))
            }
        }
    }

    override fun getItemCount() = data.size
}