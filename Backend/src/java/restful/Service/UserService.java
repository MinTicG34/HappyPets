
package restful.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import restful.Model.Conexion;
import restful.Model.UserModel;



public class UserService {
    //Clase para el servicio de consulta de todos los usuarios
    public ArrayList<UserModel> getUser() {
        ArrayList<UserModel> lista = new ArrayList<>();
        Conexion conn = new Conexion();
        String sql = "SELECT * FROM bd_user";

        try {
            Statement stm = conn.getCon().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                UserModel user = new UserModel();
                
                user.setLogin(rs.getString("login"));
                user.setId_usuario(rs.getInt("id_usuario"));
                user.setPerfil(rs.getInt("perfil"));
                user.setEstado(rs.getString("estado"));
                lista.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return lista;
    }
    
     //Clase para el servicio de consulta de un solo usuario
    public UserModel getUser(String id) {
        UserModel user = new UserModel();
        Conexion conex = new Conexion();
        String Sql = "SELECT * FROM bd_user WHERE login = ?";

        try {

            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setString(1, id);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                user.setLogin(rs.getString("login"));
                user.setId_usuario(rs.getInt("id_usuario"));
                user.setPerfil(rs.getInt("perfil"));
                user.setEstado(rs.getString("estado"));
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return user;
    }
    
    //Servicio para adicionar un usuario
    public UserModel addUser(UserModel user) {
        Conexion conex = new Conexion();
        String Sql = "INSERT INTO bd_user(login,id_usuario,perfil,estado)";
        Sql = Sql + "values (?,?,?,?)";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setString(1, user.getLogin());
            pstm.setInt(2, user.getId_usuario());
            pstm.setInt(3, user.getPerfil());
            pstm.setString(4, user.getEstado());
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        return user;
    }
    
    //Servicio de actualización de Usuarios
     public UserModel updateUser(UserModel user) {
        Conexion conn = new Conexion();
        String sql = "UPDATE bd_user SET id_usuario=?,perfil=?,estado=? WHERE login= ?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            
            pstm.setInt(1, user.getId_usuario());
            pstm.setInt(2, user.getPerfil());
            pstm.setString(3, user.getEstado());
            pstm.setString(4, user.getLogin());
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al actualizar  " + excepcion.getMessage());
            return null;
        }
        return user;
    }
     
     //Servicio para hecer la eliminación de usuario
     public String delUser(String login) {
        Conexion conn = new Conexion();

        String sql = "DELETE FROM bd_user WHERE login= ?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setString(1, login);
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al eliminar  " + excepcion.getMessage());
            return "{\"Accion\":\"Error\"}";
        }
        return "{\"Accion\":\"Usuario Borrado\"}";
    }
     
    
}
