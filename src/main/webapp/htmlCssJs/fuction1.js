const d1 = document.getElementById("d1")



//자바스크립트는 선언 먼저 안해도 호출이 가능
f1();
//전역변수
let n = 'iu';
//같은 변수명으로 선언해도 에러 X
var old = "iu"

// function 선언
function f1 () {
    console.log("function Test");
    var old = "winter";
}

// 매개변수 선언 시 let, const는 생략해야 함
function f2(n1,n2) {
    let name='iu';
    return n1+n2;
}

// function 호출
f1();
let result =  f2(1,2)
console.log(result)
console.log(name)
//에러
//console.log(n1);
console.log("Old : " + old);

//익명함수
let fun = function() {
    console.log('익명함수');
    return 1;
}

fun();

function f3 (f) {
    console.log("f3" ,f,1);
}




//다른 곳에서도 같은 함수를 사용하고 싶을 때 
//callback1() -> event 걸 때 호출됨
//d1.addEventListener("click", callback1 );
//d1.addEventListener("click", callback2 );

//딱 이 부분만 사용하고 싶을 때
d1.addEventListener("click", function() {
    //함수 호출
    callback1();
    callback2();
} );

//선언만 되어 있으면 됨
function callback1() {
    console.log("callBack1")
}


let callback2 =  function () {
    console.log("callBack2")
}