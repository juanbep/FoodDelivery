/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.server.domain.services;

import co.unicauca.restaurant.commons.domain.Restaurant;
import co.unicauca.restaurant.commons.infra.JsonError;
import co.unicauca.restaurant.server.access.IRestaurantRepository;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Beca98
 */
public class RestaurantService {

    /**
     * repositorio de Restaurante, Objeto de tipo IRestauranRepository.
     */
    IRestaurantRepository repository;

    /**
     * Constructor por defecto.
     */
    public RestaurantService() {
    }

    /**
     * Constructor parametrizado, Hace inyeccion de dependencias.
     *
     * @param repository repositorio de tipo IRestaurantRepository.
     */
    public RestaurantService(IRestaurantRepository repository) {
        this.repository = repository;
    }

    /**
     * Metodo encargado buscar un restaurante usando la interfaz
     * IRestaurantRepository.
     *
     * @param parRestaurantId cadena de texto con el Id para buscar un
     * restaurante.
     * @return objeto tipo Restaurante
     */
    public Restaurant findRestaurant(String parRestaurantId) {
        return repository.findRestaurant(parRestaurantId);
    }

    /**
     * Crea un nuevo restaurante, Aplica validaciones de negocio.
     *
     * @param parRestaurant Objeto de tipo Restaurant.
     * @return llamado al metodo createRestaurant.
     */
    public String CreateRestaurant(Restaurant parRestaurant) {
        List<JsonError> errors = new ArrayList<>();
        if (parRestaurant.getAtrNitRest().isEmpty() || parRestaurant.getAtrNameRest().isEmpty() || parRestaurant.getAtrCityRest().isEmpty()
                || parRestaurant.getAtrAddressRest().isEmpty() || parRestaurant.getAtrEmailRest().isEmpty()
                || parRestaurant.getAtrPhoneNumberRest().isEmpty() || parRestaurant.getAtrAdmiRest().isEmpty()) {
            errors.add(new JsonError("400", "BAD_REQUEST", "TODOS LOS CAMPOS SON OBLIGATORIOS"));
        }
        if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorJson = gson.toJson(errors);
            return errorJson;
        }

        return repository.createRestaurant(parRestaurant);

    }

    /**
     * Metodo encargado de obtener una lista de todos los restaurantes
     * existentes.
     *
     * @return llamado a metodo findAllRestaurant.
     */
    public List<Restaurant> ListRestaurant() {
        List<JsonError> errors = new ArrayList<>();
        if (!repository.findAllRestaurant().isEmpty()) {
            if (!errors.isEmpty()) {
                errors.add(new JsonError("400", "BAD_REQUEST", "ERROR AL GENERAR SERVICIO SQL"));
            }
        }
        return repository.findAllRestaurant();
    }

}
