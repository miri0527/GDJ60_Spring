const update = document.getElementById("update")
const delete2 = document.getElementById("delete")
const frm = document.getElementById("frm")

delete2.addEventListener("click", function() {
    //확인 : true, 취소: false
    
    let check =  window.confirm("정말 삭제하시겠습니까?");

    if(check ) {
        frm.setAttribute("action", "./delete")
        frm.setAttribute("method", "post")
        frm.submit();
    }
    
})

