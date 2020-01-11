package com.reindrairawan.submission2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.reindrairawan.submission2.Model.Movie
import kotlinx.android.synthetic.main.activity_detail_movie.*

class DetailMovieActivity : AppCompatActivity() {
    companion object {
        const val FLAG_EXTRA = "flag_extra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val movie = intent.getParcelableExtra(FLAG_EXTRA) as Movie
        val photo = movie.photo
        val description = "${movie.description.toString()}"
        val judul = "${movie.judul.toString()}"


        tvdetaildescription.text = description
        tvdetailjudul.text = judul
        imgdetailposter.setImageResource(photo)

    }

}



