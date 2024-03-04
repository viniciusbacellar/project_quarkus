package org.acme.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entities.ParticipanteEntity;

@ApplicationScoped
public class ParticipanteRepository implements PanacheRepository<ParticipanteEntity> {


}
