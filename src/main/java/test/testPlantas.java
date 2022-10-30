/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import Conexion.ClsConexion;
import Dominio.PlantaDTO;
import JDBC.PlantaDAO_JDBC;
import java.sql.*;

/**
 *
 * @author Cesar Perez
 */
public class testPlantas {
    
    public static void main(String[] args) {

        Connection conexion = null;
        try {
            conexion = ClsConexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            PlantaDAO_JDBC pl = new PlantaDAO_JDBC(conexion);
            
            PlantaDTO editarPlanta = new PlantaDTO();
            editarPlanta.setId_planta(1);
            editarPlanta.setNombre_planta("nuez");
            editarPlanta.setTipo_planta("planta defensiva");
            pl.update(editarPlanta);
            
            PlantaDTO agregarPlanta = new PlantaDTO();
            agregarPlanta.setNombre_planta("petacereza");
            agregarPlanta.setTipo_planta("planta explosiva");
            agregarPlanta.setFase_desbloqueoPlanta("Patio-Dia");
            agregarPlanta.setCoste_solesPlanta(150);
            pl.insert(agregarPlanta);
            
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
