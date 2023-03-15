//1.아이디 입력 -> 안하면 아이디는 필수사항입니다

const id = document.getElementById("id")
const idResult = document.getElementById("idResult")
id.addEventListener("blur", function() {
    if(id.value =='') {
        idResult.innerHTML = "아이디는 필수사항입니다"
    }else {
        idResult.innerHTML = ""
    }
})

//2.비밀번호 입력 확인
const pw = document.getElementById("pw")
const pwResult = document.getElementById("pwResult")

pw.addEventListener("blur", function() {
    if(pw.value == '') {
        pwResult.innerHTML = "비밀번호는 필수사항입니다"
    }else {
        pwResult.innerHTML = ""
    }
})

//비밀번호 확인 입력 확인
const pw2 = document.getElementById("pw2")
const pw2Result = document.getElementById("pw2Result")

pw2.addEventListener("blur", function() {

  
    
   
})
