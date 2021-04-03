/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.server.domain.services;

import co.unicauca.restaurant.commons.domain.User;
import co.unicauca.restaurant.commons.infra.JsonError;
import co.unicauca.restaurant.server.access.IUserRepository;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Beca98
 */
public class UserService {

    /**
     * repositorio de Usuarios, Objeto de tipo IUserRepository.
     */
    IUserRepository repository;

    /**
     * Contructor por defecto.
     */
    public UserService() {
    }

    /**
     * Constructor parametrizado. Hace inyeccion de dependencias
     *
     * @param repository repositorio de tipo IUserRepository
     */
    public UserService(IUserRepository repository) {
        this.repository = repository;
    }

    /**
     * Metodo encargado de buscar un Restaurante.
     *
     * @param parUserName
     * @return objeto tipo Restaurante
     */
    public User findUser(String parUserName) {
        return repository.findUser(parUserName);
    }

    /**
     * Metodo encargado de crear un nuevo Usuario (User).
     *
     * @param parUserName objeto de tipo User.
     * @return llamado a funcion createUser() de la interfaz IUserRepository.
     */
    public String CreateUser(User parUserName) {
        List<JsonError> errors = new ArrayList<>();
        if (parUserName.getAtrUserName().isEmpty() || parUserName.getAtrNames().isEmpty() || parUserName.getAtrLastNames().isEmpty()
                || parUserName.getAtrIdentification().isEmpty() || parUserName.getAtrPassword().isEmpty()
                || parUserName.getAtrCity().isEmpty() || parUserName.getAtrAddress().isEmpty() || parUserName.getAtrPhone().isEmpty()
                || parUserName.getAtrType().isEmpty()) {
            errors.add(new JsonError("400", "BAD_REQUEST", "TODOS LOS CAMPOS SON OBLIGATORIOS"));
        }
        if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorJson = gson.toJson(errors);
            return errorJson;
        }
        return repository.createUser(parUserName);
    }

}
