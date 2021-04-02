/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.commons.domain;

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
    private Menu atrMenus;

    /**
     * Constructor por defecto
     */
    public Restaurant() {
    }

    /**
     * Constructor Parametrizado
     *
     * @param atrNitRest
     * @param atrNameRest
     * @param atrAddressRest
     * @param atrPhoneNumberRest
     * @param atrEmailRest
     * @param atrCityRest
     * @param atrAdmiRest
     * @param atrMenu
     */
    public Restaurant(String atrNitRest, String atrNameRest, String atrAddressRest, String atrPhoneNumberRest, String atrEmailRest, String atrCityRest, String atrAdmiRest, Menu atrMenus) {
        this.atrNitRest = atrNitRest;
        this.atrNameRest = atrNameRest;
        this.atrAddressRest = atrAddressRest;
        this.atrPhoneNumberRest = atrPhoneNumberRest;
        this.atrEmailRest = atrEmailRest;
        this.atrCityRest = atrCityRest;
        this.atrAdmiRest = atrAdmiRest;
        this.atrMenus = atrMenus;
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

    public Menu getAtrMenu() {
        return atrMenus;
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

    public void setAtrMenu(Menu atrMenu) {
        this.atrMenus = atrMenu;
    }

    @Override
    public String toString() {
        return "Restaurant{" + "atrNitRest=" + atrNitRest + ", atrNameRest=" + atrNameRest + ", atrAddressRest=" + atrAddressRest + ", atrPhoneNumberRest=" + atrPhoneNumberRest + ", atrEmailRest=" + atrEmailRest + ", atrCityRest=" + atrCityRest + ", atrAdmiRest=" + atrAdmiRest + ", atrMenus=" + atrMenus + '}';
    }

}
