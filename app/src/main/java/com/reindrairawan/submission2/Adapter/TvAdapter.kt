package com.reindrairawan.submission2.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.reindrairawan.submission2.DetailMovieActivity
import com.reindrairawan.submission2.Model.Movie
import com.reindrairawan.submission2.R
import kotlinx.android.synthetic.main.item_tv.view.*

class TvAdapter(private val listMovie: ArrayList<Movie>) :
    RecyclerView.Adapter<TvAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_tv, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }

    override fun getItemCount(): Int = listMovie.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(movie.photo)
                    .apply(RequestOptions().override(350, 550))
                    .into(imgtvposter)
                itemView.setOnClickListener {
                    var intent = Intent(context, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.FLAG_EXTRA, movie)
                    ContextCompat.startActivities(context, arrayOf(intent))
                }

            }
        }
    }
}