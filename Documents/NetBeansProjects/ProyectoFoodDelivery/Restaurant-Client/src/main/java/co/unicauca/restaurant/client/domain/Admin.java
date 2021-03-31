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

    private List<Restaurant> restaurants;

    public Admin() {
        restaurants = new ArrayList<>();
    }

    public Admin(List<Restaurant> restaurants, String atrUserName, String atrIdentification, String atrNames, String atrLastNames, String atrPassword, String atrCity, String atrAddress, String atrPhone, String atrType) {
        super(atrUserName, atrIdentification, atrNames, atrLastNames, atrPassword, atrCity, atrAddress, atrPhone, atrType);
        this.restaurants = new ArrayList<>();
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);

    }

}
