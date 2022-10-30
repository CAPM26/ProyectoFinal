/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JDBC;

import Conexion.ClsConexion;
import Dominio.PlantaDTO;
import Interfaces.PlantaDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cesar Perez
 */
public class PlantaDAO_JDBC implements PlantaDAO{
    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT * FROM table_plantas WHERE id_planta = ?";
    private static final String SQL_INSERT = "INSERT INTO table_plantas(nombre_planta, tipo_planta, fase_desbloqueoPlanta, coste_solesPlanta) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE table_plantas SET nombre_planta=?, tipo_planta=?, fase_desbloqueoPlanta=?, coste_solesPlanta=? WHERE id_planta = ?";
    private static final String SQL_DELETE = "DELETE FROM table_plantas WHERE id_planta = ?";
    
    PlantaDAO_JDBC(){
        
    }
    
    public PlantaDAO_JDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    @Override
    public PlantaDTO select(int idPlanta) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PlantaDTO plantita = null;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setInt(1, idPlanta);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String nombre_planta = rs.getString("nombre_planta");
                String tipo_planta = rs.getString("tipo_planta");
                String fase_desbloqueoPlanta = rs.getString("fase_desbloqueoPlanta");
                int coste_solesPlanta = rs.getInt("coste_solesPlanta");;

                plantita = new PlantaDTO();
                plantita.setNombre_planta(nombre_planta);
                plantita.setTipo_planta(tipo_planta);
                plantita.setFase_desbloqueoPlanta(fase_desbloqueoPlanta);
                plantita.setCoste_solesPlanta(coste_solesPlanta);
            }
        } finally {
            ClsConexion.close(rs);
            ClsConexion.close(stmt);
            if (this.conexionTransaccional == null) {
                ClsConexion.close(conn);
            }

        }
        return plantita;
    }

    @Override
    public int insert(PlantaDTO plantita) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, plantita.getNombre_planta());
            stmt.setString(2, plantita.getTipo_planta());
            stmt.setString(3, plantita.getFase_desbloqueoPlanta());
            stmt.setInt(4, plantita.getCoste_solesPlanta());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } finally {
            ClsConexion.close(stmt);
            if (this.conexionTransaccional == null) {
                ClsConexion.close(conn);
            }
        }

        return rows;
    }

    @Override
    public int update(PlantaDTO plantita) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : ClsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, plantita.getNombre_planta());
            stmt.setString(2, plantita.getTipo_planta());
            stmt.setString(3, plantita.getFase_desbloqueoPlanta());
            stmt.setInt(4, plantita.getCoste_solesPlanta());
            stmt.setInt(5, plantita.getId_planta());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } finally {
            ClsConexion.close(stmt);
            if (this.conexionTransaccional == null) {
                ClsConexion.close(conn);
            }
        }

        return rows;
    }

    @Override
    public int delete(PlantaDTO plantita) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : ClsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, plantita.getId_planta());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } finally {
            ClsConexion.close(stmt);
            if (this.conexionTransaccional == null) {
                ClsConexion.close(conn);
            }
        }

        return rows;
    }
    
    
    
}
