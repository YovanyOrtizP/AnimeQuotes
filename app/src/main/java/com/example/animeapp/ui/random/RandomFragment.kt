package com.example.animeapp.ui.random

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.animeapp.data.model.AnimeResponse
import com.example.animeapp.utils.UIState
import com.example.animequotes.databinding.FragmentRandomBinding
import com.example.animequotes.ui.ViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RandomFragment : Fragment() {

    private var _binding: FragmentRandomBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRandomBinding.inflate(inflater, container, false)
        viewModel.result.observe(viewLifecycleOwner){
            when(it){
                is UIState.LOADING -> {
                    Toast.makeText(context,"Loading...!", Toast.LENGTH_SHORT).show()
                }
                is UIState.SUCCESS ->{
                    initViews(it.response)
                }
                is UIState.ERROR ->{
                    Toast.makeText(context,it.e,Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(context,"Loading...!",Toast.LENGTH_SHORT).show()
                }
            }
        }

        viewModel.getQuote()

        binding.viewContainer.setOnClickListener{
            viewModel.getQuote()
        }
        return binding.root
    }

    private fun initViews(response: AnimeResponse) {
        response?.let {
            binding.tvAnime.text = it.anime
            binding.tvCharacter.text = it.character
            binding.tvQuote.text = it.quote
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}