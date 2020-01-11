package com.reindrairawan.submission2.Fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.reindrairawan.submission2.Adapter.TvAdapter
import com.reindrairawan.submission2.Model.Movie
import com.reindrairawan.submission2.R
import kotlinx.android.synthetic.main.fragment_tv.*

/**
 * A simple [Fragment] subclass.
 */
class TvFragment : Fragment() {
    private val list = ArrayList<Movie>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_tv.setHasFixedSize(true)
        showRecyclerGrid()
        list.addAll(getListHeroes())
    }

    private fun showRecyclerGrid() {
        rv_tv.layoutManager = GridLayoutManager(context, 2)
        val gridMovieAdapter = TvAdapter(list)
        rv_tv.adapter = gridMovieAdapter
    }

    fun getListHeroes(): ArrayList<Movie> {
        val dataJudul = resources.getStringArray(R.array.data_judul)
        val dataDescription = resources.getStringArray(R.array.data_descriptions)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listMovie = ArrayList<Movie>()
        for (position in dataJudul.indices) {
            val movie = Movie(
                dataPhoto.getResourceId(position, -1),
                dataJudul[position],
                dataDescription[position]
            )
            listMovie.add(movie)
        }
        return listMovie
    }

}
