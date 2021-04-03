/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.server.domain.services;

import co.unicauca.restaurant.commons.domain.Plate;
import co.unicauca.restaurant.commons.infra.JsonError;
import co.unicauca.restaurant.server.access.IPlateRepository;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Beca98
 */
public class PlateService {

    IPlateRepository repositoryPlate;

    /**
     * Constructor parametrizado, Hace inyeccion de dependencias.
     *
     * @param repositoryPlate
     */
    public PlateService(IPlateRepository repositoryPlate) {
        this.repositoryPlate = repositoryPlate;
    }

    /**
     * Constructor por defecto.
     */
    public PlateService() {
    }

    public String CreateDish(Plate parPlate) {
        List<JsonError> errors = new ArrayList<>();
        if (parPlate.getAtrIdPlate().isEmpty() || parPlate.getAtrNamePlate().isEmpty() || parPlate.getAtrPricePlate().isEmpty() || parPlate.getAtrDescriptionPlate().isEmpty() || parPlate.getAtrTypePlate().isEmpty()) {
            errors.add(new JsonError("400", "BAD_REQUEST", "TODOS LOS CAMPOS SON OBLIGATORIOS"));
        }
        if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorJson = gson.toJson(errors);
            return errorJson;
        }
        return repositoryPlate.createPlate(parPlate);
    }

}
