package com.example.treinando_com_spring_boot.controller;

import com.example.treinando_com_spring_boot.model.Anime;
import com.example.treinando_com_spring_boot.repository.Repositorio;
import com.example.treinando_com_spring_boot.service.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private Servico servico;

    @GetMapping("/animes")
    public ResponseEntity<?> listarAnimes(){
        return servico.listarTudo();
    }

    @GetMapping("/animes/{codigo}")
    public ResponseEntity<?> listarAnimePorId(@PathVariable Integer codigo){
        return servico.listarPorCodigo(codigo);
    }

    @PostMapping("/cadastrarAnime")
    public ResponseEntity<?> cadastrarAnime(@RequestBody Anime obj){
        return servico.cadastrar(obj);
    }

    //Atualizar
    @PutMapping("/alterarAnime")
    public ResponseEntity<?> alterarAnime(@RequestBody Anime obj){
        return servico.editar(obj);
    }

    //Deletar
    @DeleteMapping("/animes/{codigo}")
    public ResponseEntity<?> deletarAnime(@PathVariable Integer codigo){
        return servico.excluir(codigo);
    }

    //long == retornar números inteiros maiores que o int suporta
    @GetMapping("/animes/contador")
    public long contador(){
        return anime.count();
    }

    @GetMapping("/animes/ordenar")
    public List<Anime> ordenarCrescente(){
        return anime.findByOrderByNome();
    }

    @GetMapping("/animes/ordenarDescrecente")
    public List<Anime> ordenarDescrecente(){
        return anime.findByOrderByNomeDesc();
    }

    @GetMapping("/animes/contem={termo}")
    public List<Anime> listarQuantoConter(@PathVariable String termo){
        return anime.findByNomeContaining(termo);
    }

    @GetMapping("/animes/like={termo}")
    public List<Anime> sqlAnimesLike(@PathVariable String termo){
        return anime.animeLikeTermo(termo);
    }

    //Para exibir um status
    //Utilizado para informar o front
    @GetMapping("/status")
    public ResponseEntity<?> exibirStatus(){
        return new ResponseEntity<>(HttpStatus.CREATED);
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
