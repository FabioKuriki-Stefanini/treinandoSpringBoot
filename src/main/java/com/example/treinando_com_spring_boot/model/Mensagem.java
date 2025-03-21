package com.example.treinando_com_spring_boot.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Mensagem {
    private String mensagem;
}
