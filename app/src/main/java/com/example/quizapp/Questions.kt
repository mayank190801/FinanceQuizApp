package com.example.quizapp

//A data class is a class which only used to store data in it. It functionality is often
//mechanically derivable from the data

//I have made a data class Questions to make objects from it which only stores data inside them.
//No specific functionality was needed.
data class Questions (

    //No. of Question
    val id:Int,

    //What is the Question
    val Question: String,

    //Option One
    val optionOne: String,

    //Option Two
    val optionTwo:String,

    //Option Three
    val optionThree:String,

    //Option Four
    val optionFour:String,

    //This is the integer of correct Answer
    val correctAnswer:Int,

    //This is the solution for the Answer
    val correctSolution:String
)


