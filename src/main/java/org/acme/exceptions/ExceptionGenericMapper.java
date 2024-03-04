package org.acme.exceptions;

import jakarta.persistence.PersistenceException;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.time.LocalDateTime;

@Provider
public class ExceptionGenericMapper implements ExceptionMapper<Throwable> {

    @Context
    private UriInfo uriInfo;

    @Override
    public Response toResponse(Throwable exception) {
        StandardError error = new StandardError(LocalDateTime.now(), Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
                exception.getMessage(), "Ocorreu um erro que não está mapeado", uriInfo.getPath());

        // Mapeamento dos erros
        if(exception instanceof PersistenceException) saveError(exception);

        return Response.status(500).entity(error).build();
    }

    private Response saveError(Throwable exception) {
        int httpstatus = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
        StandardError error = new StandardError(LocalDateTime.now(), httpstatus,
                exception.getMessage(), "Erro ao salvar participante", uriInfo.getPath());
        return Response.status(500).entity(error).build();
    }
}
