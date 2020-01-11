package com.reindrairawan.submission2.Fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.reindrairawan.submission2.Adapter.MovieAdapter
import com.reindrairawan.submission2.Model.Movie
import com.reindrairawan.submission2.R
import kotlinx.android.synthetic.main.fragment_movie.*

/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment() {
    private val list = ArrayList<Movie>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_movie.setHasFixedSize(true)
        list.addAll(getListMovies())
        showRecyclerView()
    }

    private fun getListMovies(): ArrayList<Movie> {
        val dataJudul = resources.getStringArray(R.array.data_judul)
        val dataDescription = resources.getStringArray(R.array.data_descriptions)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listMovie = ArrayList<Movie>()
        for (position in dataJudul.indices) {
            val hero = Movie(
                dataPhoto.getResourceId(position, -1),
                dataJudul[position],
                dataDescription[position]
            )
            listMovie.add(hero)
        }
        return listMovie
    }

    private fun showRecyclerView() {
        rv_movie.layoutManager = GridLayoutManager(context, 2)
        val gridHeroAdapter = MovieAdapter(list)
        rv_movie.adapter = gridHeroAdapter
    }
}

