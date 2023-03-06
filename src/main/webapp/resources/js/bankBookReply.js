const replyAdd = document.getElementById("replyAdd")
const replyContents = document.getElementById("replyContents")
const commentListResult = document.getElementById("commentListResult")

const contentsConfirm = document.getElementById("contentsConfirm")
const closeModal = document.getElementById("closeModal")


replyAdd.addEventListener("click", function() {

    let xhttp = new XMLHttpRequest();

    xhttp.open("POST", "../bankBookComment/add")

    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded")

    xhttp.send("contents="+replyContents.value+"&bookNum="+replyAdd.getAttribute('data-book-bookNum'));

    xhttp.addEventListener("readystatechange", function() {
        if(this.readyState==4&&this.status==200) {
            if(this.responseText.trim()==1) {
                alert("댓글이 등록 되었습니다")
                replyContents.value=""
                getList();
            }else {
                alert("댓글 등록에 실패 했습니다")
            }
        }
    })
})


getList(1)


function getList(page) {
    let count=0;

    let xhttp = new XMLHttpRequest()

    xhttp.open("GET", "/bankBookComment/list?bookNum=" + replyAdd.getAttribute("data-book-bookNum") + "&page=" + page)

    xhttp.send()

    xhttp.addEventListener("readystatechange", function() {
        if(this.readyState==4&&this.status==200) {
            commentListResult.innerHTML = this.responseText.trim()
            console.log(this.responseText)
            count++
        }
    })
    //0이 출력 : 비동기 방식이기 때문
    console.log("count: " + count)
}

//page
commentListResult.addEventListener("click", function(e) {
    let pageLink = e.target;
    if(pageLink.classList.contains("page-link")) {
        let page =  pageLink.getAttribute("data-board-page")
        getList(page)

    }

    e.preventDefault()
})

//delete
commentListResult.addEventListener("click", function(e) {
    let del = e.target;
    if(del.classList.contains("del")) {
       let xhttp = new XMLHttpRequest()
       xhttp.open("POST", "../bankBookComment/delete")
       xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
       xhttp.send("num="+del.getAttribute("data-comment-num"))
        xhttp.addEventListener("readystatechange", function() {
            if(this.readyState ==4 && this.status==200) {
                let result = this.responseText.trim()
                if(result>0) {
                    alert("댓글이 삭제 되었습니다")
                    getList(1)
                }else {
                    alert("삭제 실패")
                }
            }
        })

    }

    e.preventDefault()
})

//update
commentListResult.addEventListener("click", function(e) {
    let updateButton = e.target;
    if(updateButton.classList.contains("update")) {
      //console.log(updateButton.parentNode.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling)
      let num = updateButton.getAttribute("data-comment-num") 
      let contents = document.getElementById("contents" + num) //td
    
      let contentsTextArea = document.getElementById("contents") //Modal textarea

      //value
      contentsTextArea.value=contents.innerText
      contentsConfirm.setAttribute("data-comment-num",num)
    }
    e.preventDefault()
})


//
contentsConfirm.addEventListener("click", function() {
    console.log("Update Post")
    let updateContents = document.getElementById("contents").value
    let num = contentsConfirm.getAttribute("data-comment-num")

    let xhttp = new XMLHttpRequest()
       xhttp.open("POST", "../bankBookComment/update")
       xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
       xhttp.send("num="+num+"&contents="+updateContents)
        xhttp.addEventListener("readystatechange", function() {
            if(this.readyState ==4 && this.status==200) {
                let result = this.responseText.trim()
                if(result>0) {
                    alert("수정 성공")
                    getList(1)
                }else {
                    alert("수정 실패")
                }
            }
        })
})

