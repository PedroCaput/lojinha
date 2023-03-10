package com.devcaput.loja.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//annotation para dizer que o
    // ID deve ser autoincrementado no banco de dados
    private Long id;
    private String name;
    private Double price;

    @ManyToOne//muitos produtos para uma categoria
    @JoinColumn(name = "category_id")//digo para o banco qual o nome da chave estrangeira que
    //estará no banco relacional
    private Category category;//passa a ser uma chave estrangeira na categoria de produto

    public Product(){
}
    public Product(Long id, String name, Double price, Category category){
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }
    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if(id == null){
            if(other.id != null)
                return false;
        }else if(!id.equals(other.id))
            return false;
        return true;
    }
}
