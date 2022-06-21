package com.example.sample.presentation.ui


import android.view.View
import androidx.navigation.fragment.navArgs
import com.example.sample.R

class MovieDetailFragment : BaseFragment(R.layout.fragment_movie_detail) {

    private val args : MovieDetailFragmentArgs by navArgs()

    override fun bind(view: View) {
        super.bind(view)

        val title = args.title

        customToolbar.setToolbarTitle(title)


    }

}