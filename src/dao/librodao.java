
package dao;
import modelo.libro;
import conexion.CreateConnection;
import dao.librodao;
import controller.librocontroller;
import vista.librovista;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class librodao {
    private final CreateConnection connFactory = new CreateConnection();
    public List<libro> obtenerTodos(){
    List<libro> lista = new ArrayList<>();
        String sql = "SELECT FROM libro * ";
    try(Connection conn = connFactory.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()){
        while(rs.next()){
            libro lb = new libro(
            rs.getInt("id"),
            rs.getString("titulo"),
            rs.getString("autor"),
            rs.getInt("year"),
            rs.getInt("paginas"),
            rs.getString("genero"),
            rs.getString("editorial"),
            rs.getString("descripcion"),
            rs.getString("idioma"),
            rs.getString("stock"));
            lista.add(lb);
            rs.close();
            ps.close();
            conn.close();
           }
    }       catch (SQLException e) {    
            e.printStackTrace();
        }    
        return lista;
    
        
    }
    public boolean guardar(libro lb){
      String sql = "INSERT INTO libro (titulo, autor, year, paginas, genero, editorial, descripcion, idioma, estudiate, stock) VALUES (?,?,?,?,?,?,?,?,?,?) ";
        try(Connection conn = connFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, lb.getTitulo());
            ps.setString(2, lb.getAutor());
            ps.setInt(3, lb.getYear());
            ps.setInt(4, lb.getPaginas());
            ps.setString(5, lb.getGenero());
            ps.setString(6, lb.getEditorial());
            ps.setString(7, lb.getDescripcion());
            ps.setString(8, lb.getIdioma());
            ps.setString(9, lb.getEstudiante());
            ps.setInt(10, lb.getStock());
            
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
        
       
        
    }    
    public boolean actualizar(libro lb){
    String sql = "UPDATE FROM libro SET titulo=?, autor=?, year=?, paginas=?, genero=?, editorial=?, descripcion=?, idioma=?, estudiate=?, stock=?, WHERE id=?";    
    try(Connection conn = connFactory.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, lb.getTitulo());
            ps.setString(2, lb.getAutor());
            ps.setInt(3, lb.getYear());
            ps.setInt(4, lb.getPaginas());
            ps.setString(5, lb.getGenero());
            ps.setString(6, lb.getEditorial());
            ps.setString(7, lb.getDescripcion());
            ps.setString(8, lb.getIdioma());
            ps.setString(9, lb.getEstudiante());
            ps.setInt(10, lb.getStock());
            ps.setInt(11, lb.getId());
            
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
    }   catch (SQLException e) {    
            e.printStackTrace();
        }
    
    return false;
        
        
    }
    
    public boolean eliminar(int id){
        String sql = "DELETE FROM libro WHERE id=?";
        try(Connection conn = connFactory.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)){
        ps.setInt(1, id);
        return true;
        } catch (SQLException e) {
           e.printStackTrace();
        }
        
        return false;
        
    }
    
}
