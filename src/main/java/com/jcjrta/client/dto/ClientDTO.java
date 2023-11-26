package com.jcjrta.client.dto;

import com.jcjrta.client.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class ClientDTO {
    private Long id;

    @NotBlank(message = "Nome não pode ser vazio")
    private String name;
    private String cpf;
    private Double income;

    @PastOrPresent(message = "Data de nascimento não pode ser dada futura")
    private LocalDate birthDate;
    private Integer children;

    public ClientDTO(Client c) {
        id = c.getId();
        name = c.getName();
        cpf = c.getCpf();
        income = c.getIncome();
        birthDate = c.getBirthDate();
        children = c.getChildren();
    }

    public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
