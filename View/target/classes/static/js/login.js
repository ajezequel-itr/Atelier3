
console.log("DEHORS")

const form = document.querySelector('#userForm');

form.addEventListener('submit', (event) => {
    event.preventDefault();
    console.log("DEDANS")
    const formData = new FormData(form);

    let user = {
        name: formData.get('username'),
        password: formData.get('password')
    };

    //Post Api
    let urlPost="127.0.0.1:8080/user"; 
    let context =   {
                        method: 'POST',
                        headers: {
                            //'Accept': '*/*',
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify(user)
                    };
        
    fetch(urlPost,context)
        .then(response => response.json())
        .then(response => {
            const id = JSON.stringify(response);
            localStorage.setItem("userId",id)

        })
        .catch(error => err_callback(error));
});

function err_callback(error){
    console.log(error);
}
