package com.a.khalil.finalproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.a.khalil.finalproject.Models.StudentDatabase
import com.a.khalil.finalproject.booksCategories.allBooks
import kotlinx.android.synthetic.main.activity_user_profile.*

/**/
class profile : AppCompatActivity() {
    lateinit var StudentDatabase: StudentDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        StudentDatabase = StudentDatabase(this)
/*
* TODO read this
*  here i should not to  forget to if the getStudentData(1) get all the students that made, or get just one student.
*/

        val studentid = intent.getLongExtra("UID", 0)

        val student = StudentDatabase.getStudentData(studentid)


        if (student != null) {
            profileName.setText(student.Name)
            profileUID.setText(student.universityID.toString())
            profilePassword.setText(student.password)
        }


        imageView6.setOnClickListener {
            val i = Intent(this, allBooks::class.java)
            startActivity(i)
        }


    }
}