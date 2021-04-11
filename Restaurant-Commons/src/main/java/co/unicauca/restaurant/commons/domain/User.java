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
public class User {

    /**
     * Nombre de usuario
     */
    private String atrUserName;
    /**
     * Identificacion
     */
    private String atrIdentification;
    /**
     * Nombres
     */
    private String atrNames;
    /**
     * Apellidos
     */
    private String atrLastNames;
    /**
     * Contraseña
     */
    private String atrPassword;
    /**
     * Ciudad de Residencia
     */
    private String atrCity;
    /**
     * Dirección de residencia
     */
    private String atrAddress;
    /**
     * Teléfono Móvil
     */
    private String atrPhone;
    /**
     * Tipo de User (Admin or Customer)
     */
    private String atrType;

    /**
     * Constructor por defecto
     */
    public User() {
    }

    /**
     * Constructor parametrizado
     *
     * @param atrUserName
     * @param atrIdentification
     * @param atrNames
     * @param atrLastNames
     * @param atrPassword
     * @param atrCity
     * @param atrAddress
     * @param atrPhone
     * @param atrType
     */
    public User(String atrUserName, String atrIdentification, String atrNames, String atrLastNames, String atrPassword, String atrCity, String atrAddress, String atrPhone, String atrType) {
        this.atrUserName = atrUserName;
        this.atrIdentification = atrIdentification;
        this.atrNames = atrNames;
        this.atrLastNames = atrLastNames;
        this.atrPassword = atrPassword;
        this.atrCity = atrCity;
        this.atrAddress = atrAddress;
        this.atrPhone = atrPhone;
        this.atrType = atrType;
    }

    public String getAtrUserName() {
        return atrUserName;
    }

    public void setAtrUserName(String atrUserName) {
        this.atrUserName = atrUserName;
    }

    public String getAtrIdentification() {
        return atrIdentification;
    }

    public void setAtrIdentification(String atrIdentification) {
        this.atrIdentification = atrIdentification;
    }

    public String getAtrNames() {
        return atrNames;
    }

    public void setAtrNames(String atrNames) {
        this.atrNames = atrNames;
    }

    public String getAtrLastNames() {
        return atrLastNames;
    }

    public void setAtrLastNames(String atrLastNames) {
        this.atrLastNames = atrLastNames;
    }

    public String getAtrPassword() {
        return atrPassword;
    }

    public void setAtrPassword(String atrPassword) {
        this.atrPassword = atrPassword;
    }

    public String getAtrCity() {
        return atrCity;
    }

    public void setAtrCity(String atrCity) {
        this.atrCity = atrCity;
    }

    public String getAtrAddress() {
        return atrAddress;
    }

    public void setAtrAddress(String atrAddress) {
        this.atrAddress = atrAddress;
    }

    public String getAtrPhone() {
        return atrPhone;
    }

    public void setAtrPhone(String atrPhone) {
        this.atrPhone = atrPhone;
    }

    public String getAtrType() {
        return atrType;
    }

    public void setAtrType(String atrType) {
        this.atrType = atrType;
    }

    @Override
    public String toString() {
        return "User{" + "atrUserName=" + atrUserName + ", atrIdentification=" + atrIdentification + ", atrNames=" + atrNames + ", atrLastNames=" + atrLastNames + ", atrPassword=" + atrPassword + ", atrCity=" + atrCity + ", atrAddress=" + atrAddress + ", atrPhone=" + atrPhone + ", atrType=" + atrType + '}';
    }

}
