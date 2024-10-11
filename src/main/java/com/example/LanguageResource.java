package com.example;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.Valid;

@Path("/language")
@ApplicationScoped
public class LanguageResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response processLanguage(@Valid Language language) {
        System.out.println("Entered the POST processLanguage method");
        return Response.ok(language).build();
    }
}
