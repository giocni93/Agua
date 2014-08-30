/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelos.Purificador;
import Modelos.PurificadorDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author Gilmar
 */
public class PurificadorControl {
    
    PurificadorDAO purDao;
    public void insertarPurificador(Purificador pu) throws ClassNotFoundException
    {
        purDao = new PurificadorDAO();
        if(purDao.guardarPurificador(pu))
        {
            JOptionPane.showMessageDialog(null, "Guardado correctamente.");
        }else
        {
            JOptionPane.showMessageDialog(null, purDao.ex);
        }
    }
    
}
