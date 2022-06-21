package com.example.sample.presentation.ui

import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.sample.R
import com.example.sample.databinding.FragmentMovieListBinding
import com.example.sample.utill.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_movie_list.*
import javax.inject.Inject

@AndroidEntryPoint
class MovieListFragment @Inject constructor(private val movieListAdapter: MovieListAdapter) :
    BaseFragment(R.layout.fragment_movie_list) {

    lateinit var movieListBinding: FragmentMovieListBinding
    private val viewModel: MovieListViewModel by viewModels()


    override fun bind(view: View) {
        super.bind(view)

        customToolbar.setToolbarTitle("Items")
        movieListBinding = FragmentMovieListBinding.bind(view)

        movieListBinding.apply {
            rcvMoviesList.adapter = movieListAdapter
        }
        movieListAdapter.setOnItemClickListener {
            findNavController().navigate(MovieListFragmentDirections.actionMovieListFragmentToMovieDetailFragment(it.title + " " + it.year))
        }
        viewModel.movieList.observe(viewLifecycleOwner, Observer { result ->
            result?.let {
                movieListAdapter.submitList(it.data)

                movieListBinding.apply {
                    progress.isVisible = it is Resource.Loading && it.data.isNullOrEmpty()
                    with(errorMsg) {
                        isVisible = it is Resource.Error && it.data.isNullOrEmpty()
                        text = it.throwable?.localizedMessage
                    }
                }
            }
        })

        setHasOptionsMenu(true)
    }

}