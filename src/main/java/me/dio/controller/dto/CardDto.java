package me.dio.controller.dto;

import me.dio.domain.model.Card;

import java.math.BigDecimal;
import java.util.Objects;

public record CardDto(Long id, String number, BigDecimal limit) {

    public CardDto {
        // Validações simples
        Objects.requireNonNull(id, "ID não pode ser nulo");
        Objects.requireNonNull(number, "Número não pode ser nulo");
        if (limit != null && limit.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Limite não pode ser negativo");
        }
    }

    public CardDto(Card model) {
        this(model.getId(), model.getNumber(), model.getLimit());
    }

    public Card toModel() {
        // Não há necessidade de verificações adicionais, pois já foram feitas no construtor
        return new Card(id, number, limit);
    }
}
