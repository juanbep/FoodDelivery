/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.server.access;

import co.unicauca.restaurant.commons.domain.Plate;

/**
 *
 * @author Beca98
 */
public interface IPlateRepository {

    /**
     * Crea un nuevo plato.
     *
     * @param parPlate Objeto de tipo Plato.
     * @return valor especifico (platoId)
     */
    public String createDish(Plate parPlate);

    public String deleteDish();

    public String uptadeDish();

    public String findDish();
}
