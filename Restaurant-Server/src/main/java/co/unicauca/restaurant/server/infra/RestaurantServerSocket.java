/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.server.infra;

import co.unicauca.restaurant.commons.domain.Plate;
import co.unicauca.restaurant.commons.domain.Restaurant;
import co.unicauca.restaurant.commons.domain.User;
import co.unicauca.restaurant.commons.infra.JsonError;
import co.unicauca.restaurant.commons.infra.Protocol;
import co.unicauca.restaurant.commons.infra.Utilities;
import co.unicauca.restaurant.server.access.Factory;
import co.unicauca.restaurant.server.access.IPlateRepository;
import co.unicauca.restaurant.server.access.IRestaurantRepository;
import co.unicauca.restaurant.server.access.IUserRepository;
import co.unicauca.restaurant.server.domain.services.PlateService;
import co.unicauca.restaurant.server.domain.services.RestaurantService;
import co.unicauca.restaurant.server.domain.services.UserService;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Beca98
 */
public class RestaurantServerSocket implements Runnable {

    /**
     * Objeto de tipo RestaurantService.
     */
    private final RestaurantService restaurantService;

    /**
     * Objeto de tipo PlateService
     */
    private final PlateService plateService;

    /**
     * Objeto de tipo UserService.
     */
    private final UserService userService;

    /**
     * Objeto de tipo ServerSocket.
     */
    private static ServerSocket ssock;

    /**
     * Objeto de tipo Socket por donde se hace la petición/respuesta.
     */
    private static Socket socket;

    /**
     * Objeto de tipo Scanner que permite leer un flujo de datos del socket.
     */
    private Scanner input;

    /**
     * Objeto de tipo PrintStream que permite escribir un flujo de datos del
     * socket.
     */
    private PrintStream output;

    /**
     * Puerto por donde escucha el server socket, la configuracion que tomara
     * sera de 'server.port'.
     */
    private static final int PORT = Integer.parseInt(Utilities.loadProperty("server.port"));

    /**
     * Constructor parametrizado, se encarga de inyectar las dependencias a las
     * variables restaurantService, userService y Restaurant service.
     */
    public RestaurantServerSocket() {
        // Se hace la inyección de dependencia
        IRestaurantRepository restaurantRepository = Factory.getInstance().getRepositoryRestaurant();
        restaurantService = new RestaurantService(restaurantRepository);

        IUserRepository userRepository = Factory.getInstance().getRepositoryUser();
        userService = new UserService(userRepository);

        IPlateRepository plateRepository = Factory.getInstance().getRepositoryPlate();
        plateService = new PlateService(plateRepository);
    }

    /**
     * Metodo que permitira iniciar el servidor.
     */
    public void start() {
        openPort();
        while (true) {

            waitToClient();
            throwThread();
        }
    }

    /**
     * Metodo encargado de arrojar un hilo.
     */
    private static void throwThread() {
        new Thread(new RestaurantServerSocket()).start();
    }

    /**
     * Metodo que se encarga de Instanciar el server socket y abre el puerto
     * respectivo.
     */
    private static void openPort() {
        try {
            ssock = new ServerSocket(PORT);
            Logger.getLogger("Server").log(Level.INFO, "Servidor iniciado, escuchando por el puerto {0}", PORT);
        } catch (IOException ex) {
            Logger.getLogger(RestaurantServerSocket.class.getName()).log(Level.SEVERE, "Error del server socket al abrir el puerto", ex);
        }
    }

    /**
     * Metodo que se encarga de esperar a que el cliente se conecte y le
     * devuelve un socket.
     */
    private static void waitToClient() {
        try {
            socket = ssock.accept();
            Logger.getLogger("Socket").log(Level.INFO, "Socket conectado");
        } catch (IOException ex) {
            Logger.getLogger(RestaurantServerSocket.class.getName()).log(Level.SEVERE, "Error al abrir un socket", ex);
        }
    }

    /**
     * Metodo encargado de darle cuerpo a un hilo.
     */
    @Override
    public void run() {
        try {
            createStreams();
            readStream();
            closeStream();

        } catch (IOException ex) {
            Logger.getLogger(RestaurantServerSocket.class.getName()).log(Level.SEVERE, "Error al leer el flujo", ex);
        }
    }

    /**
     * Crea los flujos con el socket.
     *
     * @throws IOException
     */
    private void createStreams() throws IOException {
        output = new PrintStream(socket.getOutputStream());
        input = new Scanner(socket.getInputStream());
    }

