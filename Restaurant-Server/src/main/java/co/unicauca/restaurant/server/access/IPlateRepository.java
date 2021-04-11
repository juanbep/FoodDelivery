/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.server.access;

import co.unicauca.restaurant.commons.domain.Plate;
import java.util.List;

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
    public String createPlate(Plate parPlate);

    public String deletePlate();

    public String uptadePlate();

    public String findPlate();
    
    public List<Plate> listPlate();
}
