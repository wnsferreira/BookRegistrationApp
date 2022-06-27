package com.infnet.bookregistrationapplication.database

import com.infnet.bookregistrationapplication.model.Book

class AppDatabase {
    private val books = mutableListOf(
        Book("A divina comédia", "1321"),
        Book("Romeu e Julieta", "1595")
    )

    fun all(): MutableList<Book> = books

    fun store(book : Book) {
        books.add(book)
    }

    fun delete(book: Book) {
        books.remove(book)
    }

    companion object {

        private var instance: AppDatabase? = null

        fun getInstance(): AppDatabase {
            if (instance == null)
                instance = AppDatabase()
            return instance as AppDatabase
        }
    }
}