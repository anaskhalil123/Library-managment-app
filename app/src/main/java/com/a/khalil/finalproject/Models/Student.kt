package com.a.khalil.finalproject.Models

data class Student(
    var Name: String, var password: String, var universityID: Long?,
    var Borrowed_Books: ArrayList<Book>?, var bought_books: ArrayList<Book>?
)
