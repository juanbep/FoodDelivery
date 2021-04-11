/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.server.access;

import co.unicauca.restaurant.commons.infra.Utilities;

/**
 *
 * @author Beca98
 */
public class Factory {
    
    private static Factory instance;
    
    private Factory(){
    }
    /**
     * retorno solo una instancia de fabrica
     * singleton
     * @return instancia de FabricaRepositorio
     */
    public static Factory getInstance(){
        if(instance == null){
            instance = new Factory();
        }
        return instance;
    }
    /**
     * retorna un repositorio
     * @return instancia del repositorio
     */
    public IPlateRepository getRepositoryPlate(){
        IPlateRepository repositorio = new PlateRepositoryImplMysql();
        //IPlatoRepositorio repositorio = new RestauranteRepositorioDeveloper();
        return repositorio;
    }

    /**
     * Metodo que crea una instancia concreta de la jerarquia
     * IRestaurantRepository
     *
     * @return una clase hija de la abstraccion IRepositorioClientes
     */
    public IRestaurantRepository getRepositoryRestaurant() {    
            IRestaurantRepository repositorio = new RestaurantRepositoryImplMysql();
        //IPlatoRepositorio repositorio = new RestauranteRepositorioDeveloper();
        return repositorio;
    }

    /**
     * Metodo que crea una instancia concreta de la jerarquia IUserRepository.
     *
     * @return una clase hija de la abstraccion IUserRepository.
     */
    public IUserRepository getRepositoryUser() {
            IUserRepository repositorio = new UserRepositoryImplMysql();
        //IPlatoRepositorio repositorio = new RestauranteRepositorioDeveloper();
        return repositorio;
    }



}
