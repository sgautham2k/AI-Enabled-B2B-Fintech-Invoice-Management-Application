var editmodal  = document.getElementById("modaledit");
var editbtn = document.getElementById("editrecbtn");
var editclsbtn = document.getElementById("editclsbtn");

editbtn.addEventListener('click', openeditModal);

editclsbtn.addEventListener('click', closeeditModal);

function openeditModal() {
    editmodal.style.display = 'block';
}

function closeeditModal() {
    editmodal.style.display = 'none';
}