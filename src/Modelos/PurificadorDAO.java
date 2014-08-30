/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelos;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
            sql = "Insert into purificador(id,nombre,cantidad,valor) "
                    + "values('',"
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
    
}
