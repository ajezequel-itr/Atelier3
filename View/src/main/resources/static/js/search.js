const urlParams = new URLSearchParams(window.location.search);
const id = urlParams.get('id');

async function load() {
	const response = await fetch("/card/"+id);
	const card = await response.json();
	const cardItem = cardTemplate.content.cloneNode(true);
	cardItem.querySelector(".card img").src = card.imgUrl;
	cardItem.querySelector(".card #name").textContent = card.name;
	cardItem.querySelector(".card #description").textContent = card.description;
	cardItem.querySelector(".card #superPowerName").textContent = card.superPowerName;
	cardItem.querySelector(".card #superPowerValue").textContent = card.superPowerValue;
	cardItem.querySelector(".card #hp").textContent = card.hp;
	cardItem.querySelector(".card #atk").textContent = card.atk;
	cardItem.querySelector(".card #def").textContent = card.def;
	cardItem.querySelector(".card #eng").textContent = card.eng;
	cardItem.querySelector(".card #value").textContent = card.value + "€";
	cardItem.querySelector(".card #cardBtn").textContent = card.onSale ? "BUY" : "NOT ON SALE";
	cardItem.querySelector(".card #cardBtn").setAttribute("data-id", card.id);
	cardContainer.appendChild(cardItem);
}