const form = document.getElementById("cardForm");

form.addEventListener("submit", async (event) => {
    event.preventDefault();
    const formData = new FormData(form);
    const data = {};
    formData.forEach((value, key) => data[key] = value); //Format formData for JSON Stringify
    console.log(JSON.stringify(data));
    const response = await fetch("/card", {
        method: 'POST',
        headers: {'Content-Type': "application/json"},
        body: JSON.stringify(data)
    });

    if (response.ok) {
        //const jsonResponse = await response.json();
        console.log("Successfully added card");
    } else {
        console.error('Erreur : ${response.status} : ${response.statusText}');
    }
});