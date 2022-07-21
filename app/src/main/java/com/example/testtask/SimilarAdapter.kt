package com.example.testtask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testtask.databinding.SimilarRecyclerViewItemBinding
import com.squareup.picasso.Picasso

class SimilarAdapter(private val data: ArrayList<Image>) :
    RecyclerView.Adapter<SimilarAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = SimilarRecyclerViewItemBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.similar_recycler_view_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = data[position]
        with(holder.binding) {
            Picasso.get().load(image.image).into(imageView)
        }
    }

    override fun getItemCount() = data.size
}