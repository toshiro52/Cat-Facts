package com.example.catfacts.Fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.catfacts.databinding.DetailScreenFragmentBinding

class DetailScreenFragment : Fragment() {

    private var _binding: DetailScreenFragmentBinding?= null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DetailScreenFragmentBinding.inflate(inflater, container, false)


        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}