

const fileList = document.getElementById("fileList")
const addBtn = document.getElementById("addBtn")

let count = 0;
let max = 3
let param = 'files';

function setParam(p) {
    param=p;
}

function setMax(m) {
    max = m;
}


    addBtn.addEventListener("click", function() {
      

        if(count>=max) {
            alert("첨부파일은 최대" + max + "개까지만 가능합니다")
            return;
        }else {
            let d = document.createElement('div')
            let l = document.createElement('label')
            let t = document.createTextNode('Image')
            let i = document.createElement('input')
            let b = document.createElement('button')
            let t2 = document.createTextNode('X')
        
            //Element들의 조합
            d.appendChild(l)
            d.appendChild(i)
            l.appendChild(t)
            b.appendChild(t2)
            d.appendChild(b)
        
            //attritube 생성 적용
            //div
            let attr = document.createAttribute('class')
            attr.value='fw-bold fs-5 col-12 mt-3'
            d.setAttributeNode(attr)
        
            //label
            attr = document.createAttribute('class')
            attr.value='form-label'
            l.setAttributeNode(attr)
        
            attr = document.createAttribute('for')
            attr.value='files'
            l.setAttributeNode(attr)
        
            //input
            attr = document.createAttribute('class')
            attr.value='form-control'
            i.setAttributeNode(attr)
        
            attr = document.createAttribute('type')
            attr.value='file'
            i.setAttributeNode(attr)
        
            attr = document.createAttribute('id')
            attr.value='files'
            i.setAttributeNode(attr)
        
            attr = document.createAttribute('name')
            attr.value=param;
            i.setAttributeNode(attr)

            //button
            attr = document.createAttribute('type')
            attr.value = 'button'
            b.setAttributeNode(attr)

            attr = document.createAttribute('id')
            attr.value='delBtn'
            b.setAttributeNode(attr)

            attr = document.createAttribute("class")
            attr.value="btn btn-danger"
            b.setAttributeNode(attr)

            b.addEventListener("click",function() {
                d.remove();
                count--
            })
        
            //fileList내부에 div태그 넣어주기
            fileList.prepend(d);
            count++;

        
        }
       
    })

   
   
    


