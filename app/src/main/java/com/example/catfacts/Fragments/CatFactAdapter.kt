package com.example.catfacts.Fragments

import android.app.ActionBar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.catfacts.databinding.FactViewItemBinding
import com.example.catfacts.model.CatFact

class CatFactAdapter : ListAdapter<CatFact, CatFactAdapter.CatFactViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatFactViewHolder {
        return CatFactViewHolder(FactViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CatFactViewHolder, position: Int) {
        val catFact = getItem(position)
        holder.bind(createOnClickListener(catFact.factText, catFact.updateDate), catFact)
    }

    private fun createOnClickListener(catFactText: String, catFactUpdateDate: String ) : View.OnClickListener {
        return View.OnClickListener {
            val directions = MainScreenFragmentDirections.actionMainScreenFragmentToDetailScreenFragment(catFactText, catFactUpdateDate)
            it.findNavController().navigate(directions)
        }
    }

    class CatFactViewHolder(private val binding: FactViewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(listener: View.OnClickListener, catFact: CatFact) {
            binding.catFactIdTextView.text = catFact.id
            binding.root.setOnClickListener(listener)
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<CatFact>() {
        override fun areItemsTheSame(oldItem: CatFact, newItem: CatFact): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CatFact, newItem: CatFact): Boolean {
            return oldItem.id == newItem.id
        }
    }
}
