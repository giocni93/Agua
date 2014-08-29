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
 * @author fabio
 */
public class ClienteDAO {
    
    Conexion con;
    private String sql;
    public String ex;
    //Codigo de mysql para insertar clientes
    public boolean guardarCliente(Clientes c) throws ClassNotFoundException
    {
        try {
            con = new Conexion();
            con.Conectar();
            sql = "Insert into cliente(cedula,cliente,direccion_casa,telefono_casa,direccion_oficina,telefono_oficina,correo)"
                    + "values('"+c.getCedula()+"','"+c.getCliente()+"','"+c.getDireccion_casa()+"','"+c.getTelefono_casa()+"','"
                    +c.getDireccion_oficina()+"','"+c.getTelefono_oficina()+"','"+c.getCorre()+"';";
            PreparedStatement pst = con.getConexion().prepareStatement(sql);
            return pst.executeUpdate()>0;
        } catch (SQLException e) {
            ex = "error: "+e.getMessage();
            return false;
        }
        
    }
    
}
