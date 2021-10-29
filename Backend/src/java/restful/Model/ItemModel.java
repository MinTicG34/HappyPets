
package restful.Model;
import java.sql.Timestamp;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ItemModel {
    private Timestamp fecha_creacion;
    private int tipo_articulo;
    private int unidad;
    private String codigo_item;
    private String descripcion;
    private String detalle;
    private String mascota;
    private String estado;
    private String usuario_creo;
    private float peso;
    private float Entradas;
    private float Salidas;
    private float Saldo;
    private float precio_venta;
    private int gravado;

    public ItemModel() {
    }

    public ItemModel(Timestamp fecha_creacion, int tipo_articulo, int unidad, String codigo_item, String descripcion, String detalle, String mascota, String estado, String usuario_creo, float peso, float Entradas, float Salidas, float Saldo, float precio_venta, int gravado) {
        this.fecha_creacion = fecha_creacion;
        this.tipo_articulo = tipo_articulo;
        this.unidad = unidad;
        this.codigo_item = codigo_item;
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.mascota = mascota;
        this.estado = estado;
        this.usuario_creo = usuario_creo;
        this.peso = peso;
        this.Entradas = Entradas;
        this.Salidas = Salidas;
        this.Saldo = Saldo;
        this.precio_venta = precio_venta;
        this.gravado = gravado;
    }

    public Timestamp getFecha_creacion() {
        return fecha_creacion;
    }

    public int getTipo_articulo() {
        return tipo_articulo;
    }

    public int getUnidad() {
        return unidad;
    }

    public String getCodigo_item() {
        return codigo_item;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDetalle() {
        return detalle;
    }

    public String getMascota() {
        return mascota;
    }

    public String getEstado() {
        return estado;
    }

    public String getUsuario_creo() {
        return usuario_creo;
    }

    public float getPeso() {
        return peso;
    }

    public float getEntradas() {
        return Entradas;
    }

    public float getSalidas() {
        return Salidas;
    }

    public float getSaldo() {
        return Saldo;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public int getGravado() {
        return gravado;
    }

    public void setFecha_creacion(Timestamp fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public void setTipo_articulo(int tipo_articulo) {
        this.tipo_articulo = tipo_articulo;
    }

    public void setUnidad(int unidad) {
        this.unidad = unidad;
    }

    public void setCodigo_item(String codigo_item) {
        this.codigo_item = codigo_item;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setUsuario_creo(String usuario_creo) {
        this.usuario_creo = usuario_creo;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setEntradas(float Entradas) {
        this.Entradas = Entradas;
    }

    public void setSalidas(float Salidas) {
        this.Salidas = Salidas;
    }

    public void setSaldo(float Saldo) {
        this.Saldo = Saldo;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }

    public void setGravado(int gravado) {
        this.gravado = gravado;
    }

   
    
}


