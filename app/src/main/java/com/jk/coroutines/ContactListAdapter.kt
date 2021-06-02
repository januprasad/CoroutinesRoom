package com.jk.coroutines

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


class ContactListAdapter : ListAdapter<Contact, ContactListAdapter.ContactViewHolder>(ContactsComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.name)
    }

    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById(R.id.textViewName)

        fun bind(text: String?) {
            name.text = text
        }

        companion object {
            fun create(parent: ViewGroup): ContactViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.contact_item, parent, false)
                return ContactViewHolder(view)
            }
        }
    }

    class ContactsComparator : DiffUtil.ItemCallback<Contact>() {
        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem.name == newItem.name
        }
    }
}