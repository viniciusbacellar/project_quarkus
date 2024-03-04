package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;
import org.acme.dtos.ParticipanteEntityDTO;
import org.acme.entities.ParticipanteEntity;
import org.acme.enums.StatusEnum;
import org.acme.repositories.ParticipanteRepository;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class ParticipanteService {

    @Inject
    ParticipanteRepository participanteRepository;

    public List<ParticipanteEntity> findAll() {
        return participanteRepository.findAll().list();
    }

    @Transactional(rollbackOn = Exception.class)
    public void save(ParticipanteEntityDTO participanteEntityDTO) {
        try {
            participanteRepository.persist(setParticipante(participanteEntityDTO));
        }
        catch (Exception e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    private ParticipanteEntity setParticipante(ParticipanteEntityDTO participanteEntityDTO) {
        ParticipanteEntity participante = new ParticipanteEntity();
        participante.setName(participanteEntityDTO.name());
        participante.setDocument(participanteEntityDTO.document());
        participante.setCreatedAt(LocalDateTime.now());
        participante.setUpdatedAt(LocalDateTime.now());
        participante.setStatusEnum(StatusEnum.ATIVO);
        return participante;
    }

}
