package com.example.wishlist2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView

class ItemAdapter (private val lists: MutableList<Item>): RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val urlTextView: TextView
        val priceTextView: TextView
        val nameTextView: TextView


        init {
            urlTextView  = itemView.findViewById<EditText>(R.id.urlTv)
            priceTextView = itemView.findViewById<EditText>(R.id.priceTv)
            nameTextView = itemView.findViewById<EditText>(R.id.nameTv)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item = parent.context
        val inflater = LayoutInflater.from(item)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.item_whishlist, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = lists.get(position)
        // Set item views based on your views and data model
        holder.urlTextView.text = list.url
        holder.priceTextView.text = list.price.toString()
        holder.nameTextView.text = list.name
    }

    override fun getItemCount(): Int {
        return lists.size
    }


}




