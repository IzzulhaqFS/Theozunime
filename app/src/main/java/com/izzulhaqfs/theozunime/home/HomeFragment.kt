package com.izzulhaqfs.theozunime.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.izzulhaqfs.theozunime.R
import com.izzulhaqfs.theozunime.core.data.Resource
import com.izzulhaqfs.theozunime.core.ui.AnimeAdapter
import com.izzulhaqfs.theozunime.databinding.FragmentHomeBinding
import com.izzulhaqfs.theozunime.detail.DetailAnimeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val animeListAdapter = AnimeAdapter()
            animeListAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailAnimeActivity::class.java)
                intent.putExtra(DetailAnimeActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            homeViewModel.animes.observe(viewLifecycleOwner) { animes ->
                if (animes != null) {
                    when (animes) {
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            animeListAdapter.submitList(animes.data)
                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.viewError.root.visibility = View.VISIBLE
                            binding.viewError.tvError.text = animes.message ?: getString(R.string.view_error_message)
                        }
                    }
                }
            }

            with(binding.rvAnimeHome) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = animeListAdapter
            }
        }
    }
}