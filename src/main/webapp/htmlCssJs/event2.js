const b1 = document.getElementById("b1") //button
const p1 = document.getElementById("p1") //div

const b2 = document.getElementById("b2") //button
const p2 = document.getElementById("p2") //div

const naver = document.getElementById("naver") //a

naver.addEventListener('click', function(event) {
    console.log("Naver Click")
    //링크 막기
    //event.preventDefault();
})


//캡처링과 중단
b1.addEventListener("click",function(e) {
    console.log('Button click')
    console.log(e)
}, true)

//부모 자식이 같은 event를 줬을 때
//true가 없으면 자식 -> 부모 순(버블링)
//true 부모 -> 자식(캡처링)
p1.addEventListener("click", function(event) {
    console.log("Div Click")
    console.log(event)
    event.stopPropagation();
},true)

//버블링과 중단
b2.addEventListener("click",function(e) {
    console.log('Button2 click')
    console.log(e)
    //e.stopPropagation();
    console.log("Button This", this)
},false)

//부모 자식이 같은 event를 줬을 때
//true가 없으면 자식 -> 부모 순(버블링)
//true 부모 -> 자식(캡처링)
p2.addEventListener("click", function(event) {
    console.log("Div2 Click")
    console.log(event)
    console.log("CurrentTarget : " + event.currentTarget);
    console.log("Target : " , event.target)
    console.log("This",this)
}, false)