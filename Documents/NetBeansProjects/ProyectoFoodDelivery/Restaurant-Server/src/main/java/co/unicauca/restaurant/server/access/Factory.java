/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.server.access;

import co.unicauca.restaurant.commons.infra.Utilities;

/**
 *
 * @author Beca98
 */
public class Factory {

    private static Factory instance;

    /**
     * Constructor por defecto
     */
    private Factory() {
    }

    /**
     * Clase singleton
     *
     * @return Instancia de la clase Factory
     */
    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;

    }

    /**
     * Metodo que crea una instancia concreta de la jerarquia
     * IRestaurantRepository
     *
     * @return una clase hija de la abstraccion IRepositorioClientes
     */
    public IRestaurantRepository getRepository() {
        String type = Utilities.loadProperty("restaurant.repository");
        if (type.isEmpty()) {
            type = "mysql";
        }
        IRestaurantRepository result = null;

        switch (type) {
            case "mysql":
                result = new RestaurantRepositoryImplMysql();
                break;
        }
        return result;
    }

    /**
     * Metodo que crea una instancia concreta de la jerarquia IUserRepository.
     *
     * @return una clase hija de la abstraccion IUserRepository.
     */
    public IUserRepository getRepositoryUser() {
        String type = Utilities.loadProperty("restaurant.repository");
        if (type.isEmpty()) {
            type = "mysql";
        }
        IUserRepository result = null;

        switch (type) {
            case "mysql":
                result = new UserRepositoryImplMysql();
                break;
        }
        return result;
    }

    /**
     * Metodo que crea una instancia concreta de la jerarquia IPlateRepository.
     *
     * @return una clase hija de la abstraccion IPlateRepository.
     */
    public IPlateRepository getRepositoryDish() {
        String type = Utilities.loadProperty("restaurant.repository");
        if (type.isEmpty()) {
            type = "mysql";
        }
        IPlateRepository result = null;
        switch (type) {
            case "mysql":
                result = new PlateRepositoryImplMysql();
                break;
        }
        return result;
    }

}
