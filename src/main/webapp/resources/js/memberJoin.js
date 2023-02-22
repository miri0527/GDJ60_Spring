//1. 아이디 -> 필수사항입니다
const id = document.getElementById("id")
const idResult = document.getElementById("idResult")
id.addEventListener("blur", function() {
    if(id.value == "") {
        idResult.innerHTML = "ID는 필수사항입니다"
    }else {
        idResult.innerHTML = ""
    }
})

//2. pw 검증
const pw = document.getElementById("pw")
const pwResult = document.getElementById("pwResult")
pw.addEventListener("blur", function() {
    
} )




