
package restful.Model;

import java.sql.Timestamp;


public class UsuariosModel {
    private int id_usuario; //'Código de usuario, automático'
    private int id_tercero; //'codigo de tercero'
    private Timestamp fecha_creacion;
    private Timestamp fecha_retiro; //fecha retiro o inactivacipon de usuario
    private String estado; //'Activo/ Inactivo default A'
    private String usuario_creo;
    private String usuario_retiro;

    public UsuariosModel() {
    }

    public UsuariosModel(int id_usuario, int id_tercero, Timestamp fecha_creacion, Timestamp fecha_retiro, String estado, String usuario_creo, String usuario_retiro) {
        this.id_usuario = id_usuario;
        this.id_tercero = id_tercero;
        this.fecha_creacion = fecha_creacion;
        this.fecha_retiro = fecha_retiro;
        this.estado = estado;
        this.usuario_creo = usuario_creo;
        this.usuario_retiro = usuario_retiro;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public int getId_tercero() {
        return id_tercero;
    }

    public Timestamp getFecha_creacion() {
        return fecha_creacion;
    }

    public Timestamp getFecha_retiro() {
        return fecha_retiro;
    }

    public String getEstado() {
        return estado;
    }

    public String getUsuario_creo() {
        return usuario_creo;
    }

    public String getUsuario_retiro() {
        return usuario_retiro;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setId_tercero(int id_tercero) {
        this.id_tercero = id_tercero;
    }

    public void setFecha_creacion(Timestamp fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public void setFecha_retiro(Timestamp fecha_retiro) {
        this.fecha_retiro = fecha_retiro;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setUsuario_creo(String usuario_creo) {
        this.usuario_creo = usuario_creo;
    }

    public void setUsuario_retiro(String usuario_retiro) {
        this.usuario_retiro = usuario_retiro;
    }
  
   
}
