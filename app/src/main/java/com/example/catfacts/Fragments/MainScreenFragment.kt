package com.example.catfacts.Fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.catfacts.databinding.MainScreenFragmentBinding
import com.example.catfacts.viewModels.ApiServiceStatus
import com.example.catfacts.viewModels.MainScreenViewModel
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MainScreenFragment : Fragment() {

    private var _binding: MainScreenFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel by sharedViewModel <MainScreenViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainScreenFragmentBinding.inflate(inflater, container, false)
        binding.catFactRecyclerView.adapter = CatFactAdapter()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.status.observe(viewLifecycleOwner) {
            if (it == ApiServiceStatus.ERROR) Snackbar.make(
                requireView(),
                "Cannot connect to CatFacts",
                Snackbar.LENGTH_LONG
            ).show()
        }


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