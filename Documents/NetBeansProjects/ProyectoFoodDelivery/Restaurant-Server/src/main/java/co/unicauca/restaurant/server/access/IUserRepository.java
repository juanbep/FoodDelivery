/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.server.access;

import co.unicauca.restaurant.commons.domain.User;

/**
 * Interfaz del repositorio de usuarios
 *
 * @author Beca98
 */
public interface IUserRepository {

    /**
     * Busca un Usuario por su identificacion
     *
     * @param id identificacion del usuario
     * @return objeto de tipo User
     */
    public User findUser(String id);

    /**
     * Metodo para crear un usuario
     *
     * @param user Objeto de tipo User.
     * @return cadena de texto con el nombre de usuario (getUserName).
     */
    public String createUser(User user);

}
