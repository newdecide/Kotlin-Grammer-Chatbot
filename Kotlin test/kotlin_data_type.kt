fun main() {
  // Double 64bit, Float 32bit, Long 64bit, Int 32bit, Short 16bit,Byte8bit
        var a: Int = 3
        a = 5
        var b: Int = 4
        var c: Int = a + b
        println(c)

        // Character
        var C: Char = 'z'
        println(C)

        // Boolean 논리값 true, false
        var d: Boolean = a > b // 5>4 true
        println(d)
        var e: Boolean = b > a // 4>5 false
        println(e)

        // String 문자열
        var string: String = "나는 문자열 입니다."
  
        // Array 배열
        var array: Array<Char> = arrayOf('a', 'b', 'c')
        println("$a + $b 는 $c 이다.")
        println("array 첫번째 인자 " + array.get(0) + " 두번째 인자 " + array.get(1) + " 세번째 인자 " + array.get(2))
}
