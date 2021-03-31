/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.commons.infra;

/**
 *
 * @author Beca98
 */
public class JsonError {

    /**
     * Ej. 404
     */
    private String code;
    /**
     * Ej. Not_found
     */
    private String error;
    /**
     * Ej. La cédula del cliente no existe
     */
    private String message;

    /**
     * Constructor por defecto
     */
    public JsonError() {
    }

    /**
     * Constructor parametrizado
     *
     * @param code
     * @param error
     * @param message
     */
    public JsonError(String code, String error, String message) {
        this.code = code;
        this.error = error;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
