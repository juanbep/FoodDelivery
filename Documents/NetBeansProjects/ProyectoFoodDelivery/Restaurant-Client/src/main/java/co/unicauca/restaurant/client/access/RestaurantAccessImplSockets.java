/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.client.access;

import co.unicauca.restaurant.client.infra.RestaurantSocket;
import co.unicauca.restaurant.commons.domain.Restaurant;
import co.unicauca.restaurant.commons.infra.JsonError;
import co.unicauca.restaurant.commons.infra.Protocol;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Beca98
 */
public class RestaurantAccessImplSockets implements IRestaurantAccess {

    /**
     * El servicio utiliza un socket para comunicarse con la aplicación server
     */
    private RestaurantSocket mySocket;

    public RestaurantAccessImplSockets() {
        mySocket = new RestaurantSocket();
    }

    /**
     * Busca un Restaurante. Utiliza socket para pedir la accion al servidor
     *
     * @param id cidentificacion del cliente
     * @return Objeto Restaurante
     * @throws Exception cuando no pueda conectarse con el servidor
     */
    @Override
    public Restaurant findRestaurant(String id) throws Exception {

        String jsonResponse = null;
        String requestJson = findRestaurantRequestJson(id);

        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();
        } catch (IOException ex) {
            Logger.getLogger(RestaurantAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor este escuchando");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvio algun error
                Logger.getLogger(RestaurantAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontro el Restaurant
                Restaurant restaurant = jsonToRestaurant(jsonResponse);
                return restaurant;
            }
        }

    }

    /**
     * Crea un Restaurante. Utiliza socket para pedir la accion al servidor
     *
     * @param restaurant objeto tipo restaurante
     * @return devuelve el id del restaurante
     * @throws Exception error crear el cliente
     */
    @Override
    public String createRestaurant(Restaurant restaurant) throws Exception {
        String jsonResponse = null;
        String requestJson = createRestaurantRequestJson(restaurant);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(RestaurantAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        } else {

            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(RestaurantAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Agregó correctamente, devuelve el id del restaurante 
                return restaurant.getAtrNitRest() + "";
            }

        }
    }

    /**
     * Busca todos los Restaurantes. Utiliza socket para pedir la accion al
     * servidor
     *
     * @return Lista de Restaurantes.
     * @throws Exception cuando no pueda conectarse con el servidor
     */
    @Override
    public List<Restaurant> ListRestaurant() throws Exception {
        String jsonResponse = null;
        String requestJson = findAllRestaurantRequestJson();

        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();
        } catch (IOException ex) {
            Logger.getLogger(RestaurantAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor este escuchando");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvio algun error
                Logger.getLogger(RestaurantAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontro el Restaurant
                List<Restaurant> restaurant = jsonToListRestaurant(jsonResponse);
                return restaurant;
            }
        }
    }

    /**
     * Crea la solicitud json de creación del restaurant para ser enviado por el
     * socket
     *
     * @param restaurant objeto restaurant
     * @return devulve algo como:
     * {"resource":"Restaurante","action":"post","parameters":[{"name":"RestaurantId","value":"980000012"},{"name":"RestaurantAdmin","value":"Andres"},...}]}
     */
    private String createRestaurantRequestJson(Restaurant restaurant) {

        Protocol protocol = new Protocol();
        protocol.setResource("Restaurant");
        protocol.setAction("post");
        protocol.addParameter("RestaurantId", restaurant.getAtrNitRest());
        protocol.addParameter("RestaurantAdmin", restaurant.getAtrAdmiRest());
        protocol.addParameter("RestaurantName", restaurant.getAtrNameRest());
        protocol.addParameter("RestaurantAddress", restaurant.getAtrAddressRest());
        protocol.addParameter("RestaurantCity", restaurant.getAtrCityRest());
        protocol.addParameter("RestaurantEmail", restaurant.getAtrEmailRest());
        protocol.addParameter("RestaurantPhoneNumber", restaurant.getAtrPhoneNumberRest());

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: " + requestJson);

        return requestJson;
    }

    /**
     * Crea una solicitud json para ser enviada por el socket
     *
     *
     * @return solicitud de consulta de restaurantes en formato Json, algo como:
     * {"resource":"Restaurante","action":"gets","parameters":[]}
     */
    private String findAllRestaurantRequestJson() {

        Protocol protocol = new Protocol();
        protocol.setResource("Restaurante");
        protocol.setAction("gets");
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: " + requestJson);

        return requestJson;
    }

    /**
     * Trasforma un jsonRestaurant a una lista de restaurantes
     *
     * @param jsonRestaurant
     * @return lista re restaurantes
     */
    private List<Restaurant> jsonToListRestaurant(String jsonRestaurant) {
        Gson gson = new Gson();

        java.lang.reflect.Type listType = new TypeToken<List<Restaurant>>() {
        }.getType();

        List<Restaurant> listRestaurant = gson.fromJson(jsonRestaurant, listType);

        return listRestaurant;
    }

    /**
     * Crea una solicitud json para ser enviada por el socket
     *
     *
     * @param idRestaurant identificación del Restaurante
     * @return solicitud de consulta del Restaurante en formato Json, algo como:
     * {"resource":"Restaurante","action":"get","parameters":[{"name":"RestaurantId","value":"98000001"}]}
     */
    private String findRestaurantRequestJson(String RestaurantId) {

        Protocol protocol = new Protocol();
        protocol.setResource("Restaurant");
        protocol.setAction("get");
        protocol.addParameter("RestaurantId", RestaurantId);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);

        return requestJson;

    }

    /**
     * Extra los mensajes de la lista de errores
     *
     * @param jsonResponse lista de mensajes json
     * @return Mensajes de error
     */
    private String extractMessages(String jsonResponse) {
        JsonError[] errors = jsonToErrors(jsonResponse);
        String msjs = "";
        for (JsonError error : errors) {
            msjs += error.getMessage();
        }
        return msjs;
    }

    /**
     * Convierte el jsonError a un array de objetos jsonError
     *
     * @param jsonError
     * @return objeto MyError
     */
    private JsonError[] jsonToErrors(String jsonError) {
        Gson gson = new Gson();
        JsonError[] error = gson.fromJson(jsonError, JsonError[].class);
        return error;
    }

    /**
     * Convierte jsonRestaurant, proveniente del server socket, de json a un
     * objeto Restaurante
     *
     * @param jsonRestaurant objeto cliente en formato json
     */
    private Restaurant jsonToRestaurant(String jsonRestaurant) {

        Gson gson = new Gson();
        Restaurant restaurant = gson.fromJson(jsonRestaurant, Restaurant.class);

        return restaurant;
    }

}
