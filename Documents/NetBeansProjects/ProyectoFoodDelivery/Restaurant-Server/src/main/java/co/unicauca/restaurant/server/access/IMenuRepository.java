/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.server.access;

import co.unicauca.restaurant.commons.domain.Menu;

/**
 *
 * @author Beca98
 */
public interface IMenuRepository {

    /**
     * Crea un nuevo menu.
     *
     * @param parMenu Objeto de tipo Menu.
     * @return valor especifico IdMenu.
     */
    public String createMenu(Menu parMenu);

    public String uptadeMenu();

    public String deleteMenu();

    public String findMenu();

    public int connect();

    public void disconnect();

}
