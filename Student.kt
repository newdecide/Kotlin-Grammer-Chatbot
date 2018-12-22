
// 객체생성
class Student{
    var name : String? = null
    var subject : Subject? = null
    
    class Subject{
        var math : Int? = null
        var english : Int? = null
       
    }
}

data class Student2(
	var name : String,
    var subject : Subject
){
    data class Subject(
        var english : Int,
        var math : Int
    )
}