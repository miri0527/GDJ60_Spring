const d1 = document.getElementById("d1")
const input1 = document.getElementById("input1")
const input2 = document.getElementById("input2")
const input3 = document.getElementById("input3")
const btn = document.getElementById("btn")

d1.addEventListener("click", function() {
    console.log("Click Event")
})

//마우스가 들어왔을 때
d1.addEventListener("mouseenter", function() {
    console.log("MouseEnter Event")
})

//키보드를 눌렀다 땠을 때
input1.addEventListener("keyup", function() {
    console.log("Keyup Event")
})

input2.addEventListener("focus", function() {
    console.log("focus Event")
})

//커서를 가지고 있다가 잃어버렸을 때
input2.addEventListener("blur", function() {
    console.log("blur Event")
})

//blur가 발생할 때 value가 저장 -> value가 바꼈을 때
input2.addEventListener("change", function() {
    console.log("change Event")
})

//radio는 value가 바뀌지 않기 때문에 change가 아니다
input3.addEventListener("change", function() {
    console.log(input3.value)
})

btn.onclick=function() {
    //focus 강제 실행 해라
    input2.focus();
}