    /**
     * Cierra los flujos de entrada y salida
     *
     * @throws IOException
     */
    private void closeStream() throws IOException {
        output.close();
        input.close();
        socket.close();
    }

    /**
     * Lee el flujo del socket, para ello extrae el flujo que envio el cliente.
     */
    private void readStream() {
        if (input.hasNextLine()) {
            // Extrae el flujo que envió la aplicación cliente
            String request = input.nextLine();
            processRequest(request);

        } else {
            output.flush();
            String errorJson = generateErrorJson();
            output.println(errorJson);
        }
    }

    /**
     * Metodo encargado de procesar una peticion proveniente del cliente.
     *
     * @param requestJson Peticion que proviene del socket del cliente en
     * formato json.
     */
    private void processRequest(String requestJson) {
        // Convertir la solicitud a objeto Protocol para poderlo procesar
        Gson gson = new Gson();
        Protocol protocolRequest = gson.fromJson(requestJson, Protocol.class);

        switch (protocolRequest.getResource()) {
            case "Restaurante":

                if (protocolRequest.getAction().equals("get")) {
                    // Consultar un Restaurante 
                    processGetRestaurant(protocolRequest);
                }

                if (protocolRequest.getAction().equals("post")) {
                    // Agregar un Restaurante     
                    processPostRestaurant(protocolRequest);
                }
                if (protocolRequest.getAction().equals("gets")) {
                    // Consultar todos los restaurantes
                    processGetListRestaurant();
                }
                break;
            case "Usuario":

                if (protocolRequest.getAction().equals("get")) {
                    // Consultar un Usuario 
                    processGetUser(protocolRequest);
                    // processGetListRestaurant(protocolRequest);
                }
                if (protocolRequest.getAction().equals("post")) {
                    // Agregar un Usuario     
                    processPostUser(protocolRequest);
                }
                break;
            case "Plate":
                if (protocolRequest.getAction().equals("post")) {
                    processPostPlate(protocolRequest);
                }
                 if (protocolRequest.getAction().equals("gets")) {
                    // Consultar todos los platos
                    processGetListPlate();
                }
        }

    }

    /**
     * Metodo encargado de procesar la solicitud de crear un usuario.
     *
     * @param protocolRequest
     */
    public void processPostUser(Protocol protocolRequest) {
        User varUser = new User();
        varUser.setAtrIdentification(protocolRequest.getParameters().get(0).getValue());
        varUser.setAtrUserName(protocolRequest.getParameters().get(1).getValue());
        varUser.setAtrPassword(protocolRequest.getParameters().get(2).getValue());
        varUser.setAtrNames(protocolRequest.getParameters().get(3).getValue());
        varUser.setAtrLastNames(protocolRequest.getParameters().get(4).getValue());
        varUser.setAtrCity(protocolRequest.getParameters().get(5).getValue());
        varUser.setAtrAddress(protocolRequest.getParameters().get(6).getValue());
        varUser.setAtrPhone(protocolRequest.getParameters().get(7).getValue());
        varUser.setAtrType(protocolRequest.getParameters().get(8).getValue());
        String response = userService.CreateUser(varUser);
        output.print(response);
    }

    /**
     * Procesa la solicitud de crear un Restaurante
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processPostRestaurant(Protocol protocolRequest) {

        Restaurant varRestaurant = new Restaurant();
        // Reconstruir el restaurant a partir de lo que viene en los parámetros
        varRestaurant.setAtrNitRest(((protocolRequest.getParameters().get(0).getValue())));
        varRestaurant.setAtrAdmiRest((protocolRequest.getParameters().get(1).getValue()));
        varRestaurant.setAtrNameRest(protocolRequest.getParameters().get(2).getValue());
        varRestaurant.setAtrAddressRest(protocolRequest.getParameters().get(3).getValue());
        varRestaurant.setAtrCityRest(protocolRequest.getParameters().get(4).getValue());
        varRestaurant.setAtrEmailRest(protocolRequest.getParameters().get(5).getValue());
        varRestaurant.setAtrPhoneNumberRest(protocolRequest.getParameters().get(5).getValue());
        String response = restaurantService.CreateRestaurant(varRestaurant);
        output.println(response);
    }

    /**
     * Procesa la solicitud de agregar un plato.
     *
     * @param protocolRequest
     */
    private void processPostPlate(Protocol protocolRequest) {
        Plate objPlate = new Plate();

        objPlate.setAtrNamePlate(protocolRequest.getParameters().get(0).getValue());
        objPlate.setAtrDescriptionPlate(protocolRequest.getParameters().get(1).getValue());
        objPlate.setAtrTypePlate(protocolRequest.getParameters().get(2).getValue());
        objPlate.setAtrPricePlate(protocolRequest.getParameters().get(3).getValue());
        
        String response = plateService.CreatePlate(objPlate);
        output.println(response);
    }

