package com.lumitel.kwizera_ibrahim.mobiTransfer

import java.lang.Integer.parseInt

fun main(){
    // USSD code
    enterUSSDCode()
}

// user identification
const val myPhoneNumber = 68274651
const val registeredName = "Kwizera Ibrahim"
const val myPinCode = 1234
var myBalance = 100000

// 1st Transfer
var enteredAmount: Int = 1
var phoneNumber: Int = 1
var transferContent: String = "Lumicash"
var receiverName : String = "Irakoze Mossi"
var pinCode = 1111
var transferFees : Int = 1000

// 2nd Cash Out
var agentCode = 123456
var cashOutAmount = 1000
var cashOutFees = 1250
var agentName = "SA Lumicash Agent"

/**************************** Operation(USSD CODE AND VERIFICATION)  ******************************/

private fun enterUSSDCode(){
    println("Enter LumiCash code : \n")
    val code = readLine().toString()

    verifiedUSSCode(code)       // verify USSD Code
}
private fun verifiedUSSCode(code: String) :String{
    when(code){
        code->{
            if(code=="*163#"){
                displayOperationMenu()     // if it verified display Lumicash Menu
            }else{
                println("\nConnection problem or Invalid MMI code\n")
                enterUSSDCode()         // if code isn't correct restart again
            }
        }
    }
    return code
}
private fun displayOperationMenu(){
    println("Lumicash - pls choose :")
    println("1.Transfer")
    println("2.Cash Out")
    println("3.Buy airtime")
    println("4.Pay bills")
    println("5.Pay Merchant")
    println("6.Banking service")
    println("7.OBR")
    println("8.Mairie")
    println("9.Fertiliser")
    println("10.Utilities")
    println("0.Cancel\n")

    val choose = readLine().toString() //enter number value to choose
    stringVerificationForOperationMenu(choose) // chose operation and verified string at the same time
}
private fun stringVerificationForOperationMenu(isString: String){
    var isNumeric = true
    var isNumber = 1
    try {
        isNumber = parseInt(isString)

    }catch (e:NumberFormatException){
        isNumeric = false
    }
    if (isNumeric){
        verifiedOperationMenu(isNumber) // verified if the chosen number exist
    }
    else{
        println("Only number are allowed")
        displayOperationMenu()
    }
}
private fun verifiedOperationMenu(number: Int): Int{
    when (number) {
        0 -> println("Operation is Cancelled")
        1 -> enterPhoneNumber()                           // Transfer
        2 -> displayCashOutOperation()                   // Cash out
        3 -> displayAirTimeOperation()                  // Buy airtime

        //4 -> displayBillOperation()                 // Pay bill
        //5 -> displayMerchantOperation()            // Pay Merchant
        //6 -> displayBankOperation()               // Banking service
        //7 -> displayOBROperation()               // OBR
        //8 -> displayMairieOperation()           // Mairie
        //9 -> displayFertiliserOperation()      // Fertiliser
        //10 -> displayUtilityOperation()       // Utilities
        else -> {
            println("Selecting the wrong menu")
            displayOperationMenu()
        }
    }
    return number
}

/**************************** BEGIN First Operation(TRANSFER)  ************************************/

//phone number
private fun enterPhoneNumber(){
    println("Enter Phone number:")
    println("0.Return\n\n")
    val number =readLine().toString()

    // phone number verification
    stringVerificationForPhoneNumber(number)

}
private fun stringVerificationForPhoneNumber(isString: String){
    var isNumeric = true
    try {
        phoneNumber = parseInt(isString)

    }catch (e:NumberFormatException){
        isNumeric = false
    }
    when {
        isNumeric -> {
            verifyPhoneNumber(phoneNumber) // verified if the chosen number exist
        }
        else -> {
            println("Only phone number are allowed")
            enterPhoneNumber() // reenter correct format
        }
    }
}
private fun verifyPhoneNumber(number: Int) : Int{
    when (number) {
        in 61000000..62999999, in 65000000..69999999 -> {
            // check if the entered number is not the same as mine
            when {
                number != myPhoneNumber -> {
                    enterAmount()
                }
                else -> {
                    println("The phone number must be different your phone number")
                    enterPhoneNumber() //retry again
                }
            }
        }
        0 -> {
            displayOperationMenu() //return
        }
        else -> {
            println("Invalid phone number.Please try\nagain!")
            enterPhoneNumber() //retry again
        }
    }
    return number
}

// amount
private fun enterAmount() : Int{
    println("Enter Amount:")
    println("0.Return\n\n")
    val amount = readLine().toString()

    stringVerificationForMoney(amount)

    return enteredAmount
}
private fun stringVerificationForMoney(isString: String){
    var isNumeric = true
    try {
        enteredAmount = parseInt(isString)

    }catch (e:NumberFormatException){
        isNumeric = false
    }
    when {
        isNumeric -> {
            verifyEnteredAmount(enteredAmount)  // verified amount
        }
        else -> {
            println("Only money between 1000 to 1000000 are allowed")
            enterAmount() // reenter correct format
        }
    }
}
private fun verifyEnteredAmount(amount: Int) : Int{
    when(amount){
        in 1000..1000000->{
            enterTransferContent()
        }
        0->{
            enterPhoneNumber() //return to previous operation
        }
        else->{
            println("Wrong format of Amount.Please try\n check again!")
            enterAmount()  // reenter a correct format
        }
    }
    return amount
}

