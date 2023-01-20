package com.devcaput.loja.resources;

import com.devcaput.loja.entity.Product;
import com.devcaput.loja.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController     //define que essa classe vai ser um recurso REST
@RequestMapping(value = "/products") //mapeamento de url: Define o caminho
                                        // pelo qual esse recurso irá responder
public class ProductResources {

    @Autowired //injeção de dependência de outra categoria
            // para que ele funcione é necessário colocar o @Component na categoria
        //que você deseja chamar aqui
    private ProductRepository productRepository;

    @GetMapping//mapeia o método que será chamado pelo caminho no @RequestMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> list = productRepository.findAll();//busca os dados do CategoryRepository
        return ResponseEntity.ok().body(list);
        //.ok() é um método que vai instanciar uma resposta do protocolo http

//quando for responder algo da requisição, você precisa dizer o tipo da resposta
        //ResponseEntity é um tipo especial genérico "generics", que já encapsula
        //uma resposta http.

        //nessa estrutura eu retornaria um status 200 - ok e a lista criada
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product obj = productRepository.findById(id).get();
        return ResponseEntity.ok().body(obj);
        //findById é uma annotation que vai reconhecer o valor que for
        //colocado na url
    }
}
