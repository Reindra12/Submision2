package com.reindrairawan.submission2.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivities
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.reindrairawan.submission2.DetailMovieActivity
import com.reindrairawan.submission2.Model.Movie
import com.reindrairawan.submission2.R
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter(private val listMovie: ArrayList<Movie>) :
    RecyclerView.Adapter<MovieAdapter.ListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(movie.photo)
                    .apply(RequestOptions().override(350, 550))
                    .into(imgposter)

                tvjudul.text = movie.judul
                tvdescription.text = movie.description
                btndescription.setOnClickListener {
                    var intent = Intent(context, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.FLAG_EXTRA, movie)
                    startActivities(context, arrayOf(intent))
                }
            }
        }
    }
}