/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.client.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Beca98
 */
public class Admin extends User {

    /**
     * El administrador puede tener 1 o varios restaurantes
     */
    private List<Restaurant> restaurants;

    /**
     * Cobstructor por defecto
     */
    public Admin() {
        restaurants = new ArrayList<>();
    }

    /**
     * super constructor
     *
     * @param restaurants
     * @param atrUsername
     * @param atrIdentificacion
     * @param atrNames
     * @param atrLastNames
     * @param atrPassword
     * @param atrCity
     * @param atrAddress
     * @param atrPhoneNumber
     * @param atrType
     */
    public Admin(List<Restaurant> restaurants, String atrUsername, String atrIdentificacion, String atrNames, String atrLastNames, String atrPassword, String atrCity, String atrAddress, String atrPhoneNumber, String atrType) {
        super(atrUsername, atrIdentificacion, atrNames, atrLastNames, atrPassword, atrCity, atrAddress, atrPhoneNumber, atrType);
        this.restaurants = new ArrayList<>();
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);

    }

}
