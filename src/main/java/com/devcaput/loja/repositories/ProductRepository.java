package com.devcaput.loja.repositories;

import com.devcaput.loja.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}


/**
@Component //é um estereótipo, e as especializações dele são @Repository, @Service e @Controller.
//significa que a mesma usará o padrão de injeção de depêndencia, e será elegível para
//auto-configuração e auto-detecção de beans anotados à partir de escaneamento de classpath
// que o IoC Container do Spring faz
public class ProductRepository {
 //ProductRepository é uma classe especial que acessa os dados
//terá uma responsabilidade de manipular os dados referente à entidade Product

    private Map<Long, Product> map = new HashMap<>();
    //dicionário ou mapa: essa interface é uma coleção de pares de chaves/valor
    //nesse caso estamos mockando na memória apenas para testes de implementação
    //posteriormente não usaremos pois iremos implementar um banco de dados

    public void save(Product obj){
        map.put(obj.getId(), obj);
    }
    public Product findById(Long id){
        return map.get(id);
    }
    public List<Product> findAll(){
        return new ArrayList<Product>(map.values());
    }
}
**/