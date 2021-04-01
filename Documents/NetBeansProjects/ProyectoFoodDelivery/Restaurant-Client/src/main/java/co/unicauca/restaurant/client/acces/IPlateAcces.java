/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.client.acces;

import co.unicauca.restaurant.commons.domain.Plate;

/**
 *
 * @author Beca98
 */
public interface IPlateAcces {

    /**
     * Buscar un Plato utlizando un socket
     *
     * @param id Id del plato
     * @return Objeto Plate 
     * @throws Exception
     */
    public Plate findPlate(String id) throws Exception;

    /**
     * Crea un Plato
     *
     * @param plate
     * @return
     * @throws Exception
     */
    public String createPlate(Plate plate) throws Exception;
}
