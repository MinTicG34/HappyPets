
package restful.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import restful.Model.Conexion;
import restful.Model.PerfilUsuarioModel;




public class PerfilUsuarioService {
    
      //Clase para el servicio de consulta de todos los Perfiles de usuarios
    public ArrayList<PerfilUsuarioModel> getPerfilUser() {
        ArrayList<PerfilUsuarioModel> lista = new ArrayList<>();
        Conexion conn = new Conexion();
        String sql = "SELECT * FROM perfil";

        try {
            Statement stm = conn.getCon().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                PerfilUsuarioModel perfil = new PerfilUsuarioModel();
                
                perfil.setId_perfil(rs.getInt("id_perfil"));
                perfil.setDescripcion(rs.getString("descripcion"));
               
                lista.add(perfil);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return lista;
    }
    
      //Clase para el servicio de consulta de un solo perfil de usuario
    public PerfilUsuarioModel getPerfilUser(int id) {
        PerfilUsuarioModel perfil = new PerfilUsuarioModel();
        Conexion conex = new Conexion();
        String Sql = "SELECT * FROM perfil WHERE id_perfil = ?";

        try {

            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

               perfil.setId_perfil(rs.getInt("id_perfil"));
               perfil.setDescripcion(rs.getString("descripcion"));
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return perfil;
    }
    
    
    //Servicio para adicionar un perfil de usuario
    public PerfilUsuarioModel addPerfil(PerfilUsuarioModel perfil) {
        Conexion conex = new Conexion();
        String Sql = "INSERT INTO perfil(id_perfil,descripcion)";
        Sql = Sql + "values (?,?)";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            
            pstm.setInt(1, perfil.getId_perfil());
            pstm.setString(2, perfil.getDescripcion());
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        return perfil;
    }
    
     //Servicio de actualización de perfil de Usuarios
     public PerfilUsuarioModel updatePerfil(PerfilUsuarioModel perfil) {
        Conexion conn = new Conexion();
        String sql = "UPDATE perfil SET descripcion=? WHERE id_perfil= ?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            
            pstm.setString(1, perfil.getDescripcion());
            pstm.setInt(2, perfil.getId_perfil());
            
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al actualizar  " + excepcion.getMessage());
            return null;
        }
        return perfil;
    }
    
    //Servicio para hecer la eliminación de perfil usuario
     public String delPerfil(int id) {
        Conexion conn = new Conexion();

        String sql = "DELETE FROM perfil WHERE id_perfil= ?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al eliminar  " + excepcion.getMessage());
            return "{\"Accion\":\"Error\"}";
        }
        return "{\"Accion\":\"Usuario Borrado\"}";
    } 
}
