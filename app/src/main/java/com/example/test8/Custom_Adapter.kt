package com.example.test8

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class Custom_Adapter(var context: Context, var listarray: ArrayList<Data_Class> , var userClickListener: Homefragment ): BaseAdapter() {
    override fun getCount(): Int {
       return listarray.size
    }

    override fun getItem(position: Int): Any {
        return listarray[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("MissingInflatedId")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var layout = LayoutInflater.from(context).inflate(R.layout.listitemshow,null,false)
            var deletepicShow = layout.findViewById<ImageView>(R.id.deletePicShow)
            var picShow = layout.findViewById<ImageView>(R.id.picShow)
            var nameShow = layout.findViewById<TextView>(R.id.nameShow)
            var emailShow = layout.findViewById<TextView>(R.id.emailShow)
            var numberShow = layout.findViewById<TextView>(R.id.numberShow)

            deletepicShow.setImageResource(listarray[position].deleteimage)
            picShow.setImageResource(listarray[position].image)
            nameShow.text=listarray[position].name
        emailShow.text=listarray[position].email
        numberShow.text=listarray[position].number

        nameShow.setOnClickListener {
            var intent = Intent(context,Home_Activity::class.java)
            intent.putExtra("dps",listarray[position].deleteimage)
            intent.putExtra("ps",listarray[position].image)
            intent.putExtra("ns",listarray[position].name)
            intent.putExtra("nuns",listarray[position].number)
            intent.putExtra("es",listarray[position].email)

            context.startActivity(intent)




        }



        deletepicShow.setOnClickListener {
            userClickListener.onDeleteImage(listarray[position].deleteimage,position)
        }

    picShow.setOnClickListener {
        userClickListener.onupdateClick(listarray[position].image,position)
    }


        return layout
    }
}