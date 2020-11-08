package com.example.quizapp

//If you need a singleton - a class that only has got one instance - you can declare the class in the usual way, but use the object keyword instead of class:
//since i needed a class named constant which had to store some data and funtion
//and it pretty much had only one instance so i named it object

object Constants {

    //These are the variables i used to store the data and can be assessed from anywhere
    //in the file
    const val CURRENT_QUESTION: String = "0"
    const val USER_NAME :String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_question"
    const val CORRECT_ANSWERS : String = "correct_answers"

    //This function will return the arrayList of type Question
    //it will contain Question Objects
    //and every question object is a complete Real Finance Question

    fun getQuestions(): ArrayList<Questions>{
        val questionList = ArrayList<Questions>()

        //here we initalize objects and store data inside them
        val ques1 = Questions(
            1,
            "What are the three most important criteria to consider" +
                    " when investing?",
            "size,insurance,taxes",
            "leverage,margins,credit",
            "liquidity,risk,rate of return",
            "collateral,access to accounts,dividends",
            3,
            "Liquidity refers to the ease with which the investment can be converted to cash. Risk is important in investing because the money can be made or lost. The rate of return is the income earned for saving or investing.\n" +
                    "\n" +
                    "These three factors have the most important influence on the value of an asset or investment.\n"
        )

        val ques2 = Questions(
            2,
            "Stock A has been issued by a new corporation. Stock B is considered " +
                    "a \"blue chip\" stock. Which is true about these two stocks?" ,
            "Stock A is expected to be relatively more risky than stock B.",
            "Stock B is expected to earn a higher rate of return than stock A.",
            "Stock B is expected to pay a guaranteed rate of return and Stock A will not.",
            "Stock A is expected to hold its value better than Stock B if interest rates rise.",
            1,
            "Investing in a “blue chip” stock is less risky than investing in a new corporation’s stock.\n" +
                    "\n" +
                    "Stocks of large companies with long histories and strong reputations are often considered blue chip stocks. They are more likely to hold their value.\n" +
                    "\n" +
                    "Stock in new companies have a higher expected rate of return, but more risk than blue chip stocks. \n"
            )

        val ques3 = Questions(
            3,
            "When interest rates increase,",
            "savers earn less interest and borrowers pay less interest.",
            "savers earn less interest, but borrowers pay more interest.",
            "savers earn more interest, but borrowers pay less interest.",
            "savers earn more interest and borrowers pay more interest",
            4,
            "The interest rate determines the amount a borrower pays a lender for the use of money.\n" +
                    "\n" +
                    "As the interest rate increases, more interest must be paid from the borrower to the lender."
        )

        val ques4 = Questions(
            4,
            "Interest that is left in an account for a period of time" +
                    " also earns interest. What is this called?",
            "double profit",
            "extra principal",
            "special interest",
            "compound interest",
            4,
            "A person earns interest on all the money in an account, not just the amount deposited. For example: If \$100 is deposited and earns \$2 in interest in one period, interest will be earned on \$102 the next period.\n" +
                    "\n" +
                    "This is called compound interest and allows money to grow much more than \$2 every period if the money is left in the account for a long time."
        )

        val ques5 = Questions(
            5,
            "What will a lender do if someone who has a higher than" +
                    " average risk of nonpayment wants to borrow money?",
            "charge a lower interest rate",
            "charge a higher interest rate",
            "reduce the person's credit score",
            "raise the person's credit score",
            2,
            "Both the interest rate and the risk of default determine the rate of return a lender expects to receive on a loan.\n" +
                    "\n" +
                    "If the risk of default is greater for a certain potential borrower than others the lender could make the loan to, the lender will charge the riskier borrower a higher interest rate to receive the same rate of return.\n" +
                    "\n" +
                    "The lender will not affect the borrower’s credit score when make the loan."

        )

        val ques6 = Questions(
            6,
            "Liquidity risk is highest for which type of investment?",
            "real estate",
            "mutual fund",
            "savings account",
            "individual stocks",
            1,
            "Real estate typically does not have much liquidity because it is often a unique item and it takes time for a seller to find a buyer and agree on terms.\n" +
                    "\n" +
                    "Most mutual funds and individual stocks are liquid assets that can easily be sold and converted to cash because the assets are traded in stock exchanges. It is also easy to get cash from a savings account.\n"
        )

        val ques7 = Questions(
            7,
            "Why are mortgage interest rates generally lower" +
                    " than credit card interest rates?",
            "mortgages are backed by collateral",
            "interest rates are lower on large loans",
            "most consumers generally do not qualify for mortgages",
            "federal regulations set credit card rates",
            1,
            "Collateral is property that a lender can sell if the borrower does not pay back the loan. Collateral reduces the risk associated with making a loan, and reduces the interest rate, all else constant.\n" +
                    "\n" +
                    "House serve as collateral for mortgages, but credit card loans are “unsecured”, or contain no collateral."
        )

        val ques8 = Questions(
            8,
            "You decide that you want to save 10% of each paycheck." +
                    "You tell your bank to place 10% of each paycheck into " +
                    "your savings account. This strategy is called :",
            "pay yourself first.",
            "net worth analysis.",
            "collateral planning.",
            "living above your means.",
            1,
            "“Pay yourself first” is taking a fixed percentage or amount of your income and having your bank direct deposit it into your savings account. This payment or deposit to savings is made before paying for expenses from a pay check.\n"
        )

        val ques9 = Questions(
            9,
            " A 15-year mortgage typically requires " +
                    "higher monthly payments than a " +
                    "30-year mortgage but the total interest " +
                    "over the life of the loan will be less.",
            "True",
            "False",
            "Remains Same",
            "Don't Know",
            1,
            "Assuming the same interest rate for both loans, you will pay less in interest over the life of a 15-year loan than you would with a 30-year loan because you repay the principal at a faster rate. This also explains why the monthly payment for a 15-year loan is higher. Let’s say you get a 30-year mortgage at 6 percent on a \$150,000 home. You will pay \$899 a month in principal and interest charges. Over 30 years, you will pay \$173,757 in interest alone. But a 15-year mortgage at the same rate will cost you less. You will pay \$1,266 each month but only \$77,841 in total interest—nearly \$100,000 less."
        )

        val ques10 = Questions(
            10,
            "Buying a single company's stock usually " +
                    "provides a safer return than a stock mutual fund.",
            "True",
            "False",
            "Both are same",
            "Don't Know",
            2,
            "In general, investing in a stock mutual fund is less risky than investing in a single stock because mutual funds offer a way to diversify. Diversification means spreading your risk by spreading your investments. With a single stock, all your eggs are in one basket.\n" +
                    "\n" +
                    " If the price falls when you sell, you lose money. With a mutual fund that invests in the stocks of dozens (or even hundreds) of companies, you lower the chances that a price decline for any single stock will impact your return. Diversification generally may result in a more consistent performance in different market conditions."
        )

        //Adding all the question in the questionList arrayList
        //One by one
        questionList.add(ques1)
        questionList.add(ques2)
        questionList.add(ques3)
        questionList.add(ques4)
        questionList.add(ques5)
        questionList.add(ques6)
        questionList.add(ques7)
        questionList.add(ques8)
        questionList.add(ques9)
        questionList.add(ques10)

        return questionList
    }

}