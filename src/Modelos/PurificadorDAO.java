/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelos;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Gilmar
 */
public class PurificadorDAO {
    
    Conexion con;
    private String sql;
    public String ex;
    
    public boolean guardarPurificador(Purificador c) throws ClassNotFoundException
    {
        try {
            con = new Conexion();
            con.Conectar();
            sql = "Insert into purificador(nombre,cantidad,valor) "
                    + "values("
                    + "'"+c.getNombre()+"',"
                    + ""+c.getCantidad()+","
                    + ""+c.getValor()+");";
            PreparedStatement pst = con.getConexion().prepareStatement(sql);
            return pst.executeUpdate()>0;
        } catch (SQLException e) {
            ex = "error: "+e.getMessage();
            return false;
        }
    }
    
    public boolean modificarPurificador(Purificador c,long id_pur) throws ClassNotFoundException
    {
        try {
            con = new Conexion();
            con.Conectar();
            sql = "UPDATE purificador set "
                    + "nombre = '" + c.getNombre() + "',"
                    + "cantidad = " + c.getCantidad() + ","
                    + "valor = " + c.getValor() + " "
                    + "WHERE id = " + id_pur + ";";
            System.out.println(sql);
            PreparedStatement pst = con.getConexion().prepareStatement(sql);
            return pst.executeUpdate()>0;
        } catch (SQLException e) {
            ex = "error: "+e.getMessage();
            return false;
        }
    }
    
    public boolean eliminarPurificador(long id_pur) throws ClassNotFoundException
    {
        try {
            con = new Conexion();
            con.Conectar();
            sql = "DELETE FROM purificador WHERE "
                    + "id = " + id_pur + ";";
            PreparedStatement pst = con.getConexion().prepareStatement(sql);
            return pst.executeUpdate()>0;
        } catch (SQLException e) {
            ex = "error: "+e.getMessage();
            return false;
        }
    }
    
    public ArrayList<Purificador> listaPurificadores(String val) throws ClassNotFoundException
    {
        ArrayList<Purificador> listaPur = new ArrayList();
        try {
            con = new Conexion();
            con.Conectar();
            sql = "SELECT * FROM purificador WHERE "
                    + "id LIKE '%" + val +"%' OR "
                    + "nombre LIKE '%" + val + "%' OR "
                    + "cantidad LIKE '%" + val + "%' OR "
                    + "valor LIKE '%" + val + "%';";
            Statement sta = con.getConexion().createStatement();
            ResultSet resultado = sta.executeQuery(sql);
            
            while(resultado.next())
            {
                //Agrego cada dato al ArrayList
                listaPur.add(Mapear(resultado));
            }
            
        } catch (SQLException e) {
            ex = "error: "+e.getMessage();
        }
        
        return listaPur;
    }
    
    private Purificador Mapear(ResultSet rs) throws SQLException
    {
        Purificador pur = new Purificador();
        
        pur.setId(rs.getLong("id"));
        pur.setNombre(rs.getString("nombre"));
        pur.setCantidad(rs.getLong("cantidad"));
        pur.setValor(rs.getLong("valor"));

        return pur;
    }
    
}
