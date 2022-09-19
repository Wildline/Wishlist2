package com.example.wishlist2

import android.content.Context
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Collections.list


class MainActivity : AppCompatActivity() {
    private val nLists = mutableListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val priceView = findViewById<TextView>(R.id.priceTv)
        //val urlView = findViewById<TextView>(R.id.urlTv)
        //val nameView = findViewById<TextView>(R.id.nameTv)

        val button = findViewById<Button>(R.id.button)
        val listRV = findViewById<RecyclerView>(R.id.listRv)
        val priceInput = findViewById<EditText>(R.id.W_price)
        val nameInput = findViewById<EditText>(R.id.W_Name)
        val urlInput = findViewById<EditText>(R.id.W_URL)

        val adapter = ItemAdapter(nLists)
        listRV.adapter = adapter
        listRV.layoutManager = LinearLayoutManager(this)
        adapter.notifyDataSetChanged()


        button.setOnClickListener {
            //val wishlist = listOf(nameInput.text.toString(),priceInput.text.toString().toDouble(),urlInput.text.toString())
            var wishlist: Item = Item(nameInput.text.toString(),priceInput.text.toString().toDouble(),urlInput.text.toString())
            nLists.add(wishlist)
            it.hideKeyboard()
            nameInput.text.clear()
            priceInput.text.clear()
            urlInput.text.clear()

            adapter.notifyItemInserted(nLists.size - 1)
            listRV.scrollToPosition(nLists.size -1)
        }
    }




}




fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}
