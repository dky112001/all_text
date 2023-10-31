package com.example.test8

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class Second_Custom_Adapter(var context: Context, var arrarlist : ArrayList<Second_Data_Class> ,var userClickListener: ProfileFragment) : BaseAdapter() {
    override fun getCount(): Int {
       return arrarlist.size
    }

    override fun getItem(position: Int): Any {
       return arrarlist[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("MissingInflatedId")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
       var layout = LayoutInflater.from(context).inflate(R.layout.secondlistitem,null,false)
        var deletepic = layout.findViewById<ImageView>(R.id.deletePic)
        var picShows = layout.findViewById<ImageView>(R.id.picShows)
        var studentnameShows = layout.findViewById<TextView>(R.id.studentNameShows)
        var feesShows = layout.findViewById<TextView>(R.id.feesShows)

        deletepic.setImageResource(arrarlist[position].delete)
        picShows.setImageResource(arrarlist[position].images)
        studentnameShows.text=arrarlist[position].names
        feesShows.text=arrarlist[position].fees

    deletepic.setOnClickListener {
        userClickListener.onDeletefees(arrarlist[position],position)
    }


        picShows.setOnClickListener {
            userClickListener.onuUpdatefees(arrarlist[position].images,position)
        }


return  layout


    }
}