package com.ntg.movieappexample.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ntg.movieappexample.R
import com.ntg.movieappexample.model.MovieModel
import com.ntg.movieappexample.presentation.details.MovieDetailsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun drawDetailsFragment( model: MovieModel){
        val fragment= MovieDetailsFragment()
        val bundle=Bundle()
        bundle.putParcelable("movia",model)
        fragment.setArguments(bundle)
        supportFragmentManager.beginTransaction().replace(R.id.frame,fragment,"movie details").commit()
    }
}
