/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import Conexion.ClsConexion;
import Dominio.UsuarioDTO;
import JDBC.UsuarioDAO_JDBC;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Cesar Perez
 */
public class testUsuarios {
    
    public static void main(String[] args) {

        Connection conexion = null;
        try {
            conexion = ClsConexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            UsuarioDAO_JDBC us = new UsuarioDAO_JDBC(conexion);
            
            UsuarioDTO editarUser = new UsuarioDTO();
            editarUser.setIdUsuario(2);
            editarUser.setUserName("userN");
            editarUser.setUserPass("abc123");
            us.update(editarUser);
            
            UsuarioDTO agregarUser = new UsuarioDTO();
            agregarUser.setUserName("us22");
            agregarUser.setUserPass("xyz1");
            us.insert(agregarUser);
            
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
