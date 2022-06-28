package com.infnet.bookregistrationapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infnet.bookregistrationapplication.database.AppDatabase
import com.infnet.bookregistrationapplication.model.Book

class BookViewModel : ViewModel(){
    var quantityBook = MutableLiveData<Int>()
    init {
        quantityBook.value = 3
    }

    fun addBook(){
        quantityBook.value = quantityBook.value!!
            .plus(1)
    }

    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>>
        get() = _books

    private val _status = MutableLiveData<Boolean>()
    val status: LiveData<Boolean>
        get() = _status

    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String>
        get() = _msg

    init {
        _status.value = false
        _msg.value = null
        getAll()
    }

    private fun getAll() {
        _msg.value = "Buscando dados..."
        val appDatabase = AppDatabase.getInstance()
        _books.value = appDatabase.all()

        _status.value = true
    }

    fun saveBook(
        nameBook: String,
        yearRelease: String
    ) {
        var book = Book(nameBook, yearRelease)
        AppDatabase.getInstance().store(book)
    }
}