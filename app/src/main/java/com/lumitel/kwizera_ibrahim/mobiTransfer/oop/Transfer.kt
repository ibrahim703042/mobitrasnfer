package com.lumitel.kwizera_ibrahim.mobiTransfer.oop

class Transfer {

    var enteredAmount: Int = 1
    var phoneNumber: Int = 0
    var transferContent: String = "Lumicash"
    var receiverName : String = "Simbananiye Hafsa"
    var pinCode = 1111
    var transferFees : Int = 1000

    fun transferMoney(){
        enterPhoneNumber()
    }
     private fun enterPhoneNumber(){
        println("Enter Phone number:")
        println("0.Return\n\n")
        phoneNumber =readln().toInt()

        when(phoneNumber){
            phoneNumber-> {
                //verify  phone number is equal as username
                when (phoneNumber) {
                    in (61000000..69999999) -> {
                        //verifyPhoneNumber()
                    }
                    0 -> {
                        /* displayOperationMenu() */
                    }
                    else -> {
                        println("Invalid phone number.Please try\nagain!")
                        enterPhoneNumber()
                    }
                }
            }
        }
    }

    fun verifyPhoneNumber(){
        if (phoneNumber != 68274651){
            enterAmount()
        }
        else{
            println("The phone number must be different your phone number")
            enterPhoneNumber()
        }
    }

    fun enterAmount() : Int{
        println("Enter Amount:")
        println("0.Return\n\n")
        enteredAmount = readln().toInt()

        when(enteredAmount){
            in 1000..1000000->{
                enterTransferContent()
            }
            0->{
                enterPhoneNumber()
            }
            else->{
                println("Wrong format of Amount.Please try\n check again!Enter amount:")
                enterAmount()
            }
        }
        return enteredAmount
    }
    fun enterTransferContent() : String {
        println("Enter Transfer Content:")
        println("0.Return\n\n")
        transferContent = readln().toString()

        when(transferContent){
            transferContent ->{
                pinCode()
            }
            "0"->{
                enterAmount()
            }
        }
        return transferContent
    }
    fun pinCode() : Int {
        println("Enter PIN Code:")
        println("0.Return\n\n")
        pinCode = readln().toInt()

        when(pinCode){
            pinCode->{
                when(pinCode){
                    in 1000..9999->{
                        /*confirmBeforeTransfer(
                            enteredAmount,
                            receiverName,
                            phoneNumber,
                            transferContent,
                            transferFees
                        )*/
                    }
                    0->{
                        enterTransferContent()
                    }
                    else->{
                        println("Wrong format of Pin.Please try\ncheck again!Enter Pin:")
                        pinCode()
                    }
                }
            }
        }
        return pinCode
    }
    /*fun verifyPinCodeAndBalance(){
        if (pinCode == myPinCode){
            if(myBalance >= enteredAmount) {
                // remain balance
                var newBalance = myBalance - enteredAmount - transferFees
                println("Your new balance is $newBalance")
            }
            else{
                println("You do not have enough balance")
            }

            println("Money transfer successfully!\n")
        }
        else{
            println("Pin is not correct.Please check again")
        }
    }
    fun confirmBeforeTransfer(amount:Int, receiverName:String, receiverNumber:Int, contentName:String,fees:Int) {
        println(
            " Confirmation to transfer $amount " +
                    "\n to $receiverName, $receiverNumber " +
                    "\n for $contentName, fee: $fees FBU"
        )
        println("Pls choose")
        println("1.Yes")
        println("2.No")
        println("0.Cancel\n\n")

        when (readln().toInt()) {
            1 -> {
                verifyPinCodeAndBalance()
            }
            2 -> {
                println("Transaction is ending\n")
            }
            0 -> {
                println("Cancelled\n")
            }
            else -> {
                println("\n")
            }
        }
    }*/
}