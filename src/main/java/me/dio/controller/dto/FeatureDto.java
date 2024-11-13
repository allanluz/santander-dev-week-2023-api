package me.dio.controller.dto;

import me.dio.domain.model.Feature;

import java.util.Objects;

public record FeatureDto(Long id, String icon, String description) {

    public FeatureDto {
        // Validações simples
        Objects.requireNonNull(id, "ID não pode ser nulo");
        Objects.requireNonNull(icon, "Ícone não pode ser nulo");
        Objects.requireNonNull(description, "Descrição não pode ser nula");
    }

    public FeatureDto(Feature model) {
        this(model.getId(), model.getIcon(), model.getDescription());
    }

    public Feature toModel() {
        // Não há necessidade de verificações adicionais, pois já foram feitas no construtor
        return new Feature(id, icon, description);
    }
}
