package com.infnet.bookregistrationapplication.model

class Book (
    var nameBook: String,
    var yearRelease: String
    ) {
        override fun toString(): String {
            return "$nameBook , $yearRelease"
        }
}

