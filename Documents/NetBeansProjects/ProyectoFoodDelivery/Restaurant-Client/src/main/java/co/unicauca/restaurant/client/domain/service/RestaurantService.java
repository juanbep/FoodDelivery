/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.client.domain.service;

import co.unicauca.restaurant.client.acces.IRestaurantAccess;
import co.unicauca.restaurant.commons.domain.Restaurant;
import java.util.List;

/**
 *
 * @author Beca98
 */
public class RestaurantService {

    private final IRestaurantAccess service;

    /**
     * Constructor privado que evita que otros objetos creen una instancia
     *
     * @param service implementacion de tipo IRestaurantAccess
     */
    public RestaurantService(IRestaurantAccess service) {
        this.service = service;
    }

    /**
     * Busca un Restaurante en el servidor remoto
     *
     * @param id identificador del restaurante
     * @return Objeto tipo Restaurante, null si no lo encuentra
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public Restaurant findRestaurant(String id) throws Exception {
        return service.findRestaurant(id);
    }

    /**
     * Crea un obeto tipo restaurante en el servidor remoto
     *
     * @param restaurant objeto a crear
     * @return un string con el id del objeto creado
     * @throws Exception
     */
    public String createRestaurant(Restaurant restaurant) throws Exception {
        return service.createRestaurant(restaurant);
    }

    /**
     * Obtiene una lista de restaurante del servidor
     *
     * @return lista de restauranes
     * @throws Exception
     */
    public List<Restaurant> listRestaurant() throws Exception {
        return service.ListRestaurant();
    }

}
