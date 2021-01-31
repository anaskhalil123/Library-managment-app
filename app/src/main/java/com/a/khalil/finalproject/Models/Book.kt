package com.a.khalil.finalproject.Models

import android.media.Image
import android.service.autofill.OnClickAction

data class Book(var id: Int//رقم الكتاب لن نحتاجها، ولكن عشان نعمل الadapter
                , var bookName: String
                , var bookType:String
                , var bookAuthor: String/*  اسم مؤلف الكتاب*/
                , var priceInDolars: String/*  سعر  شراء الكتاب بالدولار */
                , var BookBorrowingTime: String /*المدة التي يتاح للطالب أن يستعير فيها الكتاب */
                , var image: Int /*صورة لغلاف الكتاب*/
)