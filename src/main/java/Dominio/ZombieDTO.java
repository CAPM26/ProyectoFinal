/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author Cesar Perez
 */
public class ZombieDTO {
    private int id_zombie;
    private String nombre_zombie;
    private String dureza_zombie;

    /**
     * @return the id_zombie
     */
    public int getId_zombie() {
        return id_zombie;
    }

    /**
     * @param id_zombie the id_zombie to set
     */
    public void setId_zombie(int id_zombie) {
        this.id_zombie = id_zombie;
    }

    /**
     * @return the nombre_zombie
     */
    public String getNombre_zombie() {
        return nombre_zombie;
    }

    /**
     * @param nombre_zombie the nombre_zombie to set
     */
    public void setNombre_zombie(String nombre_zombie) {
        this.nombre_zombie = nombre_zombie;
    }

    /**
     * @return the dureza_zombie
     */
    public String getDureza_zombie() {
        return dureza_zombie;
    }

    /**
     * @param dureza_zombie the dureza_zombie to set
     */
    public void setDureza_zombie(String dureza_zombie) {
        this.dureza_zombie = dureza_zombie;
    }

    @Override
    public String toString() {
        return "ZombieDTO{" + "id_zombie =" + id_zombie + ", nombre_zombie =" + nombre_zombie + ", dureza_zombie =" + dureza_zombie + '}';
    }
    
    
    
}
