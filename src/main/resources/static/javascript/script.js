var button = document.getElementById('button');
var lista = document.getElementsByClassName('nav-item');
console.log(lista);
var title = document.getElementById('title');

button.addEventListener("click", (evt) => {
    evt.preventDefault();
    title.innerText = "OwO"
    alert("hola")
})