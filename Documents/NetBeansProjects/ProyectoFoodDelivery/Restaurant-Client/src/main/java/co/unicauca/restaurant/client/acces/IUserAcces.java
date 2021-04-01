/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.client.acces;

import co.unicauca.restaurant.commons.domain.User;

/**
 *
 * @author Beca98
 */
public interface IUserAcces {

    /**
     * Buscar un Usuario utlizando un socket
     *
     * @param id Id del Usuario 
     * @return Objeto User
     * @throws Exception
     */
    public User findUser(String id) throws Exception;

    /**
     * Crea un Usario
     *
     * @param user
     * @return
     * @throws Exception
     */
    public String createUser(User user) throws Exception;

}
