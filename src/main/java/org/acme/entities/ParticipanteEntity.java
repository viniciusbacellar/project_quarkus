package org.acme.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.acme.enums.StatusEnum;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "participante")
@Getter
@Setter
@ToString
public class ParticipanteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String document;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private StatusEnum statusEnum;
}
