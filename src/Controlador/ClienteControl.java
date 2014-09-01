/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelos.ClienteDAO;
import Modelos.Clientes;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author fabio
 */
public class ClienteControl {
    
    ////Codigo para inserta en el controlador
    
    ClienteDAO cli;
    public void insertarCliente(Clientes c) throws ClassNotFoundException
    {
        cli = new ClienteDAO();
        if(cli.guardarCliente(c))
        {
            JOptionPane.showMessageDialog(null, "Guardado");
        }else
        {
            JOptionPane.showMessageDialog(null, cli.ex);
        }
    }
    
    public boolean  modificarCliente(Clientes c, String cc) throws ClassNotFoundException
    {
        cli = new ClienteDAO();
        if(cli.modificarCliente(c, cc))
        {
            JOptionPane.showMessageDialog(null, "Modificado correctamente.");
            return true;
        }else
        {
            JOptionPane.showMessageDialog(null, cli.ex);
            return false;
        }
        
    }
    
    public boolean eliminarcliente(String cc) throws ClassNotFoundException
    {
        cli = new ClienteDAO();
        if(cli.eliminarCliente(cc))
        {
            JOptionPane.showMessageDialog(null, "Eliminado correctamente.");
            return true;
        }else
        {
            JOptionPane.showMessageDialog(null, cli.ex);
            return false;
        }
    }
    
    public ArrayList<Clientes> listaClientes(String val)
    {
        ArrayList<Clientes> listaPur = null;
        cli = new ClienteDAO();
        try {
            listaPur = cli.listaClientes(val);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return listaPur;
    }
    
}
