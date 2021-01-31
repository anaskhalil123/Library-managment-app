package com.a.khalil.finalproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Bag : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bag)

        val name = intent.getStringExtra("name")
        val BorrowingPeriod = intent.getStringExtra("BorrowingPeriod")
        val Price = intent.getStringExtra("Price")
    }
}