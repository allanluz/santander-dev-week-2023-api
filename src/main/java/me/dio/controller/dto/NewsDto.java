package me.dio.controller.dto;

import me.dio.domain.model.News;

import java.util.Objects;

public record NewsDto(Long id, String icon, String description) {

    public NewsDto {
        // Validações simples
        Objects.requireNonNull(id, "ID não pode ser nulo");
        Objects.requireNonNull(icon, "Ícone não pode ser nulo");
        Objects.requireNonNull(description, "Descrição não pode ser nula");
    }

    public NewsDto(News model) {
        this(model.getId(), model.getIcon(), model.getDescription());
    }

    public News toModel() {
        // Não há necessidade de verificações adicionais, pois já foram feitas no construtor
        return new News(id, icon, description);
    }
}
