package com.example;

import io.vertx.core.http.HttpServerRequest;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;
import jakarta.ws.rs.core.Context;

@Provider
@PreMatching
public class TesteFilter implements ContainerRequestFilter {

    @Context
    HttpServerRequest request;

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        System.out.println("TesteFilter intercepted the request");
        
        request.bodyHandler(buffer -> {
            // This is non-blocking; the body is now fully received
            String body = buffer.toString();

            System.out.println("Original request body: " + body);
        });
    }
}
