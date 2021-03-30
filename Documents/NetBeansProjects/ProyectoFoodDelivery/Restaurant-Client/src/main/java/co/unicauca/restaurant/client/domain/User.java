/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.client.domain;

/**
 *
 * @author Beca98
 */
public class User {

    /**
     * Nombre de usuario
     */
    private String atrUsername;
    /**
     * Cedula
     */
    private String atrIdentificacion;
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
     * Ciudad de Origen
     */
    private String atrCity;
    /**
     * Direccion de Residencia
     */
    private String atrAddress;
    /**
     * Numero de celular
     */
    private String atrPhoneNumber;
    /**
     * Tipo de usuario(Puede ser un usuario con privilegios de administrador)
     */
    private String atrType;

    /**
     * Constructor por defecto
     */
    public User() {
    }

    /**
     * Constructor Parametrizado
     *
     * @param atrUsername
     * @param atrIdentificacion
     * @param atrNames
     * @param atrLastNames
     * @param atrPassword
     * @param atrCity
     * @param atrPhoneNumber
     * @param atrAddress
     * @param atrType
     */
    public User(String atrUsername, String atrIdentificacion, String atrNames, String atrLastNames, String atrPassword, String atrCity, String atrAddress, String atrPhoneNumber, String atrType) {
        this.atrUsername = atrUsername;
        this.atrIdentificacion = atrIdentificacion;
        this.atrNames = atrNames;
        this.atrLastNames = atrLastNames;
        this.atrPassword = atrPassword;
        this.atrCity = atrCity;
        this.atrAddress = atrAddress;
        this.atrPhoneNumber = atrPhoneNumber;
        this.atrType = atrType;
    }

    /**
     * Metodo set atrUsername
     *
     * @param atrUsername
     */
    public void setAtrUsername(String atrUsername) {
        this.atrUsername = atrUsername;
    }

    /**
     * Metodo set atrIdentificacion
     *
     * @param atrIdentificacion
     */
    public void setAtrIdentificacion(String atrIdentificacion) {
        this.atrIdentificacion = atrIdentificacion;
    }

    /**
     * Metodo set atrNames
     *
     * @param atrNames
     */
    public void setAtrNames(String atrNames) {
        this.atrNames = atrNames;
    }

    /**
     * Metodo set atrLastNames
     *
     * @param atrLastNames
     */
    public void setAtrLastNames(String atrLastNames) {
        this.atrLastNames = atrLastNames;
    }

    /**
     * Metodo set atrPassword
     *
     * @param atrPassword
     */
    public void setAtrPassword(String atrPassword) {
        this.atrPassword = atrPassword;
    }

    /**
     * Metodo set atrCity
     *
     * @param atrCity
     */
    public void setAtrCity(String atrCity) {
        this.atrCity = atrCity;
    }

    /**
     * Metodo set atrAddress
     *
     * @param atrAddress
     */
    public void setAtrAddress(String atrAddress) {
        this.atrAddress = atrAddress;
    }

    /**
     * Metodo set atrPhoneNumber
     *
     * @param atrPhoneNumber
     */
    public void setAtrPhoneNumber(String atrPhoneNumber) {
        this.atrPhoneNumber = atrPhoneNumber;
    }

    /**
     * Metodo set atrtType
     *
     * @param atrType
     */
    public void setAtrType(String atrType) {
        this.atrType = atrType;
    }

    /**
     * Metodo get atrUsername
     *
     * @return atrUsername
     */
    public String getAtrUsername() {
        return atrUsername;
    }

    /**
     * Metodo get atrIdentificacion
     *
     * @return atrIdentificacion
     */
    public String getAtrIdentificacion() {
        return atrIdentificacion;
    }

    /**
     * Metodo get atrNames
     *
     * @return atrNames
     */
    public String getAtrNames() {
        return atrNames;
    }

    /**
     * Metodo get atrLastNames
     *
     * @return atrLastNames
     */
    public String getAtrLastNames() {
        return atrLastNames;
    }

    /**
     * Metodo get atrPassword
     *
     * @return atrPassword
     */
    public String getAtrPassword() {
        return atrPassword;
    }

    /**
     * Metodo get atrCity
     *
     * @return atrCity
     */
    public String getAtrCity() {
        return atrCity;
    }

    /**
     * Metodo get atrAddress
     *
     * @return atrAddress
     */
    public String getAtrAddress() {
        return atrAddress;
    }

    /**
     * Metodo get atrPhoneNumber
     *
     * @return atrPhoneNumber
     */
    public String getAtrPhoneNumber() {
        return atrPhoneNumber;
    }

    /**
     * Metodo get atrType
     *
     * @return
     */
    public String getAtrType() {
        return atrType;
    }

}
