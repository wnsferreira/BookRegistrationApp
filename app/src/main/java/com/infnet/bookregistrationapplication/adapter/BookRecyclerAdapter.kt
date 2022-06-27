package com.infnet.bookregistrationapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.infnet.bookregistrationapplication.R
import com.infnet.bookregistrationapplication.model.Book
import kotlinx.android.synthetic.main.list_book_recycler.view.*

class BookRecyclerAdapter (
    private val books : List<Book>,
    private val actionClick : (Book) -> Unit
    )
    : RecyclerView.Adapter<BookRecyclerAdapter.BookViewHolder>() {

        class BookViewHolder(view: View)
            : RecyclerView.ViewHolder(view) {
            val textViewNome = view.textViewRecyclerBookName
            val textViewLancamento = view.textViewRecyclerBookRelease
            val btnShow = view.btnRecyclerBookShow
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
            val view = LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.list_book_recycler,
                    parent,
                    false
                )

            val bookViewHolder = BookViewHolder(view)
            return bookViewHolder
        }

        override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
            val book = books.get(position)
            holder.textViewLancamento.text = book.yearRelease
            holder.textViewNome.text = book.nameBook
            holder.btnShow.setOnClickListener {
                actionClick(book)
            }
        }

        override fun getItemCount(): Int = books.size
}