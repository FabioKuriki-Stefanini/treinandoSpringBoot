package com.example.treinando_com_spring_boot.repository;

import com.example.treinando_com_spring_boot.model.Anime;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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

    List<Anime> findByOrderByNome();
    List<Anime> findByOrderByNomeDesc();

    //Containing == LIKE do MYSQL
    List<Anime> findByNomeContaining(String termo);

    //Começa com
    //List<Anime> findByNomeStartsWith(String termo);

    //Termina com
    //List<Anime> findByNomeEndsWith(String termo);

    //@Query permite a execução de comandos MYSQL
    @Query(value = "select * from anime where nome like :termo", nativeQuery = true)
    List<Anime> animeLikeTermo(String termo);

    Integer countByCodigo(Integer codigo);
}
