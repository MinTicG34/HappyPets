package restful.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import restful.Model.Conexion;
import restful.Model.ItemModel;

public class ItemService {
    //Clase para el servicio de consulta de todos los usuarios
    public ArrayList<ItemModel> getItems() {
        ArrayList<ItemModel> lista = new ArrayList<>();
        Conexion conn = new Conexion();
        String sql = "SELECT * FROM items";

        try {
            Statement stm = conn.getCon().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ItemModel item = new ItemModel();
                
                item.setFecha_creacion(rs.getTimestamp("fecha_creacion"));
                item.setCodigo_item(rs.getString("codigo_item"));
                item.setTipo_articulo(rs.getInt("tipo_articulo"));
                item.setUnidad(rs.getInt("unidad"));
                item.setCodigo_item(rs.getString("codigo_item"));
                item.setDescripcion(rs.getString("descripcion"));
                item.setDetalle(rs.getString("detalle"));
                item.setMascota(rs.getString("mascota"));
                item.setEstado(rs.getString("estado"));
                item.setUsuario_creo(rs.getString("usuario_creo"));
                item.setPeso(rs.getFloat("peso"));
                item.setEntradas(rs.getFloat("Entradas"));
                item.setSalidas(rs.getFloat("Salidas"));
                item.setSaldo(rs.getFloat("Saldo"));
                item.setPrecio_venta(rs.getFloat("precio_venta"));
                item.setGravado(rs.getInt("gravado"));
                
                lista.add(item);
            }
        } catch (SQLException e) {
             System.out.println(e);
        }

        return lista;
    } 
    
            //Servicio de consulta de un item
    public ItemModel getItem(String codigo_item) {
        ItemModel item = new ItemModel();
        Conexion conex = new Conexion();
        String Sql = "SELECT * FROM items WHERE codigo_item = ?";

        try {

            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setString(1, codigo_item);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                
                item.setFecha_creacion(rs.getTimestamp("fecha_creacion"));
                item.setCodigo_item(rs.getString("codigo_item"));
                item.setTipo_articulo(rs.getInt("tipo_articulo"));
                item.setUnidad(rs.getInt("unidad"));
                item.setCodigo_item(rs.getString("codigo_item"));
                item.setDescripcion(rs.getString("descripcion"));
                item.setDetalle(rs.getString("detalle"));
                item.setMascota(rs.getString("mascota"));
                item.setEstado(rs.getString("estado"));
                item.setUsuario_creo(rs.getString("usuario_creo"));
                item.setPeso(rs.getFloat("peso"));
                item.setEntradas(rs.getFloat("Entradas"));
                item.setSalidas(rs.getFloat("Salidas"));
                item.setSaldo(rs.getFloat("Saldo"));
                item.setPrecio_venta(rs.getFloat("precio_venta"));
                item.setGravado(rs.getInt("gravado"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return item;
    }
    
    //Servicio para adicionar un item
    public ItemModel addItem(ItemModel item) {
        Conexion conex = new Conexion();
        String Sql = "INSERT INTO items(codigo_item,descripcion,detalle,tipo_articulo,mascota,unidad,gravado,fecha_creacion,peso,precio_venta,estado,usuario_creo,Entradas,Salidas,Saldo)";
        Sql = Sql + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setString(1, item.getCodigo_item());
            pstm.setString(2, item.getDescripcion());
            pstm.setString(3, item.getDetalle());
            pstm.setInt(4, item.getTipo_articulo());
            pstm.setString(5, item.getMascota());
            pstm.setInt(6, item.getUnidad());
            pstm.setInt(7, item.getGravado());
            pstm.setTimestamp(8, item.getFecha_creacion());
            pstm.setFloat(9, item.getPeso());
            pstm.setFloat(10, item.getPrecio_venta());
            pstm.setString(11, item.getEstado());
            pstm.setString(12, item.getUsuario_creo());
            pstm.setFloat(13, item.getEntradas());
            pstm.setFloat(14, item.getSalidas());
            pstm.setFloat(15, item.getSaldo());
            
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        return item;
    }
    
    //Servicio de actualización de items
     public ItemModel updateItem(ItemModel item){
        Conexion conn = new Conexion();
        String sql = "UPDATE items SET descripcion=?,detalle=?,tipo_articulo=?,mascota=?,unidad=?,gravado=?,fecha_creacion=?,peso=?,precio_venta=?,estado=?,usuario_creo=?,Entradas=?,Salidas=?,Saldo=? WHERE codigo_item= ?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
           
            pstm.setString(1, item.getDescripcion());
            pstm.setString(2, item.getDetalle());
            pstm.setInt(3, item.getTipo_articulo());
            pstm.setString(4, item.getMascota());
            pstm.setInt(5, item.getUnidad());
            pstm.setInt(6, item.getGravado());
            pstm.setTimestamp(7, item.getFecha_creacion());
            pstm.setFloat(8, item.getPeso());
            pstm.setFloat(9, item.getPrecio_venta());
            pstm.setString(10, item.getEstado());
            pstm.setString(11, item.getUsuario_creo());
            pstm.setFloat(12, item.getEntradas());
            pstm.setFloat(13, item.getSalidas());
            pstm.setFloat(14, item.getSaldo());
            pstm.setString(15, item.getCodigo_item());
            
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al actualizar  " + excepcion.getMessage());
            return null;
        }
        return item;
    }
     
     //Servicio para hecer la eliminación de producto
     public String delItem(String codigo_item) {
        Conexion conn = new Conexion();

        String sql = "DELETE FROM items WHERE codigo_item=?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setString(1, codigo_item);
            pstm.executeUpdate();
            
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al eliminar  " + excepcion.getMessage());
            return "{\"Accion\":\"Error\"}";
        }
        return "{\"Accion\":\"Registro Borrado\"}";
    }
     
     
    
}
