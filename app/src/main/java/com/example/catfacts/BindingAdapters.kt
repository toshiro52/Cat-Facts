package com.example.catfacts

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.catfacts.Fragments.CatFactAdapter
import com.example.catfacts.model.CatFact
import com.example.catfacts.viewModels.ApiServiceStatus

class BindingAdapters {
    companion object {
        @JvmStatic
        @BindingAdapter("listData")
        fun bindRecyclerView(recyclerView: RecyclerView, data: List<CatFact>?) {
            val adapter = recyclerView.adapter as CatFactAdapter
            adapter.submitList(data)
        }

        @JvmStatic
        @BindingAdapter("ApiStatus")
        fun bindStatus(statusImageView: ImageView, status: ApiServiceStatus?) {
            when (status) {
                ApiServiceStatus.LOADING -> {
                    statusImageView.visibility = View.VISIBLE
                    statusImageView.setImageResource(R.drawable.loading_animation)
                }
                ApiServiceStatus.ERROR -> {
                    statusImageView.visibility = View.VISIBLE
                    statusImageView.setImageResource(R.drawable.ic_connection_error)
                }
                ApiServiceStatus.DONE -> {
                    statusImageView.visibility = View.GONE
                }
                else -> {}
            }
        }
    }
}