//Definición de variables, url del proyecto
const url = 'http://localhost:8080/WebAppHappypets/api/usuarios'
const contenedor = document.querySelector('tbody')
let resultados = ""

//Para el modal(ir a la página de bootstrap)
const modalusuarios = new bootstrap.Modal(document.getElementById('modalusuarios'));

//referencial el formulario
const formusuarios = document.querySelector('form')
//referenciar los datos del formulario
const id_usuario = document.getElementById('id_usuario')
const id_tercero = document.getElementById('id_tercero')
const fecha_creacion = document.getElementById('fecha_creacion')
const fecha_retiro = document.getElementById('fecha_retiro')
const estado = document.getElementById('estado')
const usuario_creo = document.getElementById('usuario_creo')
const usuario_retiro = document.getElementById('usuario_retiro')
//variable al momento de guardar
let opcion = ''

//---------------------------------------------
fecha = () => {
    let f = new Date()
    let fecha = f.toUTCString()
    return fecha
}
//----------------------------------------------
//acciones del botón crear:
btnCrear.addEventListener('click', () => {
    modalusuarios.show()
    id_usuario.value = ''
    id_tercero.value = ''
    fecha_creacion.value = fecha()
    fecha_retiro.value = ''
    estado.value = ''
    usuario_creo.value = ''
    usuario_retiro.value = 'ADMIN'
    opcion = 'crear'
})

//funcion para mostrar
const mostrar = (users) => {
    users.forEach(user => {
        resultados += `<tr>
                    <td>${user.id_usuario}</td>
                    <td>${user.id_tercero}</td>
                    <td>${user.fecha_creacion}</td>
                    <td>${user.fecha_retiro}</td>
                    <td>${user.estado}</td>
                    <td>${user.usuario_creo}</td>
                    <td>${user.usuario_retiro}</td>
                    <td class="text-center"><a class="btnEditar btn btn-primary">Editar</a><a class="btnBorrar btn btn-danger">Borrar</a></td>          
                        </tr>`
    })
    contenedor.innerHTML = resultados
}

//procedimiento para mostrar
fetch(url)
    .then(response => response.json())
    .then(data => mostrar(data))
    .catch(error => console.log(error))

//------------------------------------------------
const on = (element, event, selector, handler) => {
    element.addEventListener(event, e => {
        if (e.target.closest(selector)) {
            handler(e)
        }
    })
}
//-----------------------------------------------
//Procedimiento para borrar
on(document, 'click', '.btnBorrar', e => {
    const fila = e.target.parentNode.parentNode
    const id = fila.firstElementChild.innerHTML
    alertify.confirm(`Seguro desea borrar el artículo id: ${id}`,
        () => {
            fetch(url + "/" + id, {
                method: 'DELETE'
            })
                .then(res => res.json())
                .then(() => location.reload())

            alertify.success(`Borrado artículo id: ${id}`)
        },
        () => {
            alertify.error('Acción Cancelada')
        })
})

//----------------------------------------------
//procedimiento para editar
let idForm = 0
on(document, 'click', '.btnEditar', e => {
    modalusuarios.show()
    const fila = e.target.parentNode.parentNode
    idForm = fila.children[0].innerHTML
    const id_tercerform = fila.children[1].innerHTML
    const fecha_creacionform = fila.children[2].innerHTML
    const fecha_retiroform = fila.children[3].innerHTML
    const estadoform = fila.children[4].innerHTML
    const usuario_creoform = fila.children[5].innerHTML
    const usuario_retiroform = fila.children[6].innerHTML
    id_usuario.value = idForm
    id_tercero.value = id_tercerform
    fecha_creacion.value = fecha_creacionform
    fecha_retiro.value = fecha_retiroform
    estado.value = estadoform
    usuario_creo.value = usuario_creoform
    usuario_retiro.value = usuario_retiroform
    //console.log(usuario_creo.value)
    opcion = 'editar'

})
//------------------------------------------------
//procedimiento para crear o editar
formusuarios.addEventListener('submit', (e) => {
    e.preventDefault()
    if (opcion == 'crear') {
        let f = new Date()

        fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                //id_usuario: id_usuario.value,
                id_tercero: id_tercero.value,
                fecha_creacion: f.toISOString(),
                //fecha_retiro: fecha_retiro.value,
                estado: estado.value,
                usuario_creo: usuario_creo.value,
                //usuario_retiro: usuario_retiro.value
            })
        })
        .then(response => response.json())
        .then(response => location.reload())
    }
    if (opcion == 'editar') {
        let f = new Date()
        fetch(url, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },

            body: JSON.stringify({
                id_usuario: id_usuario.value,
                id_tercero: id_tercero.value,
                fecha_creacion: f.toISOString(),
                //fecha_retiro: fecha_retiro.value,
                estado: estado.value,
                usuario_creo: usuario_creo.value,
                //usuario_retiro: usuario_retiro.value
            })
        })
            .then(response => response.json())
            .then(response => location.reload())
       
    }
    modalusuarios.hide()
})