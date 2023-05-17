async function load() {
	const response = await fetch("/card");
	const cards = await response.json();
	let tbody = document.querySelector("#cardBody");
	for (let card of cards) {
		if (card.onSale){
			let tr = document.createElement("tr");
			let tdTitre = document.createElement("td");
			let tdDescription = document.createElement("td");
			let tdOwnerId = document.createElement("td");
			tdTitre.textContent = card.name;
			tdDescription.textContent = card.value+" €";
			tdOwnerId.textContent = card.ownerId;
			tr.appendChild(tdTitre);
			tr.appendChild(tdDescription);
			tr.appendChild(tdOwnerId);
			tr.addEventListener("click", async () => {
				console.log("ClICK");
				let data = {
					idCard: card.id,
					idBuyer: 1
				}
				const response = await fetch("/buy", {
				    method: 'POST',
				    headers: {'Content-Type': "application/json"},
				    body: JSON.stringify(data)
				});
				if (response.ok) {
				    //const jsonResponse = await response.json();
				    console.log("Successfully bought");
				} else {
				    console.error('Erreur : ${response.status} : ${response.statusText}');
				}
			});
			tbody.appendChild(tr);
		}
	}
}