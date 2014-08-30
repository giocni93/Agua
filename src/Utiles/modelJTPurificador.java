/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utiles;

import Modelos.Purificador;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gilmar
 */
public class modelJTPurificador extends AbstractTableModel{
    
    //Creo el array con sus columnas
    private String columnNames[] = {"Id","Nombre purificador","Cantidad","Valor / Precio"};
    
    //Al arrayList le doy la clase donde obtendrá los datos y le doy su nombre
    ArrayList<Purificador>listaPur;
    
    //Metodo para retornar los datos del objeto
    public ArrayList<Purificador>getLstDatos()
    {
        //Me retorna lo que contiene la lista del objeto
        return listaPur;
    }
  
    //Metodo para darle valor al ArrayList
    public void setLsDatos(ArrayList<Purificador>data)
    {
        this.listaPur = data;
    }
    
    //Este metodo retorna el nombre de la columna del ArrayList
    @Override
    public String getColumnName(int colmnIdex)
    {
        return columnNames[colmnIdex];
    }
    
    //Este metodo me retorna el número de filas del ArrayList
    @Override
    public int getRowCount()
    {
        return this.listaPur.size();
    }
    
    //Este metodo me retorna el número de columnas del ArrayList
    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }
    
    //Falta explicación
    @Override
    public Class getColumnClass(int columnIndex)
    {
        Object value = this.getValueAt(0, columnIndex);
        return (value == null ? Object.class : value.getClass());
    } 
    
    //Este metodo me retorna el objeto del articulo seleccionado (solo los datos de ese cliente, No todos)
    public Purificador getFila(int rowIndex)
    {
        return (Purificador) listaPur.get(rowIndex);
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
        Purificador deta = listaPur.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                deta.setId((long) value);
                break;
            case 1:
                deta.setNombre((String) value);
                break;
            case 2:
                deta.setCantidad((long ) value);
                break;
            case 3:
                deta.setValor((long) value);
                break;
        }
    }
    
    //Metodo para retornar los valores de la tabla
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Purificador deta = listaPur.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                return deta.getId();
            case 1:
                return deta.getNombre();
            case 2:
                return deta.getCantidad();
            case 3:
                return deta.getValor();
        }
        
        //Si no retorna ninguno de los valores entonces retorna un String vacio
        return new String();
    }
    
}
