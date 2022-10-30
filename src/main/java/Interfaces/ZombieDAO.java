/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Dominio.ZombieDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Cesar Perez
 */
public interface ZombieDAO {
    
    public ZombieDTO select(int id) throws SQLException;
    public int insert(ZombieDTO zombi) throws SQLException;
    public int update(ZombieDTO zombi) throws SQLException;
    public int delete(ZombieDTO zombi) throws SQLException;  
    
}
