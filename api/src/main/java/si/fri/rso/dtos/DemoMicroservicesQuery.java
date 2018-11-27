package si.fri.rso.dtos;

import javax.json.Json;
import javax.json.JsonArrayBuilder;

public class DemoMicroservicesQuery {
    public String[] microservices;

    public JsonArrayBuilder getJsonArrayBuilder() {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for(String microservice : microservices) {
            builder.add(microservice);
        }
        return builder;
    }
}
