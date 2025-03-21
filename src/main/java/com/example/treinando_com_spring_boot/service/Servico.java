package com.example.treinando_com_spring_boot.service;

import com.example.treinando_com_spring_boot.model.Anime;
import com.example.treinando_com_spring_boot.model.Mensagem;
import com.example.treinando_com_spring_boot.repository.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Servico {
    @Autowired
    private Mensagem mensagem;

    @Autowired
    private Repositorio acao;

    public ResponseEntity<?> cadastrar(Anime obj){
        if(obj.getNome().equals("")){
            mensagem.setMensagem("O campo nome está vazio");
            return new ResponseEntity<>(mensagem,HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>(acao.save(obj), HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> listarTudo(){
        return new ResponseEntity<>(acao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> listarPorCodigo(Integer codigo){
        if(acao.countByCodigo(codigo) == 0){
            mensagem.setMensagem("Código não encontrado");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(acao.findByCodigo(codigo), HttpStatus.OK);
        }
    }

    public ResponseEntity<?> editar(Anime obj){
        if(acao.countByCodigo(obj.getCodigo()) == 0){
            mensagem.setMensagem("Código não encontrado");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }
        else if(obj.getNome().equals("")){
            mensagem.setMensagem("O campo nome está vazio");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>(acao.save(obj), HttpStatus.OK);
        }
    }

    public ResponseEntity<?> excluir(Integer codigo){
        if(acao.countByCodigo(codigo) == 0){
            mensagem.setMensagem("O código informado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }
        else{
            Anime obj = acao.findByCodigo(codigo);
            acao.delete(obj);

            mensagem.setMensagem("Exclusão realizada com sucesso");
            return  new ResponseEntity<>(mensagem, HttpStatus.OK);
        }
    }
}
