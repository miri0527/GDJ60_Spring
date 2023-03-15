const btn = document.getElementById("btn")
const r1 = document.getElementById("r1")
const c1 = document.getElementById("c1")
const t1 = document.getElementById("t1")

let result="";
btn.addEventListener("click", function() {
    for(let i=0; i<c1.value; i++) {
        result = result + "<tr>"
        for(let j=0; j<r1.value; j++) {
            result = result + "<td>"
            result = result + "</td>"
        }
        result = result + "</tr>"
    }
    t1.innerHTML = result;
})

const s1 = document.getElementById("s1")
const options = document.getElementsByClassName("options")
s1.addEventListener("click", function() {
    for(let i=0; i<options.length; i++) {
        if(options[i].selected) {
            console.log(options[i].value)
        }
    }
})

const s2 = document.getElementById("s2")
const radios = document.getElementsByClassName("radios")

s2.addEventListener("click", function() {
    for(let i=0; i<radios.length; i++) {
        if(radios[i].checked) {
            console.log(radios[i].value)
        }
    }
})

const ch = document.getElementsByClassName("ch")
const r2 = document.getElementsByName("r2")

for(let i=0; i<ch.length; i++) {
    ch[i].addEventListener("click", function() {
        for(let j=0; j<ch.length; j++) {
            ch[j].checked = this.checked
        }
    })
}
