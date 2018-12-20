fun main() {
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
}
