package org.acme.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.acme.dtos.ParticipanteEntityDTO;
import org.acme.entities.ParticipanteEntity;
import org.acme.services.ParticipanteService;

import java.util.List;

@Path("/api/v1/participante")
public class ParticipanteController {

    @Inject
    ParticipanteService participanteService;

    @GET
    public Response findAllParticipantes() {
        List<ParticipanteEntity> participanteEntityList = participanteService.findAll();
        return Response.ok(participanteEntityList).build();
    }

    @POST
    public Response saveParticipante(ParticipanteEntityDTO participanteEntityDTO) {
        participanteService.save(participanteEntityDTO);
        return Response.noContent().build();
    }
}
