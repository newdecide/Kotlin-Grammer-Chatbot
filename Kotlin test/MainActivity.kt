package com.study.immerse.poundation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // var 변수: 변하는 값, val 상수: 변하지 않는 값
        var apple: String? = "사과"
        apple = "배"
        println(apple)

        val A: Int = 5
        println(A)
        // 상수는 값을 바꿀수 없다. 에러남.
        // A=10

        // 변수는 값을 바꾸면 잘 적용된다.
        var a: Int = 3
        a = 5


        // Double 64bit, Float 32bit, Long 64bit, Int 32bit, Short 16bit,Byte8bit
        var b: Int = 4
        var c: Int = a + b
        println(c)

        // Character
        var C: Char = 'z'
        println(C)

        // Boolean 논리값 true, false
        var d: Boolean = a > b // 3>4 false
        println(d)
        var e: Boolean = b > a // 4>3 true
        println(e)

        // String 문자열
        var string: String = "나는 문자열 입니다."

        // Array 배열
        var array: Array<Char> = arrayOf('a', 'b', 'c')
        println("$a + $b 는 $c 이다.")
        println("array 첫번째 인자 " + array.get(0) + " 두번째 인자 " + array.get(1) + " 세번째 인자 " + array.get(2))

        // 범위연산자
        print("for문은=")
        for (x in 1..10) {
            print(x)
        }
        println()

        var q: Int = 5
        var w: Int = 6

        // If else문
        if (q == w) {
            println("q와 w는 같다.")
        } else if (q < w) {
            println("q는 w보다 작다.")
        } else {
            println("비교할 수 없다.")
        }

        var x: Int = 3
        when (x) {
            1 -> println("x값은 1입니다.")
            2 -> println("x값은 2입니다.")
            else -> {
                println("x값은 1또는 2가 아닙니다.")
            }
        }

        print("while문은=")
        while(x<=10){
            x++
            print(x)
        }
        println()

        // 안전해제
        var name:String?="Kotlin"
        var name2:String?=null
        // name, name2로 바로 해제된다.
        // name 길이
        println("안전해제 문자열 kotlin: "+name?.length)
        println("안전해제 문자열 null값 길이: "+name2?.length)

        var kotlin:String=""
        var name3:String?="kotlin"

        // kotlin = name3 강제해제 하지 않으면 에러발생
        kotlin = name3!! // 강제해제 하므로 에러 해결

        var h1 = Kotlin()
        h1.printHumanInfo()
    }
}

class Kotlin {
    var name: String = "KOTLIN"
    var gender: String = "남"
    var contry: String = "한국"
    fun printHumanInfo() {
        println("나라는 $contry 성별은 $gender 이름은 $name 입니다.");

        var p1 = Person()

        println("나라는 ${p1.contry} 성별은 ${p1.gender} 이름은 ${p1.name} 입니다.");

    }
}
open class Human{
    open val name = "Kotlin"
    fun test(){
        var h1 = Kotlin()
        h1.printHumanInfo()
    }

}

open class Person:Human(){
    override val name:String="엘론머스크"
             val gender:String="남"
             val contry:String="미국"

}