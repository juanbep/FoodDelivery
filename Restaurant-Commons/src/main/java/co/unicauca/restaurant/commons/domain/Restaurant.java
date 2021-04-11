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
public class Restaurant {

    /**
     * Nit del Restaurante
     */
    private String atrNitRest;
    /**
     * Nombre del Restaurante
     */
    private String atrNameRest;
    /**
     * Ciudad del Restaurante
     */
    private String atrCityRest;
    /**
     * Direccion del Restaurante
     */
    private String atrAddressRest;
    /**
     * Telefono del Restaurante
     */
    private String atrPhoneNumberRest;
    /**
     * Correo del Restaurante
     */
    private String atrEmailRest;
    /**
     * Usuario Administrador del Restaurante
     */
    private String atrAdmiRest;
    /**
     * Menu(s) que ofrece el restaurante
     */
    private List<Menu> atrIdMenus;

    /**
     * Constructor por defecto
     */
    public Restaurant() {
    }

    public Restaurant(String atrNitRest, String atrNameRest, String atrCityRest, String atrAddressRest, String atrPhoneNumberRest, String atrEmailRest, String atrAdmiRest, List<Menu> atrIdMenus) {
        this.atrNitRest = atrNitRest;
        this.atrNameRest = atrNameRest;
        this.atrCityRest = atrCityRest;
        this.atrAddressRest = atrAddressRest;
        this.atrPhoneNumberRest = atrPhoneNumberRest;
        this.atrEmailRest = atrEmailRest;
        this.atrAdmiRest = atrAdmiRest;
        this.atrIdMenus = new ArrayList<>();
    }

    public String getAtrNitRest() {
        return atrNitRest;
    }

    public String getAtrNameRest() {
        return atrNameRest;
    }

    public String getAtrAddressRest() {
        return atrAddressRest;
    }

    public String getAtrPhoneNumberRest() {
        return atrPhoneNumberRest;
    }

    public String getAtrEmailRest() {
        return atrEmailRest;
    }

    public String getAtrCityRest() {
        return atrCityRest;
    }

    public String getAtrAdmiRest() {
        return atrAdmiRest;
    }

    public List<Menu> getAtrIdMenus() {
        return atrIdMenus;
    }

    public void setAtrNitRest(String atrNitRest) {
        this.atrNitRest = atrNitRest;
    }

    public void setAtrNameRest(String atrNameRest) {
        this.atrNameRest = atrNameRest;
    }

    public void setAtrAddressRest(String atrAddressRest) {
        this.atrAddressRest = atrAddressRest;
    }

    public void setAtrPhoneNumberRest(String atrPhoneNumberRest) {
        this.atrPhoneNumberRest = atrPhoneNumberRest;
    }

    public void setAtrEmailRest(String atrEmailRest) {
        this.atrEmailRest = atrEmailRest;
    }

    public void setAtrCityRest(String atrCityRest) {
        this.atrCityRest = atrCityRest;
    }

    public void setAtrAdmiRest(String atrAdmiRest) {
        this.atrAdmiRest = atrAdmiRest;
    }

    public void setAtrIdMenus(List<Menu> atrIdMenus) {
        this.atrIdMenus = atrIdMenus;
    }

    @Override
    public String toString() {
        return "Restaurant{" + "atrNitRest=" + atrNitRest + ", atrNameRest=" + atrNameRest + ", atrCityRest=" + atrCityRest + ", atrAddressRest=" + atrAddressRest + ", atrPhoneNumberRest=" + atrPhoneNumberRest + ", atrEmailRest=" + atrEmailRest + ", atrAdmiRest=" + atrAdmiRest + ", atrIdMenus=" + atrIdMenus + '}';
    }

}
