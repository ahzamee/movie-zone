package com.moviezone.view.moviedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.moviezone.databinding.FragmentMovieDetailsBinding
import com.moviezone.util.Status.*
import com.moviezone.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment : Fragment() {

    lateinit var binding: FragmentMovieDetailsBinding
    val viewModel: MovieViewModel by viewModels()
    val args: MovieDetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.backPress.setOnClickListener {
            findNavController().popBackStack()
        }

        viewModel.getMovieDetails(args?.imdbId!!)

        viewModel.movieDetails.observe(viewLifecycleOwner) {

            when (it.getContentIfNotHandled()?.status) {

                LOADING -> {

                    binding.detailsProgress.visibility = View.VISIBLE

                }
                ERROR -> {
                    binding.detailsProgress.visibility = View.GONE
                }
                SUCCESS -> {
                    binding.detailsProgress.visibility = View.GONE

                    binding.movieDetails = it.peekContent().data

                }
                null -> TODO()
            }
        }
    }
}