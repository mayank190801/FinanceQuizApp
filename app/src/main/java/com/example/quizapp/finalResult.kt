package com.example.quizapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_final_result.*

class finalResult : AppCompatActivity() {

    //THis is the final Result Activity!!

    //we will set everyone one of them from intent data transfer
    //Getting data from the last acitivity

    private var mCorrectAnswers: String = "Random"
    private var mTotalAnswers: String = "Random"
    private var mUserName: String = "Random"
    private var mIQ: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_result)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        mCorrectAnswers = intent.getStringExtra(Constants.CORRECT_ANSWERS).toString()
        mTotalAnswers = intent.getStringExtra(Constants.TOTAL_QUESTIONS).toString()
        mUserName = intent.getStringExtra(Constants.USER_NAME).toString()
        mIQ = mCorrectAnswers.toInt()*10


        nameTv.text = mUserName
        scoreTv.text = "Your Score is $mCorrectAnswers out of $mTotalAnswers"
        financialIqTv.text = "Your financial IQ is $mIQ"


        //To button are there and these two functions for them

        //it will just end everything and take you back to starting page
        finalButtonBtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        //it will take you to a new link in chrome or any browser to CNBC.com
        //so that you can learn more about finance and stuff
        learnMoreBtn.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.addCategory(Intent.CATEGORY_BROWSABLE)
            intent.data = Uri.parse("http://www.CNBC.com")
            startActivity(intent)
        }



    }
}

