
package restful.Model;


public class UserModel {
    private String login;
    private int id_usuario;
    private int perfil;
    private String estado;

    public UserModel() {
    }

    public UserModel(String login, int id_usuario, int perfil, String estado) {
        this.login = login;
        this.id_usuario = id_usuario;
        this.perfil = perfil;
        this.estado = estado;
    }

    public String getLogin() {
        return login;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public int getPerfil() {
        return perfil;
    }

    public String getEstado() {
        return estado;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
