package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*


//View.OnClickListener is defined so that all click element can be taken elsewhere
//To optimize the code

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    //These are personal variables for the page which will be used extensively
    private var mCurrentPosition:Int = 1

    //The question mark helps the compiler to know that is this variable can be nullable
    private var mQuestionsList: ArrayList<Questions>? = null
    private var mSelectedOptionPosition:Int = 0
    //To have the score you have
    private var mCorrectedAnswer:Int = 0
    private var mUserName :String? = null
    private var oneDoneNoReverse: Int = 0


    //this is the main function where all stuff happens
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)


        //getting data through intents
        mUserName = intent.getStringExtra(Constants.USER_NAME)

        //this one takes the arraylist from constants and bring it here
        mQuestionsList = Constants.getQuestions()

        //using a function to set questions once the code is started
        setQuestion()

        //stuff on which we want to put click thingy so it work when u click them
        optionOneTv.setOnClickListener(this)
        optionTwoTv.setOnClickListener(this)
        optionThreeTv.setOnClickListener(this)
        optionFourTv.setOnClickListener(this)
        submitAnswerBtn.setOnClickListener(this)
        answerCheckBtn.setOnClickListener(this)

    }

    //these below are functions i have tried to use for the main funtions to work smoothly
    private fun setQuestion(){

        //Take the question Object from the ArrayList
        val questions = mQuestionsList!![mCurrentPosition-1]

        //you will figure it out later in the code
        //One more function for making everything back to default after every submission
        defaultOptionsView()

        //In case you are at the last Question!!
        //Now it will not be sumbit anymore
        if(mCurrentPosition == mQuestionsList!!.size+1){
            submitAnswerBtn.text = "FINISH"
        }else{
            submitAnswerBtn.text = "SUBMIT"
        }

        //this is dumb, but is connect with currentPosition variable
        //for the updating that progress bar!

        progressBar.progress = mCurrentPosition
        progessTv.text = "$mCurrentPosition" + "/" + progressBar.max

        //setting all the text on the page to new question Text
        //!! that means the value definitely exist
        questionTv.text = questions!!.Question
        optionOneTv.text = questions!!.optionOne
        optionTwoTv.text = questions!!.optionTwo
        optionThreeTv.text = questions!!.optionThree
        optionFourTv.text = questions!!.optionFour
        questionSolutionTv.text = questions!!.correctSolution

    }

    private fun defaultOptionsView(){

        //making an array of TextView Present
        val options = ArrayList<TextView>()

        options.add(0 , optionOneTv)
        options.add(1 , optionTwoTv)
        options.add(2, optionThreeTv)
        options.add(3, optionFourTv)

        //Going through all of them and making them default
        for(option in options){

            //this is all stuff is making all of them back to default!
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    //Making on Click Function seperately for better readability
    //I could have put it back in the main function but i preffered to have it in the
    //here otherwise it would have messed up the main function

    override fun onClick(v: View?) {
        when(v?.id){

            //the below four are basically when you click any option
            //it will slightly change it appearance so you will know it is selected
            //just read the selectionOptionView Function and you will know it
            R.id.optionOneTv ->{
                selectedOptionView(optionOneTv, 1)
            }
            R.id.optionTwoTv ->{
                selectedOptionView(optionTwoTv, 2)
            }
            R.id.optionThreeTv ->{
                selectedOptionView(optionThreeTv, 3)
            }
            R.id.optionFourTv ->{
                selectedOptionView(optionFourTv, 4)
            }
            //this is the answer button which will apear after you would have clicked submit
            //it will show the solution below it by making it visible
            R.id.answerCheckBtn ->{
                questionSolutionTv.visibility = View.VISIBLE
            }
            //The most important button of all
            //This is the submit button and it will change pretty much everything on that page
            R.id.submitAnswerBtn ->{

                //There are two cases for it too
                //when you click the submit button after you have seen the answer
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when{
                        //when the question size is greater the current position
                        mCurrentPosition <= mQuestionsList!!.size ->{
                            //call the setQuestion and update all the Questions
                            setQuestion()
                        }else ->{
                            //just take it to the last page with taking all data in
                            //object constant
                            val intent = Intent(this, finalResult::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size.toString())
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectedAnswer.toString())
                            startActivity(intent)
                            finish()
                        }
                    }

                    //these button and answer should go back to inivisible
                    answerCheckBtn.visibility = View.GONE
                    questionSolutionTv.visibility = View.GONE

                    //So again we can select the options!
                    //Otherwise we will never be able to select options anymore
                    oneDoneNoReverse = 0

                }else{
                    //if this the first time i clicked on the submit button
                    //it will check with answer with selected option!

                    var questions = mQuestionsList?.get(mCurrentPosition-1)
                    //if wrong then it will hightlight the selected option in Red
                    if(questions!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        //if it is correct it will simply increase the number of correct answers
                        mCorrectedAnswer++
                    }

                    //In both cases the correct answer has to be green bordered
                    answerView(questions!!.correctAnswer, R.drawable.correct_option_border_bg )

                    //checking for the last question
                    //Then the invisible button will come to visibility
                    answerCheckBtn.visibility = View.VISIBLE

                    //Change the button name
                    if(mCurrentPosition == mQuestionsList!!.size){
                        submitAnswerBtn.text = "FINISH"
                    }else{
                        submitAnswerBtn.text = "GO TO NEXT QUESTION"

                    }

                    //setting the selectedPosition back to 0 so that the second case happen
                    mSelectedOptionPosition = 0
                    //oneDoneNoReverse is very important becuase once you selected the option and
                    //press the submit button you would not be able to select options anymore
                    //you will see in the following function
                    oneDoneNoReverse = 1
                }
            }
        }
    }

    //it will change the background of the answer! To tell if u are correct or not
    private fun answerView(answer:Int, drawableView : Int){
        when(answer){
            1 -> {
                optionOneTv.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            2 -> {
                optionTwoTv.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            3 -> {
                optionThreeTv.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            4 -> {
                optionFourTv.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
        }

    }

    //it makes them bright when u click on them(OPTIONS)
    private fun selectedOptionView(tv:TextView, selectedOptionNumber: Int){

        if(oneDoneNoReverse == 1){
            return
        }

        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNumber

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }
}