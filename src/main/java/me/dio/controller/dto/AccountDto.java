package me.dio.controller.dto;

import me.dio.domain.model.Account;

import java.math.BigDecimal;
import java.util.Objects;

public record AccountDto(Long id, String number, String agency, BigDecimal balance, BigDecimal limit) {

    public AccountDto {
        // Validações simples
        Objects.requireNonNull(id, "ID não pode ser nulo");
        Objects.requireNonNull(number, "Número não pode ser nulo");
        Objects.requireNonNull(agency, "Agência não pode ser nula");
        if (balance != null && balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Saldo não pode ser negativo");
        }
        if (limit != null && limit.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Limite não pode ser negativo");
        }
    }

    public AccountDto(Account model) {
        this(model.getId(), model.getNumber(), model.getAgency(), model.getBalance(), model.getLimit());
    }

    public Account toModel() {
        // Não há necessidade de verificações adicionais, pois já foram feitas no construtor
        return new Account(id, number, agency, balance, limit);
    }
}
