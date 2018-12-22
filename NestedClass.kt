// 메인 함수
fun main(args: Array<String>) {
    // Student 함수 class 객체 생성
    var student = Student()
    // class의 name 데이터 입력
    student.name = "코틀린"
    // NestedClass 객채 생성(중첩 클래스)
    var subject = Student.Subject()
    // NestedClass 데이터 입력
    subject.english = 90
    subject.math = 80
    
    // Student클래스에 수학, 영어 점수 데이터 입력
    student.subject = subject
    println("class: ${student.name}의 영어점수 ${student.subject?.english}는 수학점수 ${student.subject?.math}는 입니다.")
    
    // Student2클래스 객체 생성하면서 데이터 한번에 입력
    var student2 = Student2("코틀린",Student2.Subject(100,90))
    println("dataclass: ${student2.name}의 영어점수 ${student2.subject?.english}는 수학점수 ${student2.subject?.math}는 입니다.")
    
}
