package com.example;

import java.util.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/language")
@ApplicationScoped
public class LanguageResource {
    private static final Logger LOGGER = Logger.getLogger(LanguageResource.class.getName());

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response processLanguage(@Valid Language language) {
        LOGGER.info("Entered the POST processLanguage method");
        LOGGER.info(String.format("Object received: {'type': %s, 'name': %s}",
                language.getType(),
                language.getName()));

        return Response.ok(language).build();
    }
}