// transfer content
private fun enterTransferContent() : String {
    println("Enter Transfer Content:")
    println("0.Return\n\n")
    transferContent = readLine().toString()

    when(transferContent){
        transferContent ->{
            enterPinCode()
        }
        "0"->{
            enterAmount()
        }
    }
    return transferContent
}

//  pin code
private fun enterPinCode() {
    println("Enter PIN Code:")
    println("0.Return\n\n")
   val code = readLine().toString()

    stringVerificationForPinCode(code)

}
private fun stringVerificationForPinCode(isString: String){
    var isNumeric = true
    try {
        pinCode = parseInt(isString)

    }catch (e:NumberFormatException){
        isNumeric = false
    }
    when {
        isNumeric -> {
            verifyPinCode(pinCode)  // verified amount
        }
        else -> {
            println("Wrong format of Pin.Please try\ncheck again!")
            enterPinCode()// reenter correct format
        }
    }
}
private fun verifyPinCode(code: Int){
    if (code in 1000..9999 && code == myPinCode) {
        confirmationMessage(enteredAmount,receiverName,phoneNumber, transferContent, transferFees)
    }
    else if (code == 0) {
        enterTransferContent() // return to previous
    }
    else {
        println("Pin is not correct.Please check again")
        enterPinCode() // reenter again pin code
    }
}

//  balance
private fun remainBalance() {
    if(myBalance >= enteredAmount) {
        // remain balance
        val newBalance = myBalance - enteredAmount - transferFees

        println("Money transfer successfully!\n\n")
        println("Your new balance is $newBalance")
    } else{
        println("You do not have enough balance")
    }
}

// confirmation
private fun confirmationMessage(amount:Int, receiverName:String, receiverNumber:Int, contentName:String,fees:Int) {
    println(
        " Confirmation to transfer $amount " +
                "\n to $receiverName, $receiverNumber " +
                "\n for $contentName, fee: $fees FBU"
    )
    // after showing confirmation methode
    enterNumberToConfirmBeforeTransfer()
}
private fun enterNumberToConfirmBeforeTransfer(){
    println("Pls choose")
    println("1.Yes")
    println("2.No")
    println("0.Cancel\n\n")

    val trans = readLine().toString()
    finalStringVerification(trans)
}
private fun finalStringVerification(isString: String){
    var isNumeric = true
    var num = 1
    try {
        num = parseInt(isString)

    }catch (e:NumberFormatException){
        isNumeric = false
    }
    when {
        isNumeric -> {
            finalVerification(num)  // verified amount
        }
        else -> {
            println("Only number from 0 to 2 are allowed .Please try\n reenter pin code to continue")
            enterPinCode()    // reenter pin code to continue
        }
    }
}
private fun finalVerification(num: Int){
    when (num) {
        1 -> {
            remainBalance()
        }
        2 -> {
            println("Transaction is ending\n")
        }
        0 -> {
            println("Cancelled\n")
        }
        else -> {
            println("Only number from 0 to 2 are allowed .Please try\n reenter pin code to continue")
            enterPinCode()    // reenter pin code to continue
        }
    }
}


/******************* End of First Operation And Begin Second Operation(CASH OUT) ******************/

private fun displayCashOutOperation(){
    println("Pls choose :")
    println("1.From Agent")
    println("2.Approve transaction")
    println("0.Return\n")

    val chose = readLine().toString()
    stringVerificationForCashOut(chose)


}
private fun stringVerificationForCashOut(isString: String){
    var isNumeric = true
    var isNumber = 1
    try {
        isNumber = parseInt(isString)

    }catch (e:NumberFormatException){
        isNumeric = false
    }
    if (isNumeric){
        verifiedCashOutOperationMenu(isNumber) // verified if the chosen number exist
    }
    else{
        println("Only number are allowed")
        displayCashOutOperation()
    }
}
private fun verifiedCashOutOperationMenu(number: Int): Int{
    when(number){
        0->displayOperationMenu()
        1->enterAgentCode()
        2->{
            println("Sorry this operation is under maintenance")
            displayCashOutOperation()
        }
        else->{
            println("Selecting the wrong menu")
            displayCashOutOperation()
        }
    }
    return number
}

// agent code
private fun enterAgentCode(){
    println("Enter agent :")
    println("0.Return\n\n")
    val code =readLine().toString()

    stringVerificationForAgentCode(code)
}
private fun stringVerificationForAgentCode(isString: String){
    var isNumeric = true
    try {
        agentCode = parseInt(isString)

    }catch (e:NumberFormatException){
        isNumeric = false
    }
    when {
        isNumeric -> {
            verifyAgentCode(agentCode)  // verified agent code
        }
        else -> {
            println("Wrong format of agent code.Please try\ncheck again!")
            enterAgentCode()// reenter correct format
        }
    }
}
private fun verifyAgentCode(code: Int){
    if (code in 100000..999999 && code == agentCode) {
        enterAmountToCashOut()
    }
    else if (code == 0) {
        displayOperationMenu() // return to previous
    }
    else {
        println("Agent code is not correct.Please try again!")
        enterAgentCode() // reenter again pin code
    }
}


