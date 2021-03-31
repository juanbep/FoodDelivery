/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.commons.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Beca98
 */
public class Menu {

    /**
     * Id del Menu
     */
    private String atrIdMenu;
    /**
     * Nombre del Menu
     */
    private String atrNameMenu;
    /**
     * Id del Restaurante
     */
    private String atrRestaurantId;
    /**
     * Lista con los platos ofertados en el menu
     */
    private List<Plate> atrIdPlates;

    /**
     * Constructor por defecto;
     */
    public Menu() {
        atrIdPlates = new ArrayList<>();
    }

    /**
     * Constructor Parametrizado
     *
     * @param atrIdMenu
     * @param atrNameMenu
     * @param atrRestaurantId
     * @param atrIdPlates
     */
    public Menu(String atrIdMenu, String atrNameMenu, String atrRestaurantId, List<String> atrIdPlates) {
        this.atrIdMenu = atrIdMenu;
        this.atrNameMenu = atrNameMenu;
        this.atrRestaurantId = atrRestaurantId;
        this.atrIdPlates = new ArrayList<>();
    }

    public String getAtrIdMenu() {
        return atrIdMenu;
    }

    public String getAtrNameMenu() {
        return atrNameMenu;
    }

    public String getAtrRestaurantId() {
        return atrRestaurantId;
    }

    public List<Plate> getAtrIdPlates() {
        return atrIdPlates;
    }

    public void setAtrIdMenu(String atrIdMenu) {
        this.atrIdMenu = atrIdMenu;
    }

    public void setAtrNameMenu(String atrNameMenu) {
        this.atrNameMenu = atrNameMenu;
    }

    public void setAtrRestaurantId(String atrRestaurantId) {
        this.atrRestaurantId = atrRestaurantId;
    }

    public void setAtrIdPlates(List<Plate> atrIdPlates) {
        this.atrIdPlates = atrIdPlates;
    }

    @Override
    public String toString() {
        return "Menu{" + "atrIdMenu=" + atrIdMenu + ", atrNameMenu=" + atrNameMenu + ", atrRestaurantId=" + atrRestaurantId + ", atrIdPlates=" + atrIdPlates + '}';
    }

}
