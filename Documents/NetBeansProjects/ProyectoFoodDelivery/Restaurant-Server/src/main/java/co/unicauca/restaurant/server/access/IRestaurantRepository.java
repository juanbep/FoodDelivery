/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.server.access;

import co.unicauca.restaurant.commons.domain.Restaurant;
import java.util.List;

/**
 *
 * @author Beca98
 */
public interface IRestaurantRepository {

    /**
     * Metodo para obtener un Restaurante por su Identificacion.
     *
     * @param restaurantId id del restaurante
     * @return objeto de tipo Restaurant.
     */
    public Restaurant findRestaurant(String restaurantId);

    /**
     * Crea un nuevo restaurante
     *
     * @param parRestaurant objeto tipo restaurante
     * @return retorna un valor especifico del parametro parRestaurant
     * (RestaurantId).
     */
    public String createRestaurant(Restaurant parRestaurant);

    /**
     * Metodo para obtener una lista de todos los restaurantes.
     *
     * @return lista de tipo Restaurant.
     */
    public List<Restaurant> findAllRestaurant();

    public String deleteRestaurant();

    public String updateRestaurant();

}
