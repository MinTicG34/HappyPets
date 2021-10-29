
package restful.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import restful.Model.Conexion;
import restful.Model.UsuariosModel;


public class UsuariosService {
    //Clase para el servicio de consulta de todos los usuarios
    public ArrayList<UsuariosModel> getUsuarios() {
        ArrayList<UsuariosModel> lista = new ArrayList<>();
        Conexion conn = new Conexion();
        String sql = "SELECT * FROM usuario";

        try {
            Statement stm = conn.getCon().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                UsuariosModel usuario = new UsuariosModel();
                
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setId_tercero(rs.getInt("id_tercero"));
                usuario.setFecha_creacion(rs.getTimestamp("fecha_creacion"));
                usuario.setFecha_retiro(rs.getTimestamp("fecha_retiro"));
                usuario.setEstado(rs.getString("estado"));
                usuario.setUsuario_creo(rs.getString("usuario_creo"));
                usuario.setUsuario_retiro(rs.getString("usuario_retiro"));
                lista.add(usuario);
            }
        } catch (SQLException e) {
        }

        return lista;
    }
    
     //Clase para el servicio de consulta de un solo usuario
    public UsuariosModel getUsuario(int id_usuario) {
        
        UsuariosModel usuario = new UsuariosModel();
        
        Conexion conex = new Conexion();
        String Sql = "SELECT * FROM usuario WHERE id_usuario = ?";

        try {

            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setInt(1, id_usuario);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                usuario.setId_usuario(rs.getInt("id_usuario"));
               usuario.setId_tercero(rs.getInt("id_tercero"));
                usuario.setFecha_creacion(rs.getTimestamp("fecha_creacion"));
                usuario.setFecha_retiro(rs.getTimestamp("fecha_retiro"));
                usuario.setEstado(rs.getString("estado"));
                usuario.setUsuario_creo(rs.getString("usuario_creo"));
                usuario.setUsuario_retiro(rs.getString("usuario_retiro"));
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return usuario;
    }
    
    //Servicio para adicionar un usuario
    public UsuariosModel addUsuarios(UsuariosModel usuario) {
        Conexion conex = new Conexion();
        String Sql = "INSERT INTO usuario(id_tercero,fecha_creacion,fecha_retiro,estado,usuario_creo,usuario_retiro)";
        Sql = Sql + "values (?,?,?,?,?,?)";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            //pstm.setInt(1, usuario.getId_usuario());
            pstm.setInt(1, usuario.getId_tercero());
            pstm.setTimestamp(2, usuario.getFecha_creacion());
            pstm.setTimestamp(3, usuario.getFecha_retiro());
            pstm.setString(4, usuario.getEstado());
            pstm.setString(5, usuario.getUsuario_creo());
            pstm.setString(6, usuario.getUsuario_retiro());
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        return usuario;
    }
    
    //Servicio de actualización de Usuarios
     public UsuariosModel updateUsuario(UsuariosModel usuario) {
        Conexion conn = new Conexion();
        String sql = "UPDATE usuario SET id_tercero=?,fecha_creacion=?,fecha_retiro=?,estado=?,usuario_creo=?, usuario_retiro=? WHERE id_usuario= ?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            
            pstm.setInt(1, usuario.getId_tercero());
            pstm.setTimestamp(2, usuario.getFecha_creacion());
            pstm.setTimestamp(3, usuario.getFecha_retiro());
            pstm.setString(4, usuario.getEstado());
            pstm.setString(5, usuario.getUsuario_creo());
            pstm.setString(6, usuario.getUsuario_retiro());
            pstm.setInt(7, usuario.getId_usuario());
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al actualizar  " + excepcion.getMessage());
            return null;
        }
        return usuario;
    }
     
     //Servicio para hecer la eliminación de usuario
     public String delUsuario(int id_usuario) {
        Conexion conn = new Conexion();

        String sql = "DELETE FROM usuario WHERE id_usuario= ?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setInt(1, id_usuario);
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al eliminar el usuario  " + excepcion.getMessage());
            return "{\"Accion\":\"Error\"}";
        }
        return "{\"Accion\":\"Usuario Borrado\"}";
    }
     
}
