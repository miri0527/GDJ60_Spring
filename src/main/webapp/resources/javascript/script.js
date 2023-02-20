const checkAll = document.getElementById("checkAll")
const checks = document.getElementsByClassName("checks")

checkAll.addEventListener("click", function() {
    for(let i=0; i<checks.length; i++) {
        checks[i].checked = checkAll.checked
    }
})
