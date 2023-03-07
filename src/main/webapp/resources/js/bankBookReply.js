//const replyAdd = document.getElementById("replyAdd")
//const replyContents = document.getElementById("replyContents")
//const commentListResult = document.getElementById("commentListResult")

const contentsConfirm = document.getElementById("contentsConfirm")
const closeModal = document.getElementById("closeModal")


//댓글 등록
//replyAdd.addEventListener("click", function() {
    $("#replyAdd").click(() => {

    //JS에서 사용할 가상의 Form 태그 생성
    const form = new FormData() //<form></form>
    //form.append("contents", replyContents.value) //<form><input type="text" name="contents" value="dfds"></form>
    //form.append("bookNum",replyAdd.getAttribute('data-book-bookNum')) 
    form.append("contents",$("#replyContents").val())
    form.append("bookNum",$("#replyAdd").attr("data-book-bookNum"))


    fetch('../bankBookComment/add',{
        method:'POST',
        //headers:{},
        body: form,
    }).then((response)=> response.text())
    .then((res)=> {
        if(res.trim()==1) {
            alert("댓글이 등록 되었습니다")
            $("#replyContents").val("")
            getList(1);
        }else {
            alert("댓글 등록에 실패 했습니다")
        }
    }).catch(() =>  {
        console.log("error 발생")
    })

    // let xhttp = new XMLHttpRequest();

    // xhttp.open("POST", "../bankBookComment/add")

    // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded")

    // xhttp.send("contents="+replyContents.value+"&bookNum="+replyAdd.getAttribute('data-book-bookNum'));

    // xhttp.addEventListener("readystatechange", function() {
    //     if(this.readyState==4&&this.status==200) {
    //         if(this.responseText.trim()==1) {
    //             alert("댓글이 등록 되었습니다")
    //             replyContents.value=""
    //             getList();
    //         }else {
    //             alert("댓글 등록에 실패 했습니다")
    //         }
    //     }
    // })
    

    })


//list
getList(1)


function getList(page) {
    let count=0;

    fetch( "/bankBookComment/list?bookNum="+replyAdd.getAttribute("data-book-bookNum")+"&page="+page,{
        method : 'GET'
        //GET과 HEAD 메서드는 body 속성을 가질 수 없다
    }).then((response)=> response.text())
        .then((res) => {
            $("#commentListResult").html(res.trim())
        })

    // let xhttp = new XMLHttpRequest()

    // xhttp.open("GET", "/bankBookComment/list?bookNum=" + replyAdd.getAttribute("data-book-bookNum") + "&page=" + page)

    // xhttp.send()

    // xhttp.addEventListener("readystatechange", function() {
    //     if(this.readyState==4&&this.status==200) {
    //         commentListResult.innerHTML = this.responseText.trim()
    //         console.log(this.responseText)
    //         count++
    //     }
    // })
    //0이 출력 : 비동기 방식이기 때문
    //console.log("count: " + count)
}

//page
$("#commentListResult").on("click", ".page-link",function(e) {

    let page =  $(this).attr("data-board-page")
    getList(page)

    e.preventDefault()
})

//delete
$("#commentListResult").on("click", ".del",function(e) {

    fetch( "../bankBookComment/delete", {
            method : 'POST',
            headers: {
                "Content-type": "application/x-www-form-urlencoded"
            },
            body:"num="+$(this).attr("data-comment-num")
            //응답객체에서 Data 추출
        }).then((response) => response.text()) //response.text()를 return
            //추출한 Data 사용
          .then((res)=> {
            if(res.trim() > 0) {
                alert("댓글이 삭제 되었습니다")
                getList(1)
            }else {
                alert("삭제 실패")
            }
          }).catch(() => {
            alert("삭제 실패")
          })
        
    //    let xhttp = new XMLHttpRequest()
    //    xhttp.open("POST", "../bankBookComment/delete")
    //    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
    //    xhttp.send("num="+del.getAttribute("data-comment-num"))
    //     xhttp.addEventListener("readystatechange", function() {
    //         if(this.readyState ==4 && this.status==200) {
    //             let result = this.responseText.trim()
    //             if(result>0) {
    //                 alert("댓글이 삭제 되었습니다")
    //                 getList(1)
    //             }else {
    //                 alert("삭제 실패")
    //             }
    //         }
    //     })


    e.preventDefault()
})

//update
$("#commentListResult").on("click", ".update",function(e){
        
        let num = $(this).attr("data-comment-num");
        let contents = document.getElementById("contents" + num)//td
        console.log(contents);
        let contentsTextArea=document.getElementById("contents")//Modal textarea
        console.log(contentsTextArea);
        //value
        $("#contents").val($("#contents"+num)).text;
        $("#contentsConfirm").attr("data-comment-num", num);
    
    
    e.preventDefault();
    
});


//
$("#contentsConfirm").click(() => {

    console.log("Update Post");
    let updateContents = $("#contents").val();
    let num = $("contentsConfirm").attr("data-comment-num");

    fetch("../bankBookComment/update", {
        method : 'POST',
        headers : {
            "Content-type": "application/x-www-form-urlencoded"
        },
        body : "num="+num+"&contents="+updateContents
    }).then((response) => response.text())
        .then((res) => {
            if(res.trim() > 0) {
                alert("수정 성공")
                closeModal.click()
                getList(1)
            }else {
                alert("수정 실패")
            }
        }).catch(() => {
            alert("수정 실패")
        }) 

        

    // let xhttp = new XMLHttpRequest();
    // xhttp.open("POST", "../bankBookComment/update");
    // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    // xhttp.send("num="+num+"&contents="+updateContents);
    // xhttp.addEventListener("readystatechange", function(){
    //     if(this.readyState==4&&this.status==200){
    //         let result = this.responseText.trim();
    //         if(result>0){
    //             alert('수정 성공');
    //             closeModal.click();
    //             getList(1);
    //         }else {
    //             alert('삭제 실패');
    //         }
            
    //     }        
    // });
  
})


//Test 후 삭제할 영역
    //1. 선택
    //const b1= document.getElementById("b1")
    //const b1 = document.querySelector("#b1")
    //b1.addEventListener('click',funtion(){})

    //Jquery
    // $('#b1').click(() =>{
    //     let v=$('#t1').val()
    //     console.log(v)
    // })

    // $("#t1").blur(()=> {
    //     console.log("blur")
    // })

     //하나의 input태그에 여러 이벤트를 걸고 싶을 때 사용
    // $("#t1").on( {
    //     click:function() {
    //         console.log("t1 click")
    //     },
    //     blur:()=>{
    //         console.log("t1 blur")
    //     }
    // })

   
    // $("#b1").on("click", function(){})

    // $("#commentListResult").on("click", ".update", function(){})

    // const ch= document.getElementsByClassName("ch")
    // for(let c of ch) {
    //     c.addEventListener("click", function() {})
    // }

    //반복문 안돌려도 이벤트가 하나 씩 걸림
    //화살표 함수에 this는 Window 객체를 가리키고
    //일반 콜백함수의 this는 자기 자신을 가리킨다
    //화살표 함수로 쓰려면 this가 아닌 e.target을 써야한다
    // $(".ch").click((e) =>{
    //     console.log("E: " + e)
    //     console.log(e.target) //javascript
    //     console.log($(e.target).val()) //jQuery

    // })

////////////////////