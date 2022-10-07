package com.example.countermvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.countermvvm.databinding.ItemListBinding
import com.example.countermvvm.model.Person

class ListAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val list = mutableListOf<Person>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(person: Person) {
            binding.textViewName.text = person.name
            binding.textViewAge.text = person.age.toString()
        }
    }

    fun setItems(people: List<Person>) {
        list.clear()
        list.addAll(people)
        notifyDataSetChanged()
    }
}