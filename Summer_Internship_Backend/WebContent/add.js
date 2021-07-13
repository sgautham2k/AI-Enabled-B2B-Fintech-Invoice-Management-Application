var modal  = document.getElementById("modaladd");
var btn = document.getElementById("addrecbtn");
var clsbtn = document.getElementById("clsbtn");

btn.addEventListener('click', openModal);

clsbtn.addEventListener('click', closeModal);

function openModal() {
    modal.style.display = 'block';
}

function closeModal() {
    modal.style.display = 'none';
}