package com.example.listview

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
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
        private val names = arrayListOf<String>(
            "세종대왕", "흥선대원군", "정조", "이방원", "이순신",
            "세종대왕", "흥선대원군", "정조", "이방원", "이순신",
            "세종대왕", "흥선대원군", "정조", "이방원", "이순신",
            "세종대왕", "흥선대원군", "정조", "이방원", "이순신",
            "세종대왕", "흥선대원군", "정조", "이방원", "이순신",
            "세종대왕", "흥선대원군", "정조", "이방원", "이순신",
            "세종대왕", "흥선대원군", "정조", "이방원", "이순신",
            "세종대왕", "흥선대원군", "정조", "이방원", "이순신",
            "세종대왕", "흥선대원군", "정조", "이방원", "이순신",
            "세종대왕", "흥선대원군", "정조", "이방원", "이순신",
            "세종대왕", "흥선대원군", "정조", "이방원", "이순신"
        )

        override fun getCount(): Int {
            return names.size
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getItem(position: Int): Any {
            return "테스트 스트링"
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {

            val rowMain: View

            if(convertView == null) {
                val layoutInflater = LayoutInflater.from(mContext)
                rowMain = layoutInflater.inflate(R.layout.row_main, viewGroup, false)

                Log.v("getView", "calling findViewById")
                val nameTextView = rowMain.findViewById<TextView>(R.id.name_textView)
                val positionTextView = rowMain.findViewById<TextView>(R.id.name_textView)
                val viewHolder = ViewHolder(nameTextView, positionTextView)

                rowMain.tag = viewHolder

            } else {
                rowMain = convertView
            }

            val viewHolder = rowMain.tag as ViewHolder
            viewHolder.nameTextView.text = names.get(position)
            viewHolder.positionTextView.text = "Row number: $position"

            return rowMain
        }

        private class ViewHolder(val nameTextView: TextView, val positionTextView: TextView)
    }
}

