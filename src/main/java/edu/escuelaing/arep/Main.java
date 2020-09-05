package edu.escuelaing.arep;

import edu.escuelaing.arep.Service.Service;
import kong.unirest.*;
import org.json.JSONObject;
import static spark.Spark.get;
import static spark.Spark.port;

public class Main {
    public static void main(String[] args) {
        port(getPort());
        get("/result",(req,res)->{
            String operation = req.queryParams("operation");
            String number = req.queryParams("number");
            JSONObject jsonObject = new JSONObject(new Service().get(operation,number));
            return jsonObject;
        });
    }

    public static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 45555;
    }

}
