/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Dominio.PlantaDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Cesar Perez
 */
public interface PlantaDAO {
    
    public PlantaDTO select(int id) throws SQLException;
    public int insert(PlantaDTO plantita) throws SQLException;
    public int update(PlantaDTO plantita) throws SQLException;
    public int delete(PlantaDTO plantita) throws SQLException;  
    
}
