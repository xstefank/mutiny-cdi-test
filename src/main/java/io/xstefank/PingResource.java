package io.xstefank;

import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ping")
public class PingResource {

    @Inject
    RequestBean requestBean;

    @Inject
    MyDelegate delegate;

    Uni<String> testUni;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        System.out.println("Top level Request bean " + requestBean);

        if (testUni == null) {
            testUni = Uni.createFrom().item(delegate::call);
        }

        System.out.println(testUni.await().indefinitely());

        return "Hello RESTEasy";
    }
}
