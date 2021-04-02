/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.client.acces;

import co.unicauca.restaurant.client.infra.UserSocket;
import co.unicauca.restaurant.commons.domain.User;
import co.unicauca.restaurant.commons.infra.JsonError;
import co.unicauca.restaurant.commons.infra.Protocol;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Beca98
 */
public class UserAccessImplSockets implements IUserAccess {

    /**
     * El servicio utiliza un socket para comunicarse con la aplicación server
     */
    private UserSocket mySocket;

    UserAccessImplSockets() {
        mySocket = new UserSocket();
    }

    /**
     * Busca un Customer. Utiliza socket para pedir la accion al servidor
     *
     * @param id id del usuario
     * @return Objeto User
     * @throws Exception cuando no pueda conectarse con el servidor
     */
    @Override
    public User findUser(String id) throws Exception {
        String jsonResponse = null;
        String requestJson = findUserRequestJson(id);

        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();
        } catch (IOException ex) {
            Logger.getLogger(UserAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }

        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor. Revise la red o que el servidor este escuchando");
        } else {
            if (jsonResponse.contains("error")) {
                //Devolvio algun error
                Logger.getLogger(UserAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Encontro un usuario
                User user = jsonToUser(jsonResponse);
                return user;
            }
        }
    }

    /**
     * Crea un ususario. Utiliza socket para pedir la accion al servidor
     *
     * @param user ususario de Restaurantes Online
     * @return devuelve el id del ususario creado
     * @throws Exception error crear el ususario
     */
    @Override
    public String createUser(User user) throws Exception {
        String jsonResponse = null;
        String requestJson = createUserRequestJson(user);
        try {
            mySocket.connect();
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(UserAccessImplSockets.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        } else {

            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(UserAccessImplSockets.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Agregó correctamente, devuelve el userName del usuarioS 
                return user.getAtrUserName() + "";
            }

        }
    }

    /**
     * Crea una solicitud json para ser enviada por el socket
     *
     * @param userName nombre de usuario
     * @return solicitud de consulta del ususario en formato Json, algo como:
     * {"resource":"user","action":"get","parameters":[{"name":"userName","value":"Juan"}]}
     */
    private String findUserRequestJson(String userName) {
        Protocol protocol = new Protocol();
        protocol.setResource("user");
        protocol.setAction("get");
        protocol.addParameter("userName", userName);

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
     * objeto User
     *
     * @param jsonUser objeto cliente en formato json
     */
    private User jsonToUser(String jsonUser) {

        Gson gson = new Gson();
        User user = gson.fromJson(jsonUser, User.class);

        return user;

    }

    /**
     * Crea la solicitud json de creación del Usuario para ser enviado por el
     * socket
     *
     * @param user objeto customer
     * @return devulve algo como:
     * {"resource":"Usuario","action":"post","parameters":[{"name":"UserName","value":"bc98"},{"name":"UserPassword","value":"Felipe"},...}]}
     */
    private String createUserRequestJson(User user) {

        Protocol protocol = new Protocol();
        protocol.setResource("Usuario");
        protocol.setAction("post");
        protocol.addParameter("UserName", user.getAtrUserName());
        protocol.addParameter("UserPassword", user.getAtrPassword());
        protocol.addParameter("UserIdentification", user.getAtrIdentification());
        protocol.addParameter("UserNames", user.getAtrNames());
        protocol.addParameter("UserLastNames", user.getAtrLastNames());
        protocol.addParameter("UserCity", user.getAtrCity());
        protocol.addParameter("UserAddress", user.getAtrAddress());
        protocol.addParameter("UserPhoneNumber", user.getAtrPhone());
        protocol.addParameter("UserType", user.getAtrType());

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: " + requestJson);

        return requestJson;
    }

}
