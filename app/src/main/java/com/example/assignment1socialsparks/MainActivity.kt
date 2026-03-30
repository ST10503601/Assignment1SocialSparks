package com.example.assignment1socialsparks

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var txtTime : EditText
    lateinit var btnSubmit : Button
    lateinit var btnReset : Button
    lateinit var txtResult : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        txtTime = findViewById(R.id.txtTime)
        btnSubmit = findViewById(R.id.btnSubmit)
        btnReset = findViewById(R.id.btnReset)
        txtResult = findViewById(R.id.txtResults)

        btnSubmit.setOnClickListener {
            val time = txtTime.text.toString().trim().lowercase()
            var result = ""

            // Check all feilds present
             if (time.isEmpty())
                txtResult.text =" Please enter time of day"

                if(time == "morning") {
                   result =  "Send a 'Good morning' text to a family member"
                } else if (time == "mid-morning") {
                   result =  "Reach out to colleague with a quick 'Thank you'"
                } else if (time == "afternoon") {
                     result = "Share a funny meme or intersting link with a friend"
                } else if (time == "afternoon snack time"){
                     result = "Send a quick thinking of you'message"
                } else if (time == "dinner"){
                     result ="Call a friend or relative a 5-minute catch-up"
                } else if (time == "after dinner"|| time =="night"){
                     result = "Leave a thoughtful comment on a friend's post"
                } else {
                    result = "Try entering: Morning, Afternoon, Dinner,ect"
                }
                txtResult.text=result
        }
        btnReset.setOnClickListener {
            txtTime.text.clear()
            txtResult.text = " "

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}