package com.example.treinando_com_spring_boot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


//@Data == fornecer o Get e Set
@Data
//@AllArgsConstructor == constructor com todos os argumentos
//@NoArgsConstructor == constructor vazio
//@Entity para que seja criada a entidade no banco de dados
@Entity
public class Anime {
    //@Id para informar que se trata de uma chave primária
    @Id
    //permite o auto increment a partir de 1
    //@Generation.Type.IDENTITY não funcionou pois
    //não foi definido o auto_increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private String nome;

}
