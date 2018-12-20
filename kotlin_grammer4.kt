fun main() {
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
}
