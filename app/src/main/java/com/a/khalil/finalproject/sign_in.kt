package com.a.khalil.finalproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.a.khalil.finalproject.Models.StudentDatabase
import kotlinx.android.synthetic.main.activity_sign_in.*

/**/
class sign_in : AppCompatActivity() {
    lateinit var StudentDatabase: StudentDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        StudentDatabase = StudentDatabase(this)

        btn_signin.setOnClickListener {
            val uid = edUniversityID_signin.text.toString().toLongOrNull()
            val password = edPassword_signin.text.toString()
            val student = StudentDatabase.getStudentData(uid)
            if (student != null && student.password.equals(password)) {
                Toast.makeText(this, "Signin Sccessful", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, profile::class.java)
                intent.putExtra("UID", uid)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Error Data", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun myMethod(view: View) {
        val create = Intent(this, Create_account::class.java)
        startActivity(create)
    }
}
