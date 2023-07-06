package com.example.personing.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.personing.R
import com.example.personing.model.Person

class PersonAdapter : ListAdapter<Person, PersonAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPersonBinding.inflate( LayoutInflater.from(parent.context) )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = getItem(position)

        holder.binding.textViewTitle.text = person.title
        holder.binding.textViewUser.text = "${person.user.firstname} ${person.user.lastname}"

        when(person.type.id) {
            1.toLong() -> holder.binding.icon.setImageResource(R.drawable.ic_todo)
            2.toLong() -> holder.binding.icon.setImageResource(R.drawable.ic_bug)
            3.toLong() -> holder.binding.icon.setImageResource(R.drawable.ic_improvement)
            4.toLong() -> holder.binding.icon.setImageResource(R.drawable.ic_feature)
        }

        holder.onClick(person, listener)
    }

    class ViewHolder( val binding: ItemPersonBinding ) : RecyclerView.ViewHolder(binding.root) {

    }

    object DiffCallback : DiffUtil.ItemCallback<Person>() {
        override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
            TODO("Not yet implemented")
        }

    }

}