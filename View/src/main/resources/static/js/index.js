const cardTemplate = document.getElementById("cardTemplate");
const cardContainer = document.getElementById("cardContainer");

const urlParams = new URLSearchParams(window.location.search);
const cardName = urlParams.get('search');

async function load() {
  if (cardName){ //Find by name
  	console.log("LOAD CARD" + cardName)
    const response = await fetch("127.0.0.1:8888/card");
    const cards = await response.json();
    for (let i = 0; i<cards.length; i++){
      if (cards[i].name.startsWith(cardName)){
        const cardItem = cardTemplate.content.cloneNode(true);
        cardItem.querySelector(".card img").src = cards[i].imgUrl;
        cardItem.querySelector(".card #name").textContent = cards[i].name;
        //cardItem.querySelector(".card #description").textContent = cards[i].description;
        cardItem.querySelector(".card #superPower").textContent = cards[i].superPowerName;
        cardItem.querySelector(".card #hp").textContent = cards[i].hp;
        //cardItem.querySelector(".card #cardBtn").textContent = cards[i].onSale ? "BUY" : "SEE";
        cardItem.querySelector(".card #cardBtn").setAttribute("data-id", cards[i].id);
        cardContainer.appendChild(cardItem);
      }
    }
  } else { //Get all
    const response = await fetch("127.0.0.1:8888/card");
    const cards = await response.json();
    for (let i = 0; i<cards.length; i++){
      const cardItem = cardTemplate.content.cloneNode(true);
      cardItem.querySelector(".card img").src = cards[i].imgUrl;
      cardItem.querySelector(".card #name").textContent = cards[i].name;
      //cardItem.querySelector(".card #description").textContent = cards[i].description;
      cardItem.querySelector(".card #superPower").textContent = cards[i].superPowerName;
      cardItem.querySelector(".card #hp").textContent = cards[i].hp;
      //cardItem.querySelector(".card #cardBtn").textContent = cards[i].onSale ? "BUY" : "SEE";
      cardItem.querySelector(".card #cardBtn").setAttribute("data-id", cards[i].id);
      cardContainer.appendChild(cardItem);
    }
  }
	const cardBtns = document.querySelectorAll(".card #cardBtn");
	console.log(cardBtns);
	
	cardBtns.forEach((btn) => {
	  btn.addEventListener("click", () => {
	    const cardId = btn.getAttribute("data-id");
	    console.log("CLICK");
	    window.location.href = "/search.html?id="+cardId;
	  });
	});
}