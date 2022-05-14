package com.example.catfacts

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.catfacts.Fragments.CatFactAdapter
import com.example.catfacts.model.CatFact

class BindingAdapters {
    companion object {
        @JvmStatic
        @BindingAdapter("listData")
        fun bindRecyclerView(recyclerView: RecyclerView, data: List<CatFact>?) {
            val adapter = recyclerView.adapter as CatFactAdapter
            adapter.submitList(data)
        }
    }
}