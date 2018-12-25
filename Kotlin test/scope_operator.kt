fun main() {
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

        // when문 자바의 swtch문과 비슷한 방식으로 작동함.
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
}
