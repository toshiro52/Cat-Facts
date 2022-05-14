package com.example.catfacts.Fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.catfacts.databinding.MainScreenFragmentBinding
import com.example.catfacts.viewModels.MainScreenViewModel

class MainScreenFragment : Fragment() {

    private var _binding: MainScreenFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainScreenViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainScreenFragmentBinding.inflate(inflater, container, false)
        binding.catFactRecyclerView.adapter = CatFactAdapter()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpButtons()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setUpButtons() {
        binding.refreshButton.setOnClickListener {
            viewModel.getCatFacts()
        }
    }

}