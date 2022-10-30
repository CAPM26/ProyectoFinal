/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JDBC;

import Conexion.ClsConexion;
import Dominio.UsuarioDTO;
import Interfaces.UsuarioDAO;
import java.sql.*;

/**
 *
 * @author Cesar Perez
 */
public class UsuarioDAO_JDBC implements UsuarioDAO{
    
        private Connection conexionTransaccional;

    private static final String SQL_SELECTVALIDAR = "SELECT userName, userPass FROM usuarios WHERE userName = ? AND userPass = ?";
    private static final String SQL_SELECT = "SELECT * FROM usuarios WHERE idUsuario = ?";
    private static final String SQL_INSERT = "INSERT INTO usuarios(userName, userPass) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE usuarios SET userName=?, userPass=? WHERE idUsuario = ?";
    private static final String SQL_DELETE = "DELETE FROM usuarios WHERE idUsuario = ?";
    
    UsuarioDAO_JDBC(){
        
    }
    
    public UsuarioDAO_JDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    @Override
    public UsuarioDTO select(int idUser) throws SQLException {
    Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        UsuarioDTO user = null;
        int nValidar = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setInt(1, idUser);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String userName = rs.getString("userName");
                String userPass = rs.getString("userPass");

                user = new UsuarioDTO();
                user.setUserName(userName);
                user.setUserPass(userPass);
            }
        } finally {
            ClsConexion.close(rs);
            ClsConexion.close(stmt);
            if (this.conexionTransaccional == null) {
                ClsConexion.close(conn);
            }

        }
        return user;
    }

    @Override
    public int insert(UsuarioDTO user) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getUserPass());

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
    public int update(UsuarioDTO user) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : ClsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getUserPass());
            stmt.setInt(3, user.getIdUsuario());

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
    public int delete(UsuarioDTO user) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : ClsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, user.getIdUsuario());
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

    @Override
    public int selectValidar(String userN, String userP) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        UsuarioDTO userV = null;
        int nValidar = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECTVALIDAR);
            stmt.setString(1, userN);
            stmt.setString(2, userP);
            rs = stmt.executeQuery();
            
                while(rs.next()){
                    
                    nValidar = 1;
                    
                }
                
        } finally {
            ClsConexion.close(rs);
            ClsConexion.close(stmt);
            if (this.conexionTransaccional == null) {
                ClsConexion.close(conn);
            }

        }
        return nValidar;
    }
    
}
