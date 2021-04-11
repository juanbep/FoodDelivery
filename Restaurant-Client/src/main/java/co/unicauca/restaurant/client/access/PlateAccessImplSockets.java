/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.client.access;

import co.unicauca.restaurant.client.infra.PlateSocket;
import co.unicauca.restaurant.commons.domain.Plate;
import co.unicauca.restaurant.commons.infra.JsonError;
import co.unicauca.restaurant.commons.infra.Protocol;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Beca98
 */
public class PlateAccessImplSockets implements IPlateAccess {

    /**
     * El servicio utiliza un socket para comunicarse con la aplicación server
     */
    private PlateSocket mySocket;

    public PlateAccessImplSockets() {
        mySocket = new PlateSocket();
    }

    /**
     * Busca un Plato. Utiliza un socket para pedir el servicio al servidor.
     * Actualmente en construccion
     *
     * @param id PlatoId
     * @return Objeto Plato
     * @throws Excepcion cuando no pueda conectarse con el servidor
     */
    
    private String procesarConexion(String requestJson)throws Exception{
        String jsonResponse = null;
        try{
            //se establece la conexion
            mySocket.connect();
            //se envia la solicitud y se recibe una respuesta,
            //(CREO)AQUI VALIDAR SI SE DIO CON EXITO LA OPERACION, SEGUN LA REPUESTA DEL SERVIDOR
            jsonResponse = mySocket.sendStream(requestJson);
            mySocket.closeStream();
            mySocket.disconnect();
	    if(jsonResponse.equals("FALLO")){
                return "FALLO";
            }else{
                System.out.println("todo normal");
            }
        }catch(IOException ex){
            ex.getMessage();
        }
        if(jsonResponse == null){
            throw new Exception("no se pudo conectar al servidor");
        }else{
            if (jsonResponse.contains("error")) {
                //Devolvió algún erroR, usar mejor login
                System.out.println("hubo algun tipo de error");
                throw new Exception(this.extractMessages(jsonResponse));
            } else {
                //Devuelve la respuesta del servidor
                System.out.println(jsonResponse);
                return jsonResponse;
            }
        }
    }
    @Override
    public Plate findPlate(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Crea un Plato. Utiliza socket para pedir la accion al servidor.
     *
     * @param plate Objeto tipo plato
     * @return devuelve el Id del plato creado
     * @throws Excepcion al crear el plato
     */
    @Override
    public String createPlate(Plate plate) throws Exception {
        String jsonResponse = null;
        String requestJson = CretePlateRequestJson(plate);
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
                return "exitoso";
            }

        }
    }
    
     @Override
    public List<Plate> listarPlatos()throws Exception {
        String resource="administrador";
        String accion="listarMenuEspecial";
        String requestJson = createlistPlatoJson();
        String response= procesarConexion(requestJson);
        return jsonListarPlato(response);
    }
    
    
    
    
    private String createlistPlatoJson(){
        Protocol protocol=new Protocol();
       protocol.setResource("Plate");
        protocol.setAction("gets");
       
        
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("json: "+requestJson);
        return requestJson;
    }

    /**
     * Extrae los mensajes de la lista de errores.
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
     * Convierte el jsonError a un array de objetos jsonError.
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
     * Crea la solicitud json de creación del customer para ser enviado por el.
     * socket.
     *
     * @param plate
     * @return devulve algo como:
     * {"resource":"Plate","action":"post","parameters":[{"name":"PlateId","value":"980000012"},{"name":"PlateName","value":"Frijoles"},...}]}
     */
    private String CretePlateRequestJson(Plate plate) {
        Protocol protocol = new Protocol();
        protocol.setResource("Plate");
        protocol.setAction("post");
        protocol.addParameter("PlateName", plate.getAtrNamePlate());
        protocol.addParameter("PlateDescription", plate.getAtrDescriptionPlate());
        protocol.addParameter("PlateType", plate.getAtrTypePlate());
        protocol.addParameter("PlatePrice", plate.getAtrPricePlate() + "");
        Gson gson = new Gson();
        String requestJson = gson.toJson(protocol);
        System.out.println("Json" + requestJson);

        return requestJson;
    }

    /**
     * Convierte jsonCustomer, proveniente del server socket, de json a un
     * objeto Plate
     *
     * @param jsonCustomer
     * @return plate
     */
    private Plate jsonToCustDish(String jsonCustomer) {
        Gson gson = new Gson();
        Plate plate = gson.fromJson(jsonCustomer, Plate.class);
        return plate;
    }

    
    private List<Plate> jsonListarPlato(String jsonListarPlatos){
        Gson gson=new Gson();
        Type list = new TypeToken<List<Plate>>(){}.getType();
        return gson.fromJson(jsonListarPlatos, list);
    }
    
    
    
    
}
