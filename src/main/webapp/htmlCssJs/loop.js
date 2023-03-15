for(let i=0; i<5; i++) {
    console.log(i);
}

console.log("----------------")

let ar = [3,1,2];

//자바와 달리 배열도 추가할 수 있다
//새로운 길이가 들어감
let l = ar.push('abc')

for(let i=0; i<ar.length; i++) {
    console.log(ar[i])
}

console.log("-------------")
//삭제한 것을 반환
let e = ar.pop();
console.log(e)

console.log("----------")
//오름차순
ar.sort();

//내림차순
ar.reverse()

for(let i=0; i<ar.length; i++) {
    console.log(ar[i]);
}

window.console.log(ar.includes(5))

//화면 전체 -> window(부모)
//웹페이지가 보여지는 부분 -> documents(자식)
//url 있는 부분 -> location(자식)
//뒤로,앞으로 가기 부분 -> history(자식)
//웹브라우저의 정보 관리, 저장 -> nevigator(자식)
//화면에 대한 정보 관리 , 저장 -> screen(자식)

window.alert("hello");