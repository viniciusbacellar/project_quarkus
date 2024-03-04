package org.acme.enums;

import lombok.Getter;

@Getter
public enum StatusEnum {

    ATIVO(1, "Ativo"),
    INATIVO(2, "Inativo");

    private final int id;
    private final String name;

    StatusEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static StatusEnum getById(int id) {
        for (StatusEnum status : values()) {
            if (status.getId() == id) {
                return status;
            }
        }
        throw new IllegalArgumentException("Não existe Status com o id: " + id);
    }
}
