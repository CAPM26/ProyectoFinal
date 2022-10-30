/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Dominio.UsuarioDTO;
import java.sql.SQLException;

/**
 *
 * @author Cesar Perez
 */
public interface UsuarioDAO {
    
    public UsuarioDTO select(int id) throws SQLException;
    public int selectValidar(String userN, String userP) throws SQLException;
    public int insert(UsuarioDTO user) throws SQLException;
    public int update(UsuarioDTO user) throws SQLException;
    public int delete(UsuarioDTO user) throws SQLException;
}
