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
                    +c.getDireccion_oficina()+"','"+c.getTelefono_oficina()+"','"+c.getCorre()+"');";
            PreparedStatement pst = con.getConexion().prepareStatement(sql);
            return pst.executeUpdate()>0;
        } catch (SQLException e) {
            ex = "error: "+e.getMessage();
            return false;
        }
        
    }
    
    public boolean modificarCliente(Clientes c,String id) throws ClassNotFoundException
    {
        try {
            con = new Conexion();
            con.Conectar();
            sql = "Update cliente set "
                    + "cliente='"+c.getCliente()+"',"
                    + "direccion_casa='"+c.getDireccion_casa()+"',"
                    + "telefono_casa='"+c.getTelefono_casa()+"',"
                    + "direccion_oficina='"+c.getDireccion_oficina()+"',"
                    + "telefono_oficina='"+c.getTelefono_oficina()+"',"
                    + "correo='"+c.getCorre()+"'"
                    + "where cedula='"+id+"';";
            System.out.println(sql);
            PreparedStatement pst = con.getConexion().prepareStatement(sql);
            return pst.executeUpdate()>0;
        } catch (SQLException e) {
            ex = "error: "+e.getMessage();
            return false;
        }
    }
    
    public boolean eliminarCliente(String id) throws ClassNotFoundException
    {
        try {
            con = new Conexion();
            con.Conectar();
            sql = "Delete from cliente where cedula='"+id+"'";
            PreparedStatement pst = con.getConexion().prepareStatement(sql);
            return pst.executeUpdate()>0;
        } catch (SQLException e) {
            ex = "Error: " + e.getMessage();
            return false;
        }
    }
    
    public ArrayList<Clientes> listaClientes(String val) throws ClassNotFoundException
    {
        ArrayList<Clientes> listaCli = new ArrayList<>();
        try {
            con = new Conexion();
            con.Conectar();
            sql = "SELECT * FROM cliente WHERE cedula like '%"+val+"%' or cliente like '%"+val+"%'";
            Statement sta = con.getConexion().createStatement();
            ResultSet resultado = sta.executeQuery(sql);
            while(resultado.next())
            {
                listaCli.add(mapear(resultado));
                
            }
        } catch (SQLException e) {
            ex = "Error: " + e.getMessage();
        }
        return listaCli;
    }
    
    public Clientes mapear(ResultSet rs) throws SQLException
    {
        Clientes cliente = new Clientes();
        cliente.setCedula(rs.getString("cedula"));
        cliente.setCliente(rs.getString("cliente"));
        cliente.setDireccion_casa(rs.getString("direccion_casa"));
        cliente.setTelefono_casa(rs.getString("telefono_casa"));
        cliente.setDireccion_oficina(rs.getString("direccion_oficina"));
        cliente.setTelefono_oficina(rs.getString("telefono_oficina"));
        cliente.setCorre(rs.getString("correo"));
        return cliente;
    }
    
}
