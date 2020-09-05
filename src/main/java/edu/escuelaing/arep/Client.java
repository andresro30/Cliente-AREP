package edu.escuelaing.arep;

import edu.escuelaing.arep.Service.Service;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import static spark.Spark.get;
import static spark.Spark.port;

public class Client {

    public static void main(String[] args) {
        HttpResponse<String> response = null;
        try {
            response = Unirest.get("https://client-arep-ar.herokuapp.com/result?operation=sin&number=0.5")
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        System.out.println(response.getBody());
    }
}
