package com.example;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.logging.Logger;

import org.jboss.resteasy.reactive.server.ServerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.vertx.core.http.HttpServerRequest;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.ext.Provider;

@Provider
@PreMatching
public class TesteFilter {
    private static final Logger LOGGER = Logger.getLogger(TesteFilter.class.getName());

    @Context
    HttpServerRequest request;

    @ServerRequestFilter
    public void doFilter(ContainerRequestContext containerRequestContext) throws IOException {
        LOGGER.info("Intercepting the request in the Filter");

        String body = new String(containerRequestContext.getEntityStream().readAllBytes());
        LOGGER.info("Original request body: " + body);

        ObjectMapper mapper = new ObjectMapper();
        Language language = mapper.readValue(body, Language.class);
        
        String modifiedBody = mapper.writeValueAsString(
                new Language("Modified-" + language.getType(),
                             "Modified-" + language.getName()
                            ));
        LOGGER.info("Modified request body: " + modifiedBody);

        containerRequestContext.setEntityStream(new ByteArrayInputStream(modifiedBody.getBytes()));
    }
}
