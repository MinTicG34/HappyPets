//Definición de variables, url del proyecto
const url = 'http://localhost:8080/WebAppHappypets/api/item'
const contenedor = document.querySelector('tbody')
let resultados = ""

//Para el modal(ir a la página de bootstrap)
const modalItem = new bootstrap.Modal(document.getElementById('modalItem'));

//referencial el formulario
const forItem = document.querySelector('form')
//referenciar los datos del formulario
const codigo_item = document.getElementById('codigo_item')
const descripcion = document.getElementById('descripcion')
const detalle = document.getElementById('detalle')
const tipo_articulo = document.getElementById('tipo_articulo')
const mascota = document.getElementById('mascota')
const unidad = document.getElementById('unidad')
const gravado = document.getElementById('gravado')
const fecha_creacion = document.getElementById('fecha_creacion')
const peso = document.getElementById('peso')
const precio_venta = document.getElementById('precio_venta')
const estado = document.getElementById('estado')
const usuario_creo = document.getElementById('usuario_creo')
const entradas = document.getElementById('entradas')
const salidas = document.getElementById('salidas')
const saldo = document.getElementById('saldo')
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
    codigo_item.value = ''
    descripcion.value = ''
    detalle.value = ''
    tipo_articulo.value = ''
    mascota.value = ''
    unidad.value = ''
    gravado.value = ''
    fecha_creacion.value = fecha()
    peso.value = ''
    precio_venta.value = ''
    estado.value = ''
    usuario_creo.value = ''
    entradas.value = ''
    salidas.value = ''
    saldo.value = ''
    modalItem.show()
    opcion = 'crear'
})

//funcion para mostrar
const mostrar = (items) => {
    items.forEach(item => {
        resultados += `<tr>
                    <td>${item.codigo_item}</td>
                    <td>${item.descripcion}</td>
                    <td>${item.detalle}</td>
                    <td>${item.tipo_articulo}</td>
                    <td>${item.mascota}</td>
                    <td>${item.unidad}</td>
                    <td>${item.gravado}</td>
                    <td>${item.fecha_creacion}</td>
                    <td>${item.peso}</td>
                    <td>${item.precio_venta}</td>
                    <td>${item.estado}</td>
                    <td>${item.usuario_creo}</td>
                    <td>${item.entradas}</td>
                    <td>${item.salidas}</td>
                    <td>${item.saldo}</td>
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
    const fila = e.target.parentNode.parentNode
    idForm = fila.children[0].innerHTML
    const descripcionform = fila.children[1].innerHTML
    const detalleform = fila.children[2].innerHTML
    const tipo_articuloform = fila.children[3].innerHTML
    const mascotaform = fila.children[4].innerHTML
    const unidadform = fila.children[5].innerHTML
    const gravadoform = fila.children[6].innerHTML
    const fecha_creacionform = fila.children[7].innerHTML
    const pesoform = fila.children[8].innerHTML
    const precio_ventaform = fila.children[9].innerHTML
    const estadoform = fila.children[10].innerHTML
    const usuario_creoform = fila.children[11].innerHTML
    const entradasform = fila.children[12].innerHTML
    const salidaform = fila.children[13].innerHTML
    const saldoform = fila.children[14].innerHTML
    codigo_item.value = idForm
    descripcion.value = descripcionform
    detalle.value = detalleform
    tipo_articulo.value = tipo_articuloform
    mascota.value = mascotaform
    unidad.value = unidadform
    gravado.value = gravadoform
    fecha_creacion.value = fecha_creacionform
    peso.value = pesoform
    precio_venta.value = precio_ventaform
    estado.value = estadoform
    usuario_creo.value = usuario_creoform
    entradas.value = entradasform
    salidas.value = salidaform
    saldo.value = saldoform
    opcion = 'editar'
    modalItem.show()
})
//------------------------------------------------
//procedimiento para crear o editar
forItem.addEventListener('submit', (e) => {
    e.preventDefault()
    if (opcion == 'crear') {
        let f = new Date()

        fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                codigo_item: codigo_item.value,
                descripcion: descripcion.value,
                detalle: detalle.value,
                tipo_articulo: tipo_articulo.value,
                mascota: mascota.value,
                unidad: unidad.value,
                gravado: gravado.value,
                fecha_creacion: f.toISOString(),
                peso: peso.value,
                precio_venta: precio_venta.value,
                estado: estado.value,
                usuario_creo: usuario_creo.value,
                entradas: entradas.value,
                salidas: salidas.value,
                saldo: saldo.value
            })
        })
            .then(re => re.json())
            .then(data => {
                const nuevoItem = []
                nuevoItem.push(data)

                mostrar(nuevoItem)
            })
    }
    if (opcion == 'editar') {
        let f = new Date()
        fetch(url, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                codigo_item: codigo_item.value,
                descripcion: descripcion.value,
                detalle: detalle.value,
                tipo_articulo: tipo_articulo.value,
                mascota: mascota.value,
                unidad: unidad.value,
                gravado: gravado.value,
                fecha_creacion: f.toISOString(),
                peso: peso.value,
                precio_venta: precio_venta.value,
                estado: estado.value,
                usuario_creo: usuario_creo.value,
                entradas: entradas.value,
                salidas: salidas.value,
                saldo: saldo.value
            })
        })
            .then(response => response.json())
            .then(response => location.reload())
        //console.log(f.toISOString())
    }
    modalItem.hide()
})