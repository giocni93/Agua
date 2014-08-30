/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelos;

/**
 *
 * @author Gilmar
 */
public class Tipo_Purificador {
    
    private long id;
    private String tipo;
    private String detalle;
    private long id_purificador;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public long getId_purificador() {
        return id_purificador;
    }

    public void setId_purificador(long id_purificador) {
        this.id_purificador = id_purificador;
    }
    
}
