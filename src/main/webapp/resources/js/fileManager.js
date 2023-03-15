

const fileList = document.getElementById("fileList")
//const addBtn = document.getElementById("addBtn")

let count = 0;
let max = 1
let param = 'files';
let idx = 0

function setParam(p) {
    param=p;
}

function setMax(m) {
    max = m;
}

function setCount(c) {
    count=c;
}

$(".deleteCheck").click(function() {
    if($(this).prop("checked")) {
       let result =  confirm("파일이 영구 삭제 됩니다")
        
       if(result) {
            count--;
       }else {
            $(this).prop("checked", false)
       }
        
    }else {
        count++
        if(count > max) {
            $("#f"+idx).remove()
            count--
            return;
        }
    }

})

// fileList.addEventListener("click",function(e) {
//     if(e.target.classList.contains('dels')) {
//         e.target.parentNode.remove()
//         // let id = e.target.getAttribute('data-dels-id')
//         // document.getElementById(id).remove()
//         count--;
//     }
// })


$("#fileList").on("click",".dels", function(e) {
    // let id = $(this).attr("data-dels-id")
    // $("#"+id).remove()
    $(this).parent().remove()
    count--

})

//funtion(){} => ()=>{}
$("#addBtn").click(()=> {
    if(count>=max) {
        alert("첨부파일은 최대" + max + "개까지만 가능합니다")
        return;
    }

    
    idx++

    let child = '<div class="fw-bold fs-5 col-12 mt-3" id="f'+idx+'">';
        child = child + '<input type="file" class="form-control" name="'+param+'">';
        child = child + '<button type="button" class="btn btn-danger dels" data-dels-id="f'+idx+'">X</button>'
    $("#fileList").append(child)
    count++;

});



    //addBtn.addEventListener("click", function() {
      

        // if(count>=max) {
        //     alert("첨부파일은 최대" + max + "개까지만 가능합니다")
        //     return;
        // }else {
        //     let d = document.createElement('div')
        //     let l = document.createElement('label')
        //    // let t = document.createTextNode('Image')
        //     let i = document.createElement('input')
        //     let b = document.createElement('button')
        //     let t2 = document.createTextNode('X')
        
        //     //Element들의 조합
        //     d.appendChild(l)
        //     d.appendChild(i)
        //     //l.appendChild(t)
        //     b.appendChild(t2)
        //     d.appendChild(b)
        
        //     //attritube 생성 적용
        //     //div
        //     let attr = document.createAttribute('class')
        //     attr.value='fw-bold fs-5 col-12 mt-3'
        //     d.setAttributeNode(attr)

        //     attr = document.createAttribute('id')
        //     attr.value = 'f' + idx
        //     d.setAttributeNode(attr)
            
            
        
        //     //label
        //     attr = document.createAttribute('class')
        //     attr.value='form-label'
        //     l.setAttributeNode(attr)
        
        //     attr = document.createAttribute('for')
        //     attr.value='files'
        //     l.setAttributeNode(attr)
        
        //     //input
        //     attr = document.createAttribute('class')
        //     attr.value='form-control'
        //     i.setAttributeNode(attr)
        
        //     attr = document.createAttribute('type')
        //     attr.value='file'
        //     i.setAttributeNode(attr)
        
        //     attr = document.createAttribute('id')
        //     attr.value='files'
        //     i.setAttributeNode(attr)
        
        //     attr = document.createAttribute('name')
        //     attr.value=param;
        //     i.setAttributeNode(attr)

        //     //button
        //     attr = document.createAttribute('type')
        //     attr.value = 'button'
        //     b.setAttributeNode(attr)

        //     attr = document.createAttribute("class")
        //     attr.value="btn btn-danger dels"
        //     b.setAttributeNode(attr)

        //     attr = document.createAttribute('data-dels-id')
        //     attr.value = 'f' + idx
        //     b.setAttributeNode(attr)

        //     // b.addEventListener("click",function() {
        //     //     d.remove();
        //     //     count--
        //     // })
        
        //     //fileList내부에 div태그 넣어주기
        //     idx++

        //     fileList.prepend(d);
        //     count++;

        
        // }
       
    //})

   
   
    


