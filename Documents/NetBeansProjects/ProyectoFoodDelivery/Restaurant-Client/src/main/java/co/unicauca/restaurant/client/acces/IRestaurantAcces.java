/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.client.acces;

import co.unicauca.restaurant.commons.domain.Restaurant;
import java.util.List;

/**
 *
 * @author Beca98
 */
public interface IRestaurantAcces {

    /**
     * Busca un restaurante utlizando un socket
     *
     * @param id Id del restaurante
     * @return Objeto restaurant
     * @throws Exception
     */
    public Restaurant findRestaurant(String id) throws Exception;

    /**
     * Crea un restaurante
     *
     * @param restaurant
     * @return
     * @throws Exception
     */
    public String createRestaurant(Restaurant restaurant) throws Exception;

    /**
     * Retorna una lista con todos los restaurantes registrados previamente.
     *
     * @return Lista de restaurantes
     * @throws Exception
     */
    public List<Restaurant> ListRestaurant() throws Exception;

}
