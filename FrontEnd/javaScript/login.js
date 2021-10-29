const url = 'http://localhost:8080/WebAppHappypets/api/user'

let log = document.getElementById('log');
let overLay = document.getElementById('overLay');
let popUp = document.getElementById('popUp');
let cerrarPop = document.getElementById('btnCerrarPopup');
let btnSubmit = document.getElementById('btnSubmit');
const usuario = document.getElementById('user');
let clave = document.getElementById('pass');
let form = document.getElementById('formulario');
const usuariosbd = []

//acciones del botón registrarme
log.addEventListener('click', () => {
    overLay.classList.add('active')
    popUp.classList.add('active')
})
//__________________________________________
//acciones del botón cerrar en el overlay
cerrarPop.addEventListener('click', () => {
    overLay.classList.remove('active')
    popUp.classList.remove('active')
})
//----------------------------------------------
//acciones del botón entrar
form.addEventListener('submit', (e) => {
    e.preventDefault()
    if (usuario.value.length < 1) {
        alert('Usuario debe tener más de 6 dígitos.')
    } else {

        // traer de bd
        fetch(url)
            .then(response => response.json())
            .then(data => {
                const datos = []
                datos.push(data)
                for (let dato of datos) {
                    for (let items of dato) {
                        if (items.id_usuario == usuario.value) {
                            if (items.login == clave.value) {
                                console.log(window.location.href)
                                window.location.href = "productos.html"
                            }
                        }
                    }
                }
                alert('credenciales inválidas.')
            })

    }
})



