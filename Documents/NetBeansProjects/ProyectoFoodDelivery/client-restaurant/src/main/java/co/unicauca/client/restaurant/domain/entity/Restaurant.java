/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.client.restaurant.domain.entity;

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
     * Ciudad del Restaurante
     */
    private String atrCityRest;
    /**
     * Usuario Administrador del Restaurante
     */
    private String atrAdmiRest;

    /**
     * Constructor por defecto
     */
    public Restaurant() {
    }

    /**
     * Constructor parametrizado
     *
     * @param atrNitRest
     * @param atrNameRest
     * @param atrAddressRest
     * @param atrPhoneNumberRest
     * @param atrEmailRest
     * @param atrCityRest
     */
    public Restaurant(String atrNitRest, String atrNameRest, String atrAddressRest, String atrPhoneNumberRest, String atrEmailRest, String atrCityRest) {
        this.atrNitRest = atrNitRest;
        this.atrNameRest = atrNameRest;
        this.atrAddressRest = atrAddressRest;
        this.atrPhoneNumberRest = atrPhoneNumberRest;
        this.atrEmailRest = atrEmailRest;
        this.atrCityRest = atrCityRest;
    }

    /**
     * Constructor parametrizado secundario
     *
     * @param atrNitRest
     * @param atrNameRest
     * @param atrAddressRest
     * @param atrPhoneNumberRest
     * @param atrEmailRest
     * @param atrCityRest
     * @param atrAdmiRest
     */
    public Restaurant(String atrNitRest, String atrNameRest, String atrAddressRest, String atrPhoneNumberRest, String atrEmailRest, String atrCityRest, String atrAdmiRest) {
        this.atrNitRest = atrNitRest;
        this.atrNameRest = atrNameRest;
        this.atrAddressRest = atrAddressRest;
        this.atrPhoneNumberRest = atrPhoneNumberRest;
        this.atrEmailRest = atrEmailRest;
        this.atrCityRest = atrCityRest;
        this.atrAdmiRest = atrAdmiRest;
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

}
