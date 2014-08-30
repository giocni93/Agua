/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelos.Purificador;
import Modelos.PurificadorDAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gilmar
 */
public class PurificadorControl {
    
    PurificadorDAO purDao;
    public boolean insertarPurificador(Purificador pu) throws ClassNotFoundException
    {
        purDao = new PurificadorDAO();
        if(purDao.guardarPurificador(pu))
        {
            JOptionPane.showMessageDialog(null, "Guardado correctamente.");
            return true;
        }else
        {
            JOptionPane.showMessageDialog(null, purDao.ex);
            return false;
        }
    }
    
    public boolean modificarPurificador(Purificador pu,long id_pur) throws ClassNotFoundException
    {
        purDao = new PurificadorDAO();
        if(purDao.modificarPurificador(pu,id_pur))
        {
            JOptionPane.showMessageDialog(null, "Modificado correctamente.");
            return true;
        }else
        {
            JOptionPane.showMessageDialog(null, purDao.ex);
            return false;
        }
    }
    
    public boolean eliminarPurificador(long id_pur) throws ClassNotFoundException
    {
        purDao = new PurificadorDAO();
        if(purDao.eliminarPurificador(id_pur))
        {
            JOptionPane.showMessageDialog(null, "Eliminado correctamente.");
            return true;
        }else
        {
            JOptionPane.showMessageDialog(null, purDao.ex);
            return false;
        }
    }
    
    public ArrayList<Purificador> listaPurificador(String val)
    {
        ArrayList<Purificador> listaPur = null;
        purDao = new PurificadorDAO();
        try 
        {
            listaPur = purDao.listaPurificadores(val);
        } 
        catch(ClassNotFoundException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return listaPur;
    }
    
}
