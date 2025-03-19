package com.example.treinando_com_spring_boot.repository;

import com.example.treinando_com_spring_boot.model.Anime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Define que será um repositório, onde será feito o CRUD
@Repository
//extends serve para herdar a classe CrudRepository
//onde é preciso informar o modelo/entidade e o tipo da chave primária
//que deve ser uma classe
public interface Repositorio extends CrudRepository<Anime, Integer> {
    List<Anime> findAll();

    Anime findByCodigo(Integer codigo);

    //findByNomeAtributo(tipoAtributo paramentro)
    //Ex: findByNome(String nome)
    //Utilizei Nome porque ele é um atributo existente
    //e defini um parâmetro String pois nome é String
    //Outro tipo de parâmetro daria erro
}
