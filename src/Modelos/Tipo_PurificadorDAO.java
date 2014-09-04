package Modelos;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author giocni
 */
public class Tipo_PurificadorDAO {
    
    Conexion con;
    private String sql;
    public String ex;
    
    public boolean guardarTipo_Purificador(Tipo_Purificador p) throws ClassNotFoundException
    {
        try {
            con = new Conexion();
            con.Conectar();
            sql = "Insert into tipo_purificador(tipo,detalle,id_purificador) "
                    + "values("
                    + "'"+p.getTipo()+"',"
                    + "'"+p.getDetalle()+"',"
                    + ""+p.getId_purificador()+");";
            PreparedStatement pst = con.getConexion().prepareStatement(sql);
            return pst.executeUpdate()>0;
        } catch (SQLException e) {
            ex = "error: "+e.getMessage();
            return false;
        }
    }
    
}
