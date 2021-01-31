package com.a.khalil.finalproject.Models

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class StudentDatabase(context: Context) :
    SQLiteOpenHelper(context, "studentdatabase", null, DataBaseVersion) {

    override fun onCreate(p0: SQLiteDatabase?) {
        val command = "CREATE TABLE student (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Name TEXT not null," +
                "password TEXT not null," +
                "universityID Long not null );"
        if (p0 != null) {
            p0.execSQL(command)
        }
    }

    fun getStudentData(): ArrayList<Student> {
        var database = this.readableDatabase

        var cursor = database.rawQuery("select * from student", null)

        val students = ArrayList<Student>()

        while (cursor.moveToNext()) {
            var Studentname = cursor.getString(0)
            var Studentpassword = cursor.getString(1)
            var Studentid = cursor.getLong(0)

            students.add(
                Student(
                    Studentname, Studentpassword, Studentid,
                    null, null
                )
            )
        }
        cursor.close()

        return students
    }

    /**/
    fun getStudentData(uid: Long?): Student? {
        if (uid == null) {
            return null
        } else {
            val database = this.readableDatabase

            val cursor = database.rawQuery("select * from student", null)
            var student = Student("", "", 12, null, null)

            while (cursor.moveToNext()) {
                val Studentid = cursor.getLong(cursor.getColumnIndex("universityID"))
                if (uid.equals(Studentid)) {
                    student = Student(
                        cursor.getString(cursor.getColumnIndex("Name")),
                        cursor.getString(cursor.getColumnIndex("password")),
                        Studentid,
                        null, null
                    )
                }

            }
            //  if (cursor != null) {
            cursor.close()
            //
            return student
        }
    }
/**/

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        val command = "DROP TABLE IF EXISTS Student"
        p0?.execSQL(command)
        onCreate(p0)
    }

    fun insertStudent(student: Student): Boolean {
        //   countId++
        var database = this.writableDatabase
        var contentValues = ContentValues()
        contentValues.put("Name", student.Name)
        contentValues.put("password", student.password)
        contentValues.put("universityID", student.universityID)
        /**/return database.insert("Student", null, contentValues) > 0
    }

    //    /**/ fun getLastId(): Long {
//        var lastId = countId
//        return lastId
//    }
    companion object {
        const val DataBaseVersion = 1
    }

}