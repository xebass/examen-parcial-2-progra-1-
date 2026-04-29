/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
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

public class librocontroller {
    
    private final librodao dao = new librodao();
    
    public List<libro> verlibro(){
        
        return dao.obtenerTodos();
        
        
    }
    public void guardarlibro(String nombre, String autor, int year, int paginas, String genero, String editorial, String descripcion, String idioma, String estudiante, int stock ){
    libro lib = new libro(0, nombre, autor, year, paginas, genero, editorial, descripcion, idioma, estudiante);
    dao.guardar(lib);
    }
    public void actualizarlibro(int id,String nombre, String autor, int year, int paginas, String genero, String editorial, String descripcion, String idioma, String estudiante, int stock ){
    libro lib = new libro(id, nombre, autor, year, paginas, genero, editorial, descripcion, idioma, estudiante);
    dao.actualizar(lib);
    }
    public void eliminarlibro(int id){
        dao.eliminar(id);
    }
}
