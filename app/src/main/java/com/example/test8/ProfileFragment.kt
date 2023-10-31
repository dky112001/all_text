package com.example.test8

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import androidx.drawerlayout.widget.DrawerLayout


class ProfileFragment : Fragment() {

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
    lateinit var fesslist :  ArrayList<Second_Data_Class>
    lateinit var customAdap : Second_Custom_Adapter

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(


        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       var layout =  inflater.inflate(R.layout.fragment_profile, container, false)


        var feesListView = layout.findViewById<ListView>(R.id.feesListView)
        var feesbtn = layout.findViewById<ImageView>(R.id.feesBtn)
        var drawerLayout = layout.findViewById<DrawerLayout>(R.id.drawertr)
        var  navigationView = layout.findViewById<ImageView>(R.id.navigationView)

        var lineButton = layout.findViewById<ImageView>(R.id.lineButton)





         fesslist = arrayListOf(
            Second_Data_Class(R.drawable.image,R.drawable.deleteimg,"Deepak Kumar","5000"),
            Second_Data_Class(R.drawable.image,R.drawable.deleteimg,"Rahul Kumar","7000"),
            Second_Data_Class(R.drawable.image,R.drawable.deleteimg,"Abhishek Kumar","8000"),
        )

         customAdap = Second_Custom_Adapter(requireContext(),fesslist,this)
        feesListView.adapter=customAdap


        feesbtn.setOnClickListener {




            var alertdialog = AlertDialog.Builder(requireContext())
            var layouto = LayoutInflater.from(requireContext()).inflate(R.layout.addfeesitem,null,false)
            var nameadds = layouto.findViewById<EditText>(R.id.nameadds)
          //  var emailadds = layouto.findViewById<EditText>(R.id.emailadds)
            var numberadds = layouto.findViewById<EditText>(R.id.numberadds)
            var addbtns  = layouto.findViewById<Button>(R.id.addbuttons)
            var alert = alertdialog.create()
            alert.setView(layouto)
            alert.show()

            addbtns.setOnClickListener {
                fesslist.add(
                    Second_Data_Class(R.drawable.image,R.drawable.deleteimg,nameadds.text.toString()
                    ,numberadds.text.toString())
                )
                customAdap.notifyDataSetChanged()
                alert.dismiss()

            }

        }

        return layout
    }

    fun onDeletefees(secondDataClass: Second_Data_Class, position: Int) {
        fesslist.removeAt(position)
        customAdap.notifyDataSetChanged()
    }

    @SuppressLint("MissingInflatedId")
    fun onuUpdatefees(images: Int, position: Int) {

        var alerdialo = AlertDialog.Builder(requireContext())
        val updateLayout = LayoutInflater.from(requireContext()).inflate(R.layout.updatefees,null,false)
        var naneEdits = updateLayout.findViewById<EditText>(R.id.nameupdate)
        var fessEdits = updateLayout.findViewById<EditText>(R.id.feesupdate)
        var fessbtn = updateLayout.findViewById<Button>(R.id.fessbuttons)

        var alertDialog = alerdialo.create()
        alertDialog.setView(updateLayout)
        alertDialog.show()

        fessbtn.setOnClickListener {
            fesslist[position]=
                Second_Data_Class(R.drawable.image,R.drawable.deleteimg,naneEdits.text.toString(),fessEdits.text.toString())

            customAdap.notifyDataSetChanged()
            alertDialog.dismiss()
        }



    }


}