    /**
     * Procesa la solicitud para consultar todos los restaurantes.
     *
     * @param protocolRequest
     */
    private void processGetListRestaurant() {
        List<Restaurant> listRestaurant = restaurantService.ListRestaurant();
        if (!listRestaurant.isEmpty()) {
            output.println(ArrayToJSON(listRestaurant));
        } else {
            String errorJson = generateNotFoundErrorJson();
            output.println(errorJson);
        }

    }
    private void processGetListPlate() {
        List<Plate> listPlate = plateService.ListPlate();
        if (!listPlate.isEmpty()) {
            output.println(ArrayToJSONPlate(listPlate));
        } else {
            String errorJson = generateNotFoundErrorJson();
            output.println(errorJson);
        }

    }

    /**
     * Procesa la solicitud de consultar un restaurante en especifico.
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    private void processGetRestaurant(Protocol protocolRequest) {
        // Extraer el Id del primer parámetro
        String id = protocolRequest.getParameters().get(0).getValue();
        Restaurant rest = restaurantService.findRestaurant((id));
        if (rest == null) {
            String errorJson = generateNotFoundErrorJson();
            output.println(errorJson);
        } else {
            output.println(objectToJSONRestaurant(rest));
        }
    }

    /**
     * Procesa la solicitud para consultar un usuario.
     *
     * @param protocolRequest Protocolo de la solicitud
     */
    public void processGetUser(Protocol protocolRequest) {
        // Extraer el Id del primer parámetro
        String id = protocolRequest.getParameters().get(0).getValue();
        User user = userService.findUser((id));
        if (user == null) {
            String errorJson = generateNotFoundErrorJson();
            output.println(errorJson);
        } else {
            output.println(objectToJSONUser(user));
        }
    }

    /**
     * Convierte un objeto de tipo User a json para que el servidor lo envie
     * como respuesta por el socket.
     *
     * @param parUser tipo User.
     * @return User en formato json(String).
     */
    private String objectToJSONUser(User parUser) {
        Gson gson = new Gson();
        String strObject = gson.toJson(parUser);
        return strObject;
    }

    /**
     * Convierte el objeto Restaurant a json para que el servidor lo envie como
     * respuesta por el socket
     *
     * @param parRest tipo Restaurant.
     * @return Restaurante en formato json(String).
     */
    private String objectToJSONRestaurant(Restaurant parRest) {
        Gson gson = new Gson();
        String strObject = gson.toJson(parRest);
        return strObject;
    }

    /**
     * Genera un ErrorJson para un objeto cuando este no se encuentra.
     *
     * @return error en formato json
     */
    private String generateNotFoundErrorJson() {
        List<JsonError> errors = new ArrayList<>();
        JsonError error = new JsonError();
        error.setCode("404");
        error.setError("NOT_FOUND");
        error.setMessage("No se encontraron coincidencias");
        errors.add(error);

        Gson gson = new Gson();
        String errorsJson = gson.toJson(errors);

        return errorsJson;
    }

    /**
     * Genera un ErrorJson genérico en caso de fallar alguna solicitud no
     * controlada.
     *
     * @return error en formato json
     */
    private String generateErrorJson() {
        List<JsonError> errors = new ArrayList<>();
        JsonError error = new JsonError();
        error.setCode("400");
        error.setError("BAD_REQUEST");
        error.setMessage("Error en la solicitud");
        errors.add(error);

        Gson gson = new Gson();
        String errorJson = gson.toJson(errors);

        return errorJson;
    }

    /**
     * Convierte Una lista de Restaurantes a json para que el servidor lo envie
     * como respuesta al socket.
     *
     * @param parLista Lista de tipo Restaurant.
     * @return Lista de restaurantes en formato json (String).
     */
    private String ArrayToJSON(List<Restaurant> parLista) {
        Gson gson = new Gson();
        String strObject = gson.toJson(parLista);
        return strObject;
    }
 private String ArrayToJSONPlate(List<Plate> parLista) {
        Gson gson = new Gson();
        String strObject = gson.toJson(parLista);
        return strObject;
    }
}
