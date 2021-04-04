/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.client.access;

import co.unicauca.restaurant.commons.infra.Utilities;

/**
 *
 * @author Beca98
 */
public class Factory {

    private static Factory instance;

    private Factory() {
    }

    /**
     * Clase singleton
     *
     * @return
     */
    public static Factory getInstance() {

        if (instance == null) {
            instance = new Factory();
        }
        return instance;

    }
    
     /**
     * Método que crea una instancia concreta de la jerarquia IRestaurantService
     *
     * @return una clase hija de la abstracción IRepositorioRestaurantes
     */
    public IRestaurantAccess getsRestaurantSerive() {
        IRestaurantAccess result = null;
        String type = Utilities.loadProperty("restaurant.service");
        switch (type) {
            case "default":
                result = new RestaurantAccessImplSockets();
                break;
        }

        return result;
    }
    
    
    /**
     * Método que crea una instancia concreta de la jerarquia IPlateAccess
     *
     * @return una clase hija de la abstracción IRepositorioPlatos
     */
    public IPlateAccess getDishService() {
        IPlateAccess result = null;
        String type = Utilities.loadProperty("restaurant.service");

        switch (type) {
            case "default":
                result = new PlateAccessImplSockets();
                break;
        }
        return result;
    }
    
    /**
     * Método que crea una instancia concreta de la jerarquia IUserAccess
     *
     * @return una clase hija de la abstracción IRepositorioUsuarios
     */
    public IUserAccess getUserService() {
        IUserAccess result = null;
        String type = Utilities.loadProperty("restaurant.service");

        switch (type) {
            case "default":
                result = new UserAccessImplSockets();
                break;
        }
        return result;
    }
    
    

}
