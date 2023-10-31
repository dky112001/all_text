package com.example.test8

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Home_Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        var deletesee = findViewById<ImageView>(R.id.deletesee)
        var profilesee = findViewById<ImageView>(R.id.profilesee)
        var nameSee = findViewById<TextView>(R.id.namesee)
        var numberSee = findViewById<TextView>(R.id.numbersee)
        var emailSee = findViewById<TextView>(R.id.emailsee)


        var deletegetsee  = intent.extras?.getInt("dps")
        var profilegetsee = intent.extras?.getInt("ps")
        var namegetsee = intent.extras?.getString("ns")
        var numbergetsee = intent.extras?.getString("nuns")
        var emailgetsee = intent.extras?.getString("es")

        if (deletegetsee != null) {
            deletesee.setImageResource(deletegetsee)
        }
        if (profilegetsee != null) {
            profilesee.setImageResource(profilegetsee)
        }
        nameSee.text=namegetsee
        numberSee.text=numbergetsee
        emailSee.text=emailgetsee

    }
}