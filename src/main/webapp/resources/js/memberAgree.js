const checkAll = document.getElementById("checkAll")
const checks = document.getElementsByClassName("checks")

checkAll.addEventListener("click", function() {
    for(let i=0; i<checks.length; i++) {
        checks[i].checked = checkAll.checked
    }
});

for(let i=0; i<checks.length; i++) {
    checks[i].addEventListener("click", function() {
        let result = true;
        for(let j=0; j<checks.length; j++) {
            if(!checks[j].checked) {
                //result = chekcs[j].checked;
                result = false;
                break;
            } 
        }

        checkAll.checked = result;

    });
}

const agree = document.getElementById("agree")
agree.addEventListener("click", function() {
    if(checkAll.checked == false) {
        alert("모든 약관에 동의해야합니다")
    }else {
        //alert("모두 동의함")
        location.href = "./memberAdd"
    }
})