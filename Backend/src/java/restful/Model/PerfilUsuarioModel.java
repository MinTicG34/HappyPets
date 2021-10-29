
package restful.Model;


public class PerfilUsuarioModel {
 private int id_perfil;
 private String descripcion;

    public PerfilUsuarioModel() {
    }

    public PerfilUsuarioModel(int id_perfil, String descripcion) {
        this.id_perfil = id_perfil;
        this.descripcion = descripcion;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
 
 
 
 
 
 
}
