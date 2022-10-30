/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author Cesar Perez
 */
public class PlantaDTO {
    private int id_planta;
    private String nombre_planta;
    private String tipo_planta;
    private String fase_desbloqueoPlanta;
    private int coste_solesPlanta;

    /**
     * @return the id_planta
     */
    public int getId_planta() {
        return id_planta;
    }

    /**
     * @param id_planta the id_planta to set
     */
    public void setId_planta(int id_planta) {
        this.id_planta = id_planta;
    }

    /**
     * @return the nombre_planta
     */
    public String getNombre_planta() {
        return nombre_planta;
    }

    /**
     * @param nombre_planta the nombre_planta to set
     */
    public void setNombre_planta(String nombre_planta) {
        this.nombre_planta = nombre_planta;
    }

    /**
     * @return the tipo_planta
     */
    public String getTipo_planta() {
        return tipo_planta;
    }

    /**
     * @param tipo_planta the tipo_planta to set
     */
    public void setTipo_planta(String tipo_planta) {
        this.tipo_planta = tipo_planta;
    }

    /**
     * @return the fase_desbloqueoPlanta
     */
    public String getFase_desbloqueoPlanta() {
        return fase_desbloqueoPlanta;
    }

    /**
     * @param fase_desbloqueoPlanta the fase_desbloqueoPlanta to set
     */
    public void setFase_desbloqueoPlanta(String fase_desbloqueoPlanta) {
        this.fase_desbloqueoPlanta = fase_desbloqueoPlanta;
    }

    /**
     * @return the coste_solesPlanta
     */
    public int getCoste_solesPlanta() {
        return coste_solesPlanta;
    }

    /**
     * @param coste_solesPlanta the coste_solesPlanta to set
     */
    public void setCoste_solesPlanta(int coste_solesPlanta) {
        this.coste_solesPlanta = coste_solesPlanta;
    }

    @Override
    public String toString() {
        return "PlantaDTO{" + "id_planta =" + id_planta + ", nombre_planta =" + nombre_planta + ", tipo_planta =" 
                + tipo_planta + ", fase_desbloqueoPlanta =" + fase_desbloqueoPlanta + ", coste_solesPlanta =" + coste_solesPlanta + '}';
    }
    
}
