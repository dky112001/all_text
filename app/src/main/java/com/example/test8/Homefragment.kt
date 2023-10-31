package com.example.test8

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AlertDialog


class Homefragment : Fragment() {


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
    lateinit var studentList : ArrayList<Data_Class>
    lateinit var customAdapter : Custom_Adapter

@SuppressLint("MissingInflatedId", "SuspiciousIndentation")
override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       var layout =  inflater.inflate(R.layout.fragment_homefragment, container, false)

    var listView = layout.findViewById<ListView>(R.id.listView)
    var plusBtn = layout.findViewById<ImageView>(R.id.plusBtn)

         studentList = arrayListOf(
            Data_Class(R.drawable.deleteimg,R.drawable.image,"Deepak Kumar","dky112001@gmail",
                "9693089341"),


 Data_Class(R.drawable.deleteimg,R.drawable.image,"Sachin Kumar","dky15102001@gmail",
                "9065864269")
         )
     customAdapter = Custom_Adapter(requireContext(),studentList,this)
    listView.adapter= customAdapter

        plusBtn.setOnClickListener {
            var alertDialog = AlertDialog.Builder(requireContext())
            var layouter = LayoutInflater.from(requireContext()).inflate(R.layout.addlistitem,null,false)
            var nameadd = layouter.findViewById<EditText>(R.id.nameadd)
            var emailadd = layouter.findViewById<EditText>(R.id.emailadd)
            var numberadd = layouter.findViewById<EditText>(R.id.numberadd)
            var addbtn  = layouter.findViewById<Button>(R.id.addbutton)
           var alert = alertDialog.create()
            alert.setView(layouter)
            alert.show()

            addbtn.setOnClickListener {
                studentList.add(
                    Data_Class(R.drawable.deleteimg,R.drawable.image,nameadd.text.toString(),emailadd.text.toString()
                    ,numberadd.text.toString())
                )
                customAdapter.notifyDataSetChanged()
                alert.dismiss()


            }


        }

    return layout
    }

    fun onDeleteImage(deleteimage: Int, position: Int) {
        studentList.removeAt(position)
        customAdapter.notifyDataSetChanged()
    }

    @SuppressLint("MissingInflatedId")
    fun onupdateClick(image: Int, position: Int) {
        var layout = LayoutInflater.from(requireContext()).inflate(R.layout.updatelist, null, false)

        var updatename = layout.findViewById<EditText>(R.id.updateName)
        var updatesubtitle = layout.findViewById<EditText>(R.id.updateSubtitle)

        var updateemail = layout.findViewById<EditText>(R.id.emailss)

        var updatebtnn = layout.findViewById<Button>(R.id.updatebtn)

        var alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.setView(layout)

        var dialog = alertDialog.create()

        dialog.show()

        updatebtnn.setOnClickListener {
        studentList[position]=
            Data_Class(
                R.drawable.deleteimg,R.drawable.image,updatename.text.toString(),updatesubtitle.text.toString()
                ,updateemail.text
                    .toString()
            )
        customAdapter.notifyDataSetChanged()
            dialog.dismiss()

        }

    }


}