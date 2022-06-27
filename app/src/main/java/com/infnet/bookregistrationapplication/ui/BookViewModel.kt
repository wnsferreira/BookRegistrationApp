package com.infnet.bookregistrationapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infnet.bookregistrationapplication.database.AppDatabase
import com.infnet.bookregistrationapplication.model.Book

class BookViewModel : ViewModel(){
    var quantidadeBook = MutableLiveData<Int>()
    init {
        quantidadeBook.value = 2
    }

    fun addBook(){
        quantidadeBook.value = quantidadeBook.value!!
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

    fun getAll() {
        _msg.value = "Consultando a base de dados."
        val appDatabase = AppDatabase.getInstance()
        _books.value = appDatabase.all()

        if (true) {
            _status.value = true
            _msg.value = "Consulta ralizada com sucesso!"
        }
    }

    fun saveBook(
        nameBook: String,
        yearRelease: String
    ) {
        var book = Book(nameBook, yearRelease)
        AppDatabase.getInstance().store(book)
    }
}