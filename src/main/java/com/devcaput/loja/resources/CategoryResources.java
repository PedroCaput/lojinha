package com.devcaput.loja.resources;

import com.devcaput.loja.entity.Category;
import com.devcaput.loja.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController     //define que essa classe vai ser um recurso REST
@RequestMapping(value = "/categories") //mapeamento de url: Define o caminho
                                        // pelo qual esse recurso irá responder
public class CategoryResources {

    @Autowired //injeção de dependência de outra categoria
            // para que ele funcione é necessário colocar o @Component na categoria
        //que você deseja chamar aqui
    private CategoryRepository categoryRepository;

    @GetMapping//mapeia o método que será chamado pelo caminho no @RequestMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = categoryRepository.findAll();//busca os dados do CategoryRepository
        return ResponseEntity.ok().body(list);
        //.ok() é um método que vai instanciar uma resposta do protocolo http

//quando for responder algo da requisição, você precisa dizer o tipo da resposta
        //ResponseEntity é um tipo especial genérico "generics", que já encapsula
        //uma resposta http.

        //nessa estrutura eu retornaria um status 200 - ok e a lista criada
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category cat = categoryRepository.findById(id);
        return ResponseEntity.ok().body(cat);
        //findById é uma annotation que vai reconhecer o valor que for
        //colocado na url
    }
}
