/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.server.access;

import co.unicauca.restaurant.commons.domain.User;
import co.unicauca.restaurant.commons.infra.Utilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Beca98
 */
public class UserRepositoryImplMysql implements IUserRepository {

    /**
     * Objeto de tipo Connection.
     */
    private Connection conn;

    /**
     * Metodo encargado de encontrar un usuario
     *
     * @param parUserName cadena de texto. busca un usuario especifico por su
     * UserName
     * @return Objeto de tipo User.
     */
    @Override
    public User findUser(String parUserName) {
        User user = null;
        this.connect();
        try {
            String sql = "SELECT * from Usuario where nom_usuPer=? ";
            try ( PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, parUserName);
                ResultSet res = pstmt.executeQuery();

                if (res.next()) {
                    user = new User();
                    user.setAtrIdentification(res.getString("identificacionPer"));
                    user.setAtrLastNames(res.getString("nombrePer"));
                    user.setAtrPassword(res.getString("apellidoPer"));
                    user.setAtrUserName(res.getString("nom_usuPer"));
                    user.setAtrNames(res.getString("contraseñaPer"));
                    user.setAtrCity(res.getString("ciudadPer"));
                    user.setAtrAddress(res.getString("direccionPer"));
                    user.setAtrPhone(res.getString("telefonoPer"));
                    user.setAtrType(res.getString("tipoPer"));
                }
            }
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar el Uusuario de la base de datos", ex);
        }
        return user;
    }

    /**
     * Metodo para crear usuarios, Este metodo se sobre escribe debido a que es
     * implementado de la interfaz IUserRepository.
     *
     * @param parUser Objeto de tipo User.
     * @return un valor especifico para el parametro parRestaurant (UserName).
     */
    @Override
    public String createUser(User parUser) {
        try {
            this.connect();
            String sql = "INSERT INTO Usuario(identificacionPer,nombrePer,apellidoPer,nom_usuPer,contrasenaPer,ciudadPer,direccionPer,telefonoPer,tipoPer) VALUES (?,?,?,?,?,?,?,?,?)";
            try ( PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, parUser.getAtrIdentification());
                pstmt.setString(2, parUser.getAtrNames());
                pstmt.setString(3, parUser.getAtrLastNames());
                pstmt.setString(4, parUser.getAtrUserName());
                pstmt.setString(5, parUser.getAtrPassword());
                pstmt.setString(6, parUser.getAtrCity());
                pstmt.setString(7, parUser.getAtrAddress());
                pstmt.setString(8, parUser.getAtrPhone());
                pstmt.setString(9, parUser.getAtrType());

                pstmt.executeUpdate();
            }
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(IUserRepository.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
        }
        return parUser.getAtrUserName();
    }

    /**
     * Metodo encargado de realizar la conexion con la base de datos.
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
            Logger.getLogger(UserRepositoryImplMysql.class.getName()).log(Level.SEVERE, "Error al consultar Administrador en la base de datos", ex);
        }
        return -1;
    }

    /**
     * Metodo encargado de desconectar la aplicacion de la base de datos.
     */
    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantRepositoryImplMysql.class.getName()).log(Level.FINER, "Error al cerrar Connection", ex);
        }
    }

}
