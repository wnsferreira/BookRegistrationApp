package com.infnet.bookregistrationapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infnet.bookregistrationapplication.model.Book

class FullViewModel : ViewModel() {

    private val _book = MutableLiveData<Book>()

    val book: LiveData<Book>
        get() = _book

    fun selectBook(book: Book){
        _book.value = book
    }
}
