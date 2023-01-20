package com.devcaput.loja.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeId;
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
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //poderia ser Integer/ não poderia ser int pq o tipo Upper permite receber nulo
                    // também recebe todos os recursos de herança e polimorfismo
    private String name;

    @JsonIgnore//annotation que efetua um préprocessamento para dizer que não é para serializar a lista de
    //produtos de uma categoria
    @OneToMany(mappedBy = "category")//aqui eu faço o inverso do Product e coloco o nome do atributo
    private List<Product> products = new ArrayList<>();
    public Category(){
    }

    public Category(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
/**
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) && Objects.equals(name, category.name);
    }
    **/
    public List<Product> getProducts(){
        return products;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;//Objects.hash(id, name);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Category other = (Category) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
