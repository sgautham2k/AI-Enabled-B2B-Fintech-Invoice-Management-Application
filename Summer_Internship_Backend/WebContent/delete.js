var deletemodal  = document.getElementById("modaldelete");
var deletebtn = document.getElementById("deleterecbtn");
var deleteclsbtn = document.getElementById("deleteclsbtn");

deletebtn.addEventListener('click', opendeleteModal);

deleteclsbtn.addEventListener('click', closedeleteModal);

function opendeleteModal() {
    deletemodal.style.display = 'block';
}

function closedeleteModal() {
    deletemodal.style.display = 'none';
}