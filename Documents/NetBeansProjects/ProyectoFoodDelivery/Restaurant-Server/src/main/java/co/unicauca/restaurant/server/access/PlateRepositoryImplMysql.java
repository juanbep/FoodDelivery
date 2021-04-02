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
import java.sql.SQLException;
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
            String sql = "INSERT INTO plato(IdPlate, NamePlate, PricePlate, DescriptionPlate, TypePlate) VALUES (?,?,?,?,?)";
            PreparedStatement pstmt2;
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, parPlate.getAtrIdPlate());
                pstmt.setString(2, parPlate.getAtrNamePlate());
                pstmt.setString(3, parPlate.getAtrPricePlate());
                pstmt.setString(4, parPlate.getAtrDescriptionPlate());
                pstmt.setString(5, parPlate.getAtrTypePlate());
                pstmt.executeUpdate();
                String sql2 = "INSERT INTO Pertenece al Menu (MenuId) VALUES (?) ";
                pstmt2 = conn2.prepareStatement(sql2);
                pstmt2.setString(1, parPlate.getAtrMenuId());
                pstmt2.executeUpdate();
            }
            pstmt2.close();

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
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantRepositoryImplMysql.class.getName()).log(Level.FINER, "Error al cerrar Connection", ex);
        }
    }

}
