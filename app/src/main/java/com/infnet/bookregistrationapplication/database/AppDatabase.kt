package com.infnet.bookregistrationapplication.database

import com.infnet.bookregistrationapplication.model.Book

class AppDatabase {
    private val books = mutableListOf(
        Book("kotlin em ação", "2017"),
        Book("Refatoração", "2020"),
        Book("Código limpo", "2009")
    )

    fun all(): MutableList<Book> = books

    fun store(book : Book) {
        books.add(book)
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