package com.devcaput.loja.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id; //poderia ser Integer/ não poderia ser int pq o tipo Upper permite receber nulo
                    // também recebe todos os recursos de herança e polimorfismo
    private String name;

    public Category(){
    }

    public Category(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) && Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;//Objects.hash(id, name);
    }
}
