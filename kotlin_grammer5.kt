/**
 * You can edit, run, and share this code. 
 * play.kotlinlang.org 
 */

fun main() {
           var h1 = Kotlin()
        h1.printHumanInfo()
    }


class Kotlin {
    var name: String = "KOTLIN"
    var gender: String = "남"
    var contry: String = "한국"
    fun printHumanInfo() {
        println("나라는 $contry 성별은 $gender 이름은 $name 입니다.");

        var p1 = Person()
        var car = Car()

        println("나라는 ${p1.contry} 성별은 ${p1.gender} 이름은 ${p1.name} 입니다.");
        car.touch = p1
        car.runStart()
    }
}
// 인터페이스: 정보를 교환할때 도와주는 매개체
open class Human:CarInterface{
    override fun vibration(wave: String) {
        if(wave == "덜덜덜")
        println("사람: 자동차 진동이 너무 심하군.")
    }
    open val name = "Kotlin"
    fun test(){
        var h1 = Kotlin()
        h1.printHumanInfo()
    }
}

// 상속: 유전자 성질을 부받는다.
open class Person:Human(){
    override val name:String="엘론머스크"
             val gender:String="남"
             val contry:String="미국"
}

interface CarInterface {
    fun vibration(wave:String)
}

class Car{
    var touch : CarInterface?= null
    fun runStart(){
        touch?.vibration("덜덜덜")
    }
}
