package com.infnet.bookregistrationapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BookViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(BookViewModel::class.java))
            return BookViewModel() as T
        throw IllegalArgumentException("Classe ViewModel deve ser BookViewModel")
    }
}