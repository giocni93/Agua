package Controlador;

import Modelos.Tipo_Purificador;
import Modelos.Tipo_PurificadorDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author giocni
 */
public class Tipo_PurificadorControl {
    
    Tipo_PurificadorDAO tipoPurDao;
    public boolean insertarPurificador(Tipo_Purificador pu) throws ClassNotFoundException
    {
        tipoPurDao = new Tipo_PurificadorDAO();
        if(tipoPurDao.guardarTipo_Purificador(pu))
        {
            JOptionPane.showMessageDialog(null, "Guardado correctamente.");
            return true;
        }else
        {
            JOptionPane.showMessageDialog(null, tipoPurDao.ex);
            return false;
        }
    }
    
}
