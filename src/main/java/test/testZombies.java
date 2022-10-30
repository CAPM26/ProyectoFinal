/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import Conexion.ClsConexion;
import Dominio.ZombieDTO;
import JDBC.ZombieDAO_JDBC;
import java.sql.*;

/**
 *
 * @author Cesar Perez
 */
public class testZombies {
    
    public static void main(String[] args) {

        Connection conexion = null;
        try {
            conexion = ClsConexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            ZombieDAO_JDBC zom = new ZombieDAO_JDBC(conexion);
            
            ZombieDTO editarZombie = new ZombieDTO();
            editarZombie.setId_zombie(1);
            editarZombie.setNombre_zombie("zombie CaraCubo");
            editarZombie.setDureza_zombie("Alta");
            zom.update(editarZombie);
            
            ZombieDTO agregarZombie = new ZombieDTO();
            agregarZombie.setNombre_zombie("zombie explorador");
            agregarZombie.setDureza_zombie("Media");
            zom.insert(agregarZombie);
            
            conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }

    }
}
