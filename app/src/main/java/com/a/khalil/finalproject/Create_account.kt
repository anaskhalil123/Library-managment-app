package com.a.khalil.finalproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.a.khalil.finalproject.Models.Book
import com.a.khalil.finalproject.Models.Student
import com.a.khalil.finalproject.Models.StudentDatabase
import kotlinx.android.synthetic.main.activity_create_account.*

class Create_account : AppCompatActivity() {
    lateinit var StudentDatabase: StudentDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        StudentDatabase = StudentDatabase(this)

        btnCreateAccount.setOnClickListener {
            var brrowed_books = ArrayList<Book>()
            var bought_books = ArrayList<Book>()
            val uid = UID.text.toString().toLongOrNull()

            Log.d("anas khalil $uid", savedInstanceState.toString())
            var student = Student(
                edName.text.toString(),
                edPassword.text.toString(),
                uid,
                brrowed_books,
                bought_books
            )

            if (!(uid == null) && !edName.text.toString().isEmpty() && edPassword.text.toString()
                    .equals(edConfirmPassword.text.toString())
            ) {
                if (StudentDatabase.insertStudent(student))
                    Toast.makeText(
                        this,
                        "the account created, you can sign in now",
                        Toast.LENGTH_SHORT
                    ).show()

                startActivity(Intent(this, sign_in::class.java))
            } else if (!edPassword.text.toString().equals(edConfirmPassword.text.toString())) {
                Toast.makeText(this, "Password is not equal", Toast.LENGTH_LONG)
                    .show()
            } else {
                Toast.makeText(this, "complete the required", Toast.LENGTH_LONG)
                    .show()
            }

        }


    }
}