package com.a.khalil.finalproject.Adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.PopupMenu
import com.a.khalil.finalproject.Bag
import com.a.khalil.finalproject.Models.Book
import com.a.khalil.finalproject.R
import kotlinx.android.synthetic.main.book_item.view.*

class BookAdapter(val activity: Activity, val data: ArrayList<Book>) : BaseAdapter() {
    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(p0: Int): Any {
        return data[p0]
    }

    override fun getItemId(p0: Int): Long {
        return data[p0].id.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var root = p1
        if (root == null) {
            root = LayoutInflater.from(activity).inflate(R.layout.book_item, null, false)
        }
        root!!.edName.text = data[p0].bookName
        root!!.tvType.text = data[p0].bookType
        root.tvAuthor.text = data[p0].bookAuthor
        root.tvBorrowingPeriod.text = data[p0].BookBorrowingTime
        root.tvPrice.text = data[p0].priceInDolars
        root.imgBook.setImageResource(data[p0].image)

        root.button_choose.setOnClickListener {
            val i = Intent(activity, Bag::class.java)

//            val popup = PopupMenu(activity, root.button_choose)
//            popup.menuInflater.inflate(R.menu.firstmenu, popup.menu)

//     TODO here you should write the programming code of the Button in each book.
//      popup.setOnMenuItemClickListener { it ->
//
//            }
        }
        return root
    }

}