// amount
private fun enterAmountToCashOut(){
    println("Enter Amount:")
    println("0.Return\n\n")
    val amount = readLine().toString()
    stringVerificationCashOut(amount)

}
private fun stringVerificationCashOut(isString: String){
    var isNumeric = true
    try {
        cashOutAmount = parseInt(isString)

    }catch (e:NumberFormatException){
        isNumeric = false
    }
    when {
        isNumeric -> {
            verifyEnteredCashOutAmount(cashOutAmount)  // verified amount
        }
        else -> {
            println("Only money between 1000 to 1000000 are allowed")
            enterAmountToCashOut() // reenter correct format
        }
    }
}
private fun verifyEnteredCashOutAmount(amount: Int) : Int{
    when(amount){
        in 1000..1000000->{
            enterPinCodeForCashOut()
        }
        0->{
            enterAgentCode() //return to previous operation
        }
        else->{
            println("Wrong format of Amount.Please try\n check again!")
            enterAmountToCashOut()  // reenter a correct format
        }
    }
    return amount
}

// pin code
private fun enterPinCodeForCashOut(){
    println("Enter PIN Code:")
    println("0.Return\n\n")
    val code  = readLine().toString()

    stringVerificationForPinCodeForCashOut(code)  // string or Integer
}
private fun stringVerificationForPinCodeForCashOut(isString: String){
    var isNumeric = true
    try {
        pinCode = parseInt(isString)

    }catch (e:NumberFormatException){
        isNumeric = false
    }
    when {
        isNumeric -> {
            verifyPinCodeForCashOut(pinCode)  // verified pin code if exist
        }
        else -> {
            println("Wrong format of Pin.Please try\ncheck again!")
            enterPinCodeForCashOut()// reenter correct format
        }
    }
}
private fun verifyPinCodeForCashOut(code: Int){
    if (code in 1000..9999 && code == myPinCode) {
        confirmationMessage(cashOutAmount, agentName, agentCode, cashOutFees)
    }
    else if (code == 0) {
        enterAmountToCashOut() // return to previous
    }
    else {
        println("Pin is not correct.Please check again")
        enterPinCodeForCashOut() // reenter again pin code
    }
}

//  balance
private fun remainCashOutBalance(){
    if(myBalance >= enteredAmount) {
        // remain balance
        val newBalance = myBalance - cashOutAmount - cashOutFees

        println("Cash out successfully!\n\n")
        println("Your balance is $newBalance")
    } else{
        println("You do not have enough balance")
    }
}

// confirmation
private fun confirmationMessage(amount:Int, agentName:String, agentCode: Int, fee:Int) {
    println(
        " Confirmation to cash out $amount FBU " +
                "\n to $agentName- $agentCode, fee: $fee FBU"
    )
    enterNumberToConfirmBeforeCashOut() //choose number to confirm
}
private fun enterNumberToConfirmBeforeCashOut(){
    println("Pls choose")
    println("1.Yes")
    println("2.No")
    println("0.Cancel\n\n")

    val trans = readLine().toString()
    finalStringVerificationCashOut(trans)
}
private fun finalStringVerificationCashOut(isString: String){
    var isNumeric = true
    var num = 1
    try {
        num = parseInt(isString)

    }catch (e:NumberFormatException){
        isNumeric = false
    }
    when {
        isNumeric -> {
            finalCashOutVerification(num)  // verified amount
        }
        else -> {
            println("Only number from 0 to 2 are allowed .Please try\n reenter pin code to continue")
            enterPinCodeForCashOut()    // reenter pin code to continue
        }
    }
}
private fun finalCashOutVerification(num: Int){
    when (num) {
        1 -> {
            remainCashOutBalance()
            println("Cash out successfully!\n")
        }
        2 -> {
            println("Transaction is ending\n")
        }
        0 -> {
            println("Cancelled\n")
        }
        else -> {
            println("Only number from 0 to 2 are allowed .Please try\n reenter pin code to continue")
            enterPinCodeForCashOut()    // reenter pin code to continue
        }
    }
}

/******************* End of Second Operation And Begin third Operation(CASH OUT) ******************/
private fun displayAirTimeOperation(){
    println("Pls choose :")
    println("1.My tel number")
    println("2.Other tel number")
    println("0.Return\n")

    when(readLine().toString()){
        "0"->{
            displayOperationMenu()
        }
        "1"->{
            //verify if number exist
            //if ()
        }
        "2"->{
            println("Sorry this operation is under maintenance")
            displayCashOutOperation()
        }
        else->{
            println("Selecting the wrong menu")
            displayAirTimeOperation()
        }
    }

}

