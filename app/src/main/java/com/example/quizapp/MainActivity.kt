package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //just removing everything at the top
        //To make it look more professional!
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        //Start Button on the home screen
        //This is function which will let you to perfrom the task after you click the button
        startBtn.setOnClickListener {

            //if the space is empty and someone presses this button
            if(enterNameEt.text.toString().isEmpty()){
                //A Toast message will appear on there screen
                Toast.makeText(this,"Please enter your name!", Toast.LENGTH_SHORT).show()
            }else{
                //Otherwise it will take you to the next screen and take that data and store it.
                val intent = Intent(this,QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, enterNameEt.text.toString())
                startActivity(intent)
                finish()
            }

        }

    }
}