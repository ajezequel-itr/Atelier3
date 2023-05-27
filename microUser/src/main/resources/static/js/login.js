
console.log("DEHORS")

const logBtn = document.querySelector('#userForm #login');
const regBtn = document.querySelector('#userForm #register');
const form = document.querySelector('#userForm');

logBtn.addEventListener('click', (event) => {
    event.preventDefault();
    console.log("DEDANS")
    const formData = new FormData(form);

    let user = {
        username: formData.get('username'),
        password: formData.get('password')
    };

	console.log(JSON.stringify(user))

    //Post Api
    let urlPost="/login"; 
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
            //const id = JSON.stringify(response);
			const id = response;
			console.log(response);
			console.log(id);
            localStorage.setItem("userId",id);
			window.location.href = "index.html"
        })
        .catch(error => err_callback(error));
});

function err_callback(error){
    console.log(error);
}


regBtn.addEventListener("click",(event)=>{
	event.preventDefault();
	const formData = new FormData(form);
	let user = {
        username: formData.get('username'),
        password: formData.get('password')
    };
    console.log(JSON.stringify(user));
	fetch('/register', {
        method: 'POST',
        headers: {

            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user) 
    })
    .then(response => response.json())
    .then(data => {
        //console.log(data.message);
		window.location.href = "index.html"
    })
    .catch(error => {
        console.error(error);
    });
})
