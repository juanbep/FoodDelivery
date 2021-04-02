/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.server.access;

import co.unicauca.restaurant.commons.domain.Restaurant;
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
public class RestaurantRepositoryImplMysql implements IRestaurantRepository {

    /**
     * Objeto de tipo Connection, encargado de realizar la Conexion con Mysql.
     */
    public Connection conn;

    /**
     * Constructor por defecto.
     */
    public RestaurantRepositoryImplMysql() {

    }

    /**
     * Metodo encargado de encontrar los restaurantes.
     *
     * @param restaurantId cadena de texto, busca un restaurante especifico por
     * su Id especifico.
     * @return objeto de tipo restaurante.
     */
    @Override
    public Restaurant findRestaurant(String restaurantId) {
        Restaurant restaurant = null;
        try {
            this.connect();
            String sql = "SELECT * from Restaurante where RestNombre=? ";
            try ( PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, restaurantId);
                ResultSet res = pstmt.executeQuery();
                if (res.next()) {
                    restaurant.setAtrNitRest(res.getString("restaurantId"));
                    restaurant.setAtrNameRest(res.getString("restaurantName"));
                    restaurant.setAtrCityRest(res.getString("restaurantCity"));
                    restaurant.setAtrAddressRest(res.getString("restaurantAddress"));
                    restaurant.setAtrEmailRest(res.getString("restaurantEmail"));
                    restaurant.setAtrPhoneNumberRest(res.getString("restaurantPhoneNumber"));
                    restaurant.setAtrAdmiRest(res.getString("restaurantAdmin"));
                }
            }
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar el restaurante de la base de datos", ex);
        }
        return restaurant;
    }

    /**
     * Metodo encargado de crear un restaurante, Este metodo se sobre escribe
     * debido a que es implementado de la interfaz IRestaurantRepository.
     *
     * @param parRestaurant Objeto de tipo Restaurante.
     * @return retorna un valor especifico para el parametro parRestaurant
     * (ResId).
     */
    @Override
    public String createRestaurant(Restaurant parRestaurant) {
        try {
            this.connect();
            String sql = "INSERT INTO restaurante(NitRestaurant,NameRestaurant,CityRestaurant,AddressRestaurant,EmailRestaurant,PhoneNumberRestaurant,AdmiRestaurant) VALUES (?,?,?,?,?,?)";
            try ( PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, parRestaurant.getAtrNitRest());
                pstmt.setString(2, parRestaurant.getAtrNameRest());
                pstmt.setString(3, parRestaurant.getAtrCityRest());
                pstmt.setString(4, parRestaurant.getAtrAddressRest());
                pstmt.setString(5, parRestaurant.getAtrEmailRest());
                pstmt.setString(6, parRestaurant.getAtrPhoneNumberRest());
                pstmt.setString(7, parRestaurant.getAtrAdmiRest());
                pstmt.executeUpdate();
            }
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
        }
        return (parRestaurant.getAtrNitRest());
    }

    /**
     * Metodo encargado de obtener una lista de todos los restaurantes.
     *
     * @return Se retorna una lista con los resultados de la busqueda.
     */
    @Override
    public List<Restaurant> findAllRestaurant() {
        List<Restaurant> objList = new ArrayList<>();
        this.connect();
        Restaurant objRestaurant = new Restaurant();
        try {
            String sql = "SELECT * FROM restaurante;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                objRestaurant.setAtrNitRest(res.getString("restaurantId"));
                objRestaurant.setAtrNameRest(res.getString("restaurantName"));
                objRestaurant.setAtrCityRest(res.getString("restaurantCity"));
                objRestaurant.setAtrAddressRest(res.getString("restaurantAddress"));
                objRestaurant.setAtrEmailRest(res.getString("restaurantEmail"));
                objRestaurant.setAtrPhoneNumberRest(res.getString("restaurantPhoneNumber"));
                objRestaurant.setAtrAdmiRest(res.getString("restaurantAdmin"));
                objList.add(objRestaurant);
                objRestaurant = new Restaurant();
            }
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar el restaurante de la base de datos", ex);
        }
        return objList;
    }

    /**
     * Metodo encargado de Eliminar un Restaurante.
     *
     * @return
     */
    @Override
    public String deleteRestaurant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Metodo encargado de actualizar la informacion sobre el Restaurante.
     *
     * @return
     */
    @Override
    public String updateRestaurant() {
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
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantRepositoryImplMysql.class.getName()).log(Level.FINER, "Error al cerrar Connection", ex);
        }
    }

}
