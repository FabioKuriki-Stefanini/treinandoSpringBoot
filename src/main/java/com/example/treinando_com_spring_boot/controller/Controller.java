package com.example.treinando_com_spring_boot.controller;

import com.example.treinando_com_spring_boot.model.Anime;
import com.example.treinando_com_spring_boot.repository.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Para dizer que se trata de controller
//responsável pelas requisições
@RestController
//endpoint == caminho para acessar essa classe
@RequestMapping("")
public class Controller {

    //Evita a necessidade de criar a instância
    //= new Repositorio
    @Autowired
    private Repositorio anime;

    @GetMapping("/animes")
    public List<Anime> listarAnimes(){
        return anime.findAll();
    }

    @GetMapping("/animes/{codigo}")
    public Anime listarAnimePorId(@PathVariable Integer codigo){
        return anime.findByCodigo(codigo);
    }

    @PostMapping("/cadastrarAnime")
    public Anime cadastrarAnime(@RequestBody Anime obj){
        return anime.save(obj);
    }

    //Atualizar
    @PutMapping("/alterarAnime")
    public Anime alterarAnime(@RequestBody Anime obj){
        return anime.save(obj);
    }

    //Deletar
    @DeleteMapping("/animes/{codigo}")
    public void deletarAnime(@PathVariable Integer codigo){
        Anime animeListado = listarAnimePorId(codigo);
        anime.delete(animeListado);
    }

    //GET == Read
    @GetMapping
    public String boasVindas(){
        return "Seja bem-vindo(a)";
    }

    //@PathVariable define que o parametro irá receber
    //{nome}
    @GetMapping("/{nome}")
    public String boasVindas(@PathVariable String nome){
        return "Seja bem-vindo(a) " + nome;
    }

    //Aqui o dado não foi inserido no banco
    //apenas um teste do POST
    //POST == Create
    //@RequestBody == pega os dados inseridos e coloca no
    //parâmetro
    @PostMapping("/animePost")
    public Anime anime(@RequestBody Anime a){
        return a;
    }
}
