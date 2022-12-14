package com.lumitel.kwizera_ibrahim.mobiTransfer.oop

fun main(){
    lumtelCode()
}

fun lumtelCode(){

    println("Enter code : ")

    when(val code: String = readln().toString()){
        code->{
            if(code=="*163#"){
                val lumicash = Lumicash(code)
                lumicash.displayOperationMenu() // if it verified display Lumicash Menu
            }else{
                println("\nConnection problem or Invalid MMI code\n")
                lumtelCode() // if code isn't correct restart again
            }
        }
    }

}