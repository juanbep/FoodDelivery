/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.client.domain.services;

import co.unicauca.restaurant.client.access.IPlateAccess;
import co.unicauca.restaurant.commons.domain.Plate;
import co.unicauca.restaurant.commons.domain.Restaurant;
import java.util.List;

/**
 *
 * @author Beca98
 */
public class PlateService {

    private final IPlateAccess service;

    /**
     * Constructor privado que evita que otros objetos creen una instancia
     *
     * @param service implementacion de tipo IRestaurantAccess
     */
    public PlateService(IPlateAccess service) {
        this.service = service;
    }

    /**
     * Busca un plato en el servidor remoto
     *
     * @param id identificador del restaurante
     * @return Objeto tipo plato, null si no lo encuentra
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public Plate findPlate(String id) throws Exception {
        return service.findPlate(id);
    }

    /**
     * Crear un obeto tipo plato en el servidor remoto
     *
     * @param plate objeto a crear
     * @return un string con el id del objeto creado
     * @throws Exception
     */
    public String createPlate(Plate plate) throws Exception {
        return service.createPlate(plate);
    }
    
    
    public List<Plate> listPlate() throws Exception {
        return service.listarPlatos();
    }

}
