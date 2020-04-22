package com.example.listview

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.main_listview)
//        val redColor = Color.parseColor("#FF0000")
//        listView.setBackgroundColor(redColor)

        listView.adapter = MyCustomAdapter(this)
    }

    private class MyCustomAdapter(context: Context): BaseAdapter() {

        private val mContext: Context = context

        override fun getCount(): Int {
            return 5
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getItem(position: Int): Any {
            return "테스트 스트링"
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val textView = TextView(mContext)
            textView.text = "my LISTVIEW ROW"

            return textView
        }
    }
}

