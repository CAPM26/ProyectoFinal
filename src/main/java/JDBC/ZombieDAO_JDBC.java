/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JDBC;

import Conexion.ClsConexion;
import Dominio.ZombieDTO;
import Interfaces.ZombieDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cesar Perez
 */
public class ZombieDAO_JDBC implements ZombieDAO{
    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT * FROM table_zombies WHERE id_zombie = ?";
    private static final String SQL_INSERT = "INSERT INTO table_zombies(nombre_zombie, dureza_zombie) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE table_zombies SET nombre_zombie=?, dureza_zombie=? WHERE id_zombie = ?";
    private static final String SQL_DELETE = "DELETE FROM table_zombies WHERE id_zombie = ?";
    
        public ZombieDAO_JDBC() {

    }

    public ZombieDAO_JDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    @Override
    public ZombieDTO select(int idZombie) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ZombieDTO zombi = null;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setInt(1, idZombie);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String nombre_zombie = rs.getString("nombre_zombie");
                String dureza_zombie = rs.getString("dureza_zombie");

                zombi = new ZombieDTO();
                zombi.setNombre_zombie(nombre_zombie);
                zombi.setDureza_zombie(dureza_zombie);

            }
        } finally {
            ClsConexion.close(rs);
            ClsConexion.close(stmt);
            if (this.conexionTransaccional == null) {
                ClsConexion.close(conn);
            }

        }
        return zombi;
    }
    
    @Override
    public int insert(ZombieDTO zombi) throws SQLException {
    Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, zombi.getNombre_zombie());
            stmt.setString(2, zombi.getDureza_zombie());

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
    public int update(ZombieDTO zombi) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : ClsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, zombi.getNombre_zombie());
            stmt.setString(2, zombi.getDureza_zombie());
            stmt.setInt(3, zombi.getId_zombie());

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
    public int delete(ZombieDTO zombi) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : ClsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, zombi.getId_zombie());
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
