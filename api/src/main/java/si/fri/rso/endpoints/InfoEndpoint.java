package si.fri.rso.endpoints;

import com.kumuluz.ee.common.runtime.EeRuntime;
import com.kumuluz.ee.logs.cdi.Log;
import si.fri.rso.services.configuration.AppProperties;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@Path("info")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
@Log
public class InfoEndpoint {

    private Logger log = Logger.getLogger(InfoEndpoint.class.getName());

    @Inject
    private AppProperties appProperties;

    @GET
    @Path("instanceid")
    public Response getInstanceId() {
        String instanceId =
                "{\"instanceId\" : \"" + EeRuntime.getInstance().getInstanceId() + "\"}";
        return Response.ok(instanceId).build();
    }


    @GET
    @Path("healthy/{value}")
    public Response setHealth(@PathParam(value = "value") boolean healthy) {
        appProperties.setHealthy(healthy);
        log.info("Setting health to " + healthy);
        return Response.ok().build();
    }

    @GET
    public Response info() {
        JsonObject json = Json.createObjectBuilder()
                .add("clani", Json.createArrayBuilder().add("ag9497").add("jk5456"))

                .add("opis_projekta", "Nas projekt implementira aplikacijo za iskanje in naročanje letalskih kart.")

                .add("mikrostoritve", Json.createArrayBuilder().add("TODO"))

                .add("github", Json.createArrayBuilder().add("https://github.com/RSO-FRI-Airline/search")
                                                                .add("https://github.com/RSO-FRI-Airline/booking")
                                                                .add("https://github.com/RSO-FRI-Airline/webapp"))

                .add("travis", Json.createArrayBuilder().add("https://travis-ci.org/RSO-FRI-Airline/search")
                                                                .add("https://travis-ci.org/RSO-FRI-Airline/booking")
                                                                .add("https://travis-ci.org/RSO-FRI-Airline/webapp"))

                .add("dockerhub", Json.createArrayBuilder().add("https://hub.docker.com/r/rsoairlines/fri-airlines-search/")
                                                                    .add("https://hub.docker.com/r/rsoairlines/fri-airlines-booking/")
                                                                    .add("https://hub.docker.com/r/rsoairlines/fri-airlines-webapp/"))
                .build();
        return Response.ok(json.toString()).build();
    }

}
