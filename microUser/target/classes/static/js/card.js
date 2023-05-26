const cardTemplate = document.getElementById("cardTemplate");
const cardContainer = document.getElementById("cardContainer");

async function fetchCards(){
  const response = await fetch("/card");
  const cards = await response.json();
  for (let i = 0; i<cards.length; i++){
    const cardItem = cardTemplate.content.cloneNode(true);
    cardItem.querySelector(".card img").src = cards[i].imgUrl;
    cardItem.querySelector(".card #name").textContent = cards[i].name;
    cardItem.querySelector(".card #description").textContent = cards[i].description;
    cardItem.querySelector(".card #superPower").textContent = cards[i].superPowerName;
    cardItem.querySelector(".card #hp").textContent = cards[i].hp;
    //cardItem.querySelector(".card #cardBtn").textContent = cards[i].onSale ? "BUY" : "SEE";
    cardContainer.appendChild(cardItem);
  }
}

