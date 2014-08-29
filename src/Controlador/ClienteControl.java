/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelos.ClienteDAO;
import Modelos.Clientes;
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
    
}
