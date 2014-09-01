/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utiles;


import Modelos.Clientes;
import Modelos.Purificador;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author fabio rojas
 */
public class modelJTClientes extends AbstractTableModel{
    
    private String columnNames[] = {"Cedula","Clientes","Direccion","Telefono"};
    
    ArrayList<Clientes>listacli;
    
     //Metodo para retornar los datos del objeto
    public ArrayList<Clientes>getLstDatos()
    {
        //Me retorna lo que contiene la lista del objeto
        return listacli;
    }
  
    //Metodo para darle valor al ArrayList
    public void setLsDatos(ArrayList<Clientes>data)
    {
        this.listacli = data;
    }

    //Este metodo retorna el nombre de la columna del ArrayList
    @Override
    public String getColumnName(int colmnIdex)
    {
        return columnNames[colmnIdex];
    }
    
    @Override
    public Class getColumnClass(int columnIndex)
    {
        Object value = this.getValueAt(0, columnIndex);
        return (value == null ? Object.class : value.getClass());
    } 
    
    //Este metodo me retorna el objeto del articulo seleccionado (solo los datos de ese cliente, No todos)
    public Clientes getFila(int rowIndex)
    {
        return (Clientes) listacli.get(rowIndex);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex,int columnIndex)
    {
        return true;
    }
    
    //Metodo para dar los valores a cada campo de la tabla
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex)
    {
        Clientes cli = listacli.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                cli.setCedula((String) value);
                break;
            case 1:
                cli.setCliente((String) value);
                break;
            case 2:
                cli.setDireccion_casa((String ) value);
                break;
            case 3:
                cli.setTelefono_casa((String) value);
                break;
        }
    }
    
    @Override
    public int getRowCount() {
        //To change body of generated methods, choose Tools | Templates.
        return this.listacli.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Clientes cli = listacli.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                return cli.getCedula();
            case 1:
                return cli.getCliente();
            case 2:
                return cli.getDireccion_casa();
            case 3:
                return cli.getTelefono_casa();
        }
        
        //Si no retorna ninguno de los valores entonces retorna un String vacio
        return new String();
    }
    
    
}
