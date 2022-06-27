package com.infnet.bookregistrationapplication.model

import android.util.Log

class Book (
    var nameBook: String,
    var yearRelease: String
    ) {
        override fun toString(): String {
            return "$nameBook , $yearRelease"
        }

        fun store() {
            Log.i("Livro",
                "$nameBook registrado com sucesso")

        }
}

