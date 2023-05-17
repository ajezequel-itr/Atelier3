
var xhr = new XMLHttpRequest();
var url = "header.html";
xhr.open("GET", url, true);

xhr.onload = function() {
  if (xhr.status === 200) {
    var headerContent = xhr.responseText;
    var headerElement = document.getElementById("header");
    headerElement.innerHTML = headerContent;
  }
};
xhr.send();

function logout() {
  // Mettre à jour la variable du local storage
  localStorage.setItem('userId', '-1');

  // Rediriger l'utilisateur vers une autre page ou effectuer d'autres actions de déconnexion si nécessaire
  window.location.href = '/static/login.html'; 
}

  function loadAdd() {
	//Verif connection !!
	window.location.href = "addCard.html"
}

function loadBuy() {
	//Verif connection !!
	window.location.href = "browse.html"
}