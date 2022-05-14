package com.example.catfacts.Fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.catfacts.databinding.DetailScreenFragmentBinding

class DetailScreenFragment : Fragment() {

    private var _binding: DetailScreenFragmentBinding?= null
    private val binding get() = _binding!!
    private lateinit var catFactText: String
    private lateinit var catFactUpdateDate: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DetailScreenFragmentBinding.inflate(inflater, container, false)

        binding.factText.text = catFactText
        binding.factUpdateText.text = catFactUpdateDate

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val args: DetailScreenFragmentArgs by navArgs()
        catFactText = args.catFactText
        catFactUpdateDate = args.catFactUpdateDate
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}