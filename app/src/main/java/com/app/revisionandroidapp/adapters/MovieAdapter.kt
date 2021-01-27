package com.app.revisionandroidapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.Coil
import coil.load
import com.app.revisionandroidapp.R
import com.app.revisionandroidapp.datas.models.MovieModel

class MovieAdapter(var list: List<MovieModel> = listOf()): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)

        return ViewHolder(row)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(this.list[position])
    }

    override fun getItemCount(): Int {
        return this.list.size
    }

    inner class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun bind(item: MovieModel) {
            val title = view.findViewById<TextView>(R.id.movie_title)
            val coverImage = view.findViewById<ImageView>(R.id.imageView)
            title.text = item.title
            coverImage.load("https://www.themoviedb.org/t/p/w440_and_h660_face/${item.poster_path}")
        }
    }
}