/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.server.access;

import co.unicauca.restaurant.commons.domain.Plate;

import co.unicauca.restaurant.commons.infra.Utilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Beca98
 */
public class PlateRepositoryImplMysql implements IPlateRepository {

    /**
     * Objeto de tipo Connection, encargado de realizar la Conexion con Mysql.
     */
    public Connection conn;
    public Connection conn2;

    /**
     * Metodo encargado de crear un plato.
     *
     * @param parPlate Objeto de tipo Plato.
     * @return cadena de texto con el plateId.
     */
    @Override
    public String createPlate(Plate parPlate) {
        try {
            this.connect();
            String sql = "INSERT INTO plato(nombreplato, descripcionplato, precioplato, tipoPlato) VALUES (?,?,?,?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, parPlate.getAtrNamePlate());
                pstmt.setString(2, parPlate.getAtrDescriptionPlate());
                pstmt.setString(3, parPlate.getAtrPricePlate());
                pstmt.setString(4, parPlate.getAtrTypePlate());
                pstmt.executeUpdate();
                
            }
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
        }
        return (parPlate.getAtrIdPlate());
    }

    @Override
    public String deletePlate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String uptadePlate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String findPlate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Metodo que se encarga de realizar la conexion con la base de datos.
     *
     * @return 1, si la conexion fue exitosa, -1 si la conexion fue fallida.
     */
    public int connect() {
        try {
            Class.forName(Utilities.loadProperty("server.db.driver"));
            //crea una instancia de la controlador de la base de datos
            String url = Utilities.loadProperty("server.db.url");
            String username = Utilities.loadProperty("server.db.username");
            String pwd = Utilities.loadProperty("server.db.password");
            conn = DriverManager.getConnection(url, username, pwd);
            conn2 = DriverManager.getConnection(url, username, pwd);
            return 1;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(RestaurantRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar Restaurante de la base de datos", ex);
        }
        return -1;
    }

    /**
     * Metodo encargado de desconectar la aplicacion de la base de datos.
     */
    private void disconnect() {
        try {
            conn.close();
            conn2.close();
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantRepositoryImplMysql.class.getName()).log(Level.FINER, "Error al cerrar Connection", ex);
        }
    }

    @Override
    public List<Plate> listPlate() {
        List<Plate> objList = new ArrayList<>();
        this.connect();
       Plate objPlate = new Plate();
        try {
            String sql = "SELECT * FROM plato;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                objPlate.setAtrIdPlate(res.getString("idplato"));
                objPlate.setAtrNamePlate(res.getString("nombreplato"));
                objPlate.setAtrDescriptionPlate(res.getString("descripcionplato"));
                objPlate.setAtrPricePlate(res.getString("precioplato"));
                objPlate.setAtrTypePlate(res.getString("tipoplato"));
              
                objList.add(objPlate);
                objPlate = new Plate();
            }
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar el restaurante de la base de datos", ex);
        }
        return objList;
    }

}
