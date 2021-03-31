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
public class Plate {

    /**
     * id del plato
     */
    private String atrIdPlate;
    /**
     * Nombre del plato
     */
    private String atrNamePlate;
    /**
     * Precio del plato
     */
    private String atrPricePlate;
    /**
     * Descripcion del plato
     */
    private String atrDescriptionPlate;
    /**
     * Tipo de plato((entrada, principio, proteína o bebida).
     */
    private String atrTypePlate;

    /**
     * Constructor por defecto
     */
    public Plate() {

    }

    /**
     * Constructor Parametrizado
     *
     * @param atrIdPlate
     * @param atrNamePlate
     * @param atrPricePlate
     * @param atrDescriptionPlate
     * @param atrTypePlate
     */
    public Plate(String atrIdPlate, String atrNamePlate, String atrPricePlate, String atrDescriptionPlate, String atrTypePlate) {
        this.atrIdPlate = atrIdPlate;
        this.atrNamePlate = atrNamePlate;
        this.atrPricePlate = atrPricePlate;
        this.atrDescriptionPlate = atrDescriptionPlate;
        this.atrTypePlate = atrTypePlate;

    }

    public String getAtrIdPlate() {
        return atrIdPlate;
    }

    public String getAtrNamePlate() {
        return atrNamePlate;
    }

    public String getAtrPricePlate() {
        return atrPricePlate;
    }

    public String getAtrDescriptionPlate() {
        return atrDescriptionPlate;
    }

    public String getAtrTypePlate() {
        return atrTypePlate;
    }

    public void setAtrIdPlate(String atrIdPlate) {
        this.atrIdPlate = atrIdPlate;
    }

    public void setAtrNamePlate(String atrNamePlate) {
        this.atrNamePlate = atrNamePlate;
    }

    public void setAtrPricePlate(String atrPricePlate) {
        this.atrPricePlate = atrPricePlate;
    }

    public void setAtrDescriptionPlate(String atrDescriptionPlate) {
        this.atrDescriptionPlate = atrDescriptionPlate;
    }

    public void setAtrTypePlate(String atrTypePlate) {
        this.atrTypePlate = atrTypePlate;
    }

    @Override
    public String toString() {
        return "Plate{" + "atrIdPlate=" + atrIdPlate + ", atrNamePlate=" + atrNamePlate + ", atrPricePlate=" + atrPricePlate + ", atrDescriptionPlate=" + atrDescriptionPlate + ", atrTypePlate=" + atrTypePlate + '}';
    }

}
