package com.lumitel.kwizera_ibrahim.mobiTransfer.oop

class CashOut {
    var agentCode = 1234
    var cashOutAmount = 1000
    var pinCodeForCash = 1000
    var cashOutFees = 1000
    var agentName = "SA Lumicash Agent"


    /*fun displayCashOutOperation(){
        println("Pls choose :")
        println("1.From Agent")
        println("2.Approve transaction")
        println("0.Return\n")

        when(readLine().toString()){
            "0"->{
                displayOperationMenu()
            }
            "1"->{
                enterAgentCode()
            }
            "2"->{
                println("Sorry this operation is under maintenance")
                displayCashOutOperation()
            }
            else->{
                println("Selecting the wrong menu")
                displayCashOutOperation()
            }
        }

    }
    fun enterAgentCode() : Int{
        println("Enter agent :")
        println("0.Return\n\n")
        agentCode =readln().toInt()

        when(agentCode){
            in 100001..999999->{
                enterAmountToCashOut()
            }
            0->{
                displayOperationMenu()
            }
            else->{
                println("Invalid agent code.Please try\nagain!")
                enterAgentCode()
            }
        }
        return agentCode
    }
    fun enterAmountToCashOut() : Int{
        println("Enter Amount:")
        println("0.Return\n\n")
        cashOutAmount = readln().toInt()

        when(cashOutAmount){
            in 1000..1000000->{
                pinCodeForCashOut()
            }
            0->{
                enterAgentCode()
            }
            else->{
                println("Wrong format of Amount.Please try\n check again!")
                enterAmount()
            }
        }
        return cashOutAmount
    }
    fun pinCodeForCashOut(): Int{
        println("Enter PIN Code:")
        println("0.Return\n\n")
        pinCodeForCash = readln().toInt()

        when(pinCodeForCash){
            in 1000..9999->{
                confirmBeforeCashOut(cashOutAmount, agentName, agentCode, cashOutFees)
            }
            0->{
                enterAmountToCashOut()
            }
            else->{
                println("Wrong format of Pin.Please try\ncheck again!")
                pinCodeForCashOut()
            }
        }
        return pinCode
    }
    fun confirmBeforeCashOut(amount:Int, name:String, code: Int, fee:Int) {
        println(
            " Confirmation to cash out $amount FBU " +
                    "\n to $name- $code, fee: $fee FBU"
        )
        println("Pls choose")
        println("1.Yes")
        println("2.No")
        println("0.Cancel\n\n")

        when (readln().toInt()) {
            1 -> {
                println("Cash out successfully!\n")
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