package edu.escuelaing.arep;

import kong.unirest.*;
import org.json.JSONObject;
import spark.Request;
import spark.Response;

import static spark.Spark.get;
import static spark.Spark.port;

public class Service {

    public static void main( String[] args ) {
        port(getPort());
        httpConection();
    }

    private static void httpConection() {
        HttpResponse<String> response = null;
        try {
            response = Unirest.get("https://fachadeserver-orlando.herokuapp.com/API/calculator?operation=sin&number=0.5")
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        System.out.println(response.getBody());
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
        return 45555;
    }

}
