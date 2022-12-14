package com.lumitel.kwizera_ibrahim.mobiTransfer.oop

open class Lumicash(code: String) {
    val myPhoneNumber = 68274651
    val registeredName = "Kwizera Ibrahim"
    val myPinCode = 1234
    var myBalance = 100000


    /**************************** Lumicash Menu  **************************/

    fun displayOperationMenu(){
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

        val number: Int = readln().toInt()
        verifiedOperationMenu(number)  //Verified if chosen number exist
    }

    private fun verifiedOperationMenu(number: Int): Int{
        when(number){
            number->{
                if(number == 0){
                    println("Operation is Cancelled")
                }
                else if (number == 1){
                    println("you chose 1")}
                else if (number == 2){
                    println("you chose 2")
                }
                else if (number == 3){
                    println("you chose 3")
                }
                else if (number == 4){
                    println("you chose 4")
                }
                else if (number == 5){ }
                else if (number == 6){ }
                else if (number == 7){ }
                else if (number == 8){ }
                else if (number == 9){ }
                else if (number == 10){ }
                else if (number.toString()  in("a".."z") ||number.toString() in("A".."Z") ){
                    println("Only number are allowed")
                    displayOperationMenu()
                }
                else {
                    println("Selecting the wrong menu")
                    displayOperationMenu()
                }
            }
        }
        return number
    }
}