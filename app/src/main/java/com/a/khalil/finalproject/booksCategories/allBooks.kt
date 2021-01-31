package com.a.khalil.finalproject.booksCategories

// import com.a.khalil.finalproject.Adapters.ExpandableListAdapter
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.a.khalil.finalproject.Adapters.BookAdapter_2
import com.a.khalil.finalproject.Models.Book
import com.a.khalil.finalproject.R
import kotlinx.android.synthetic.main.activity_recyclerview.*
import java.util.*
import kotlin.collections.ArrayList


class allBooks : AppCompatActivity() {//TODO im stop here !!!!

    val display = ArrayList<Book>()
    val data = ArrayList<Book>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        data.add(
            Book(
                1,
                "Name: ISLAM Its Foundation And Concepts",
                "BookType:Islamic Books",
                "Author/s: muhammad as-suhaym",
                "Price: 15$",
                "BorrowingPeriod: 10 days",
                R.drawable.book_6
            )
        )

        data.add(
            Book(
                2,
                "Name: zaad almaad",
                "BookType:Islamic Books",
                "Author/s: Ibn Qayyim",
                "Price: 350$",
                "BorrowingPeriod: 60 days",
                R.drawable.book_7
            )
        )

        data.add(
            Book(
                3,
                "Name: Tafsir al-Tabari",
                "BookType:Islamic Books",
                "Author/s: Muhammad ibn Jarir",
                "Price: 450$",
                "BorrowingPeriod: 80 days",
                R.drawable.book_8
            )
        )

        data.add(
            Book(
                4,
                "Name: Tafsir Ibn Kathir",
                "BookType:Islamic Books",
                "Author/s: Ibn Kathir",
                "Price: 400$",
                "BorrowingPeriod: 75 days",
                R.drawable.book_9
            )
        )

        data.add(
            Book(
                5,
                "Name: Simple Summary of the Pillars Islam and Eemaan",
                "BookType:Islamic Books",
                "Author/s: Yoosuf ibn Abdullaah",
                "Price: 30$",
                "BorrowingPeriod: 12 days",
                R.drawable.book_10
            )
        )


        data.add(
            Book(
                1,
                "Name: dare to lead",
                "BookType:Management Books",
                "Author/s: Maher Abdel Rahman",
                "Price: 40$",
                "BorrowingPeriod: 25 days",
                R.drawable.book_11
            )
        )

        data.add(
            Book(
                2,
                "Name: Fundamentals of Financial Management",
                "BookType:Management Books",
                "Author/s: Jamil Ahmed Tawfiq",
                "Price: 35$",
                "BorrowingPeriod: 27 days",
                R.drawable.book_12
            )
        )

        data.add(
            Book(
                3,
                "Name: Human Resource Management",
                "BookType:Management Books",
                "Author/s: Tim weighs",
                "Price: 25$",
                "BorrowingPeriod: 15 days",
                R.drawable.book_13
            )
        )

        data.add(
            Book(
                4,
                "Name: time management",
                "BookType:Management Books",
                "Author/s: Khaled Al-Jeraisy",
                "Price: 15$",
                "BorrowingPeriod: 10 days",
                R.drawable.book_14
            )
        )

        data.add(
            Book(
                5,
                "Name: Modern educational administration and education",
                "BookType:Management Books",
                "Author/s: Asia Issa",
                "Price: 45$",
                "BorrowingPeriod: 30 days",
                R.drawable.book_15
            )
        )


        data.add(
            Book(
                1,
                "Name: JavaNetbeans",
                "BookType:Programming Books",
                "Author/s: Maher Abdel Rahman",
                "Price: 40$",
                "BorrowingPeriod: 25 days",
                R.drawable.book_1
            )
        )

        data.add(
            Book(
                2,
                "Name: MYSQL With Java",
                "BookType:Programming Books",
                "Author/s: souhail developer",
                "Price: 22$",
                "BorrowingPeriod: 25 days",
                R.drawable.book_2
            )
        )

        data.add(
            Book(
                3,
                "Name: The Certainty In C Programming",
                "BookType:Programming Books",
                "Author/s: Rachid Namane",
                "Price: 30$",
                "BorrowingPeriod: 25 day",
                R.drawable.book_3
            )
        )

        data.add(
            Book(
                4,
                "Name: Effective Java",
                "BookType:Programming Books",
                "Author/s: Joshua Bloch",
                "Price: 45.5$",
                "BorrowingPeriod: month",
                R.drawable.book_4
            )
        )

        data.add(
            Book(
                5,
                "Name: kotlin for android app development",
                "BookType:Programming Books",
                "Author/s: Peter Somerhoff",
                "Price: 42.5$",
                "BorrowingPeriod: month",
                R.drawable.book_5
            )
        )

        display.addAll(data)

        val bookAdapter = BookAdapter_2(this, display)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = bookAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.firstmenu, menu)
        val menuItem = menu!!.findItem(R.id.nav_serach)
        if (menuItem != null) {
            val searchView = menuItem.actionView as SearchView

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextChange(p0: String?): Boolean {

                    if (p0!!.isNotEmpty()) {
                        display.clear()
                        val search = p0.toLowerCase(Locale.getDefault())

                        data.forEach {
                            if (it.bookName.toLowerCase(Locale.getDefault()).contains(search)) {
                                display.add(it)
                            }

                        }
                        recyclerView.adapter!!.notifyDataSetChanged()
                    }else{
                        display.clear()
                        display.addAll(data)
                        recyclerView.adapter!!.notifyDataSetChanged()
                    }
                    return true
                }

                override fun onQueryTextSubmit(p0: String?): Boolean {
                    return true
                }
            })
        }

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

}