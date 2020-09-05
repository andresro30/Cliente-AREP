package edu.escuelaing.arep.Service;

import kong.unirest.*;
import org.json.JSONObject;
import spark.Request;
import spark.Response;

import static spark.Spark.get;
import static spark.Spark.port;

public class Service {

    public static String get(String op, String num) {
        HttpResponse<String> response = null;
        try {
            response = Unirest.get("https://service-trigcalculator.herokuapp.com//calculateTrigonometric?operation="+op+"&number="+num)
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        System.out.println(response.getBody());
        return response.getBody();
    }

    /**
     * Método enccargado de definir el puerto por donde corre el programa
     *
     * @return variable de tipo int
     */
    public static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 46000;
    }

}
