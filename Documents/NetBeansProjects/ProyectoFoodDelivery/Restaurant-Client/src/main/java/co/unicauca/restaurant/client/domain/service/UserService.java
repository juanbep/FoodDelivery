/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.client.domain.service;

import co.unicauca.restaurant.client.acces.IUserAccess;
import co.unicauca.restaurant.commons.domain.User;

/**
 *
 * @author Beca98
 */
public class UserService {

    private final IUserAccess service;

    /**
     * Constructor privado que evita que otros objetos instancien
     *
     * @param service implementacion de tipo IUserAccess
     */
    public UserService(IUserAccess service) {
        this.service = service;
    }

    /**
     * Busca un Usuario en el servidor remoto
     *
     * @param id identificador del Usuario
     * @return Objeto tipo User, null si no lo encuentra
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public User findUser(String id) throws Exception {
        return service.findUser(id);
    }

    /**
     * Crear un obeto Usuario en el servidor remoto
     *
     * @param user el objeto a crear
     * @return un string con el id del objeto creado
     * @throws Exception
     */
    public String createUser(User user) throws Exception {
        return service.createUser(user);
    }

}
