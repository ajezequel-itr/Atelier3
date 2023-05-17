const userId = parseInt(localStorage.getItem("userId"));

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
  window.location.href = 'login.html';
}

  function loadAdd() {
	if (userId != -1){
		window.location.href = "addCard.html"
	}
	
}

function loadBuy() {
	if (userId != -1){
		window.location.href = "browse.html"
	}
}