package com.devcaput.loja.repositories;

import com.devcaput.loja.entity.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component //é um estereótipo, e as especializações dele são @Repository, @Service e @Controller.
//significa que a mesma usará o padrão de injeção de depêndencia, e será elegível para
//auto-configuração e auto-detecção de beans anotados à partir de escaneamento de classpath
// que o IoC Container do Spring faz
public class CategoryRepository {
 //CategoryRepository é uma classe especial que acessa os dados
//terá uma responsabilidade de manipular os dados referente à entidade Category

    private Map<Long, Category> map = new HashMap<>();
    //dicionário ou mapa: essa interface é uma coleção de pares de chaves/valor
    //nesse caso estamos mockando na memória apenas para testes de implementação
    //posteriormente não usaremos pois iremos implementar um banco de dados

    public void save(Category obj){
        map.put(obj.getId(), obj);
    }
    public Category findById(Long id){
        return map.get(id);
    }
    public List<Category> findAll(){
        return new ArrayList<Category>(map.values());
    }
}
