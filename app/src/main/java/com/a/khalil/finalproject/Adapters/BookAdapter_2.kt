package com.a.khalil.finalproject.Adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.a.khalil.finalproject.Models.Book
import com.a.khalil.finalproject.R
import kotlinx.android.synthetic.main.book_item.view.*

class BookAdapter_2(
    var activity: Activity,
    var data: ArrayList<Book>
) : RecyclerView.Adapter<BookAdapter_2.myHolder>() {

    class myHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.edName
        val tvAuthor = itemView.tvAuthor
        val tvType = itemView.tvType
        val price = itemView.tvPrice
        val brrowingperiod = itemView.tvBorrowingPeriod
        val image = itemView.imgBook
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myHolder {
        val root = LayoutInflater.from(this.activity).inflate(R.layout.book_item, parent, false)
        return myHolder(root)
    }

    override fun onBindViewHolder(holder: myHolder, position: Int) {
        holder.name.text = data[position].bookName
        holder.tvType.text = data[position].bookType
        holder.tvAuthor.text = data[position].bookAuthor
        holder.price.text = data[position].priceInDolars
        holder.brrowingperiod.text = data[position].BookBorrowingTime
        holder.image.setImageResource(data[position].image)
    }

    override fun getItemCount(): Int {
        return data.size
    }

}

//     TODO here you should write the programming code of the Button in each book.
//      popup.setOnMenuItemClickListener { it ->
//                when (it.itemId) {
//                    R.id.Shopitem -> {
//                        i.putExtra("name", data.get(p0).get(p1).bookName)
//                        i.putExtra("BorrowingPeriod", data.get(p0).get(p1).BookBorrowingTime)
//                        i.putExtra("Price", data.get(p0).get(p1).priceInDolars)
//                    }
//                    R.id.Brrowitem -> {
//                        i.putExtra("name", data.get(p0).get(p1).bookName)
//                        i.putExtra("BorrowingPeriod", data.get(p0).get(p1).BookBorrowingTime)
//                        i.putExtra("Price", data.get(p0).get(p1).priceInDolars)
//                    }
//                }
//                true
//            }
//            popup.show()
/*val tv_title = root!!.findViewById<TextView>(R.id.tv_title)
    tv_title.setText(title)
    return root*/

