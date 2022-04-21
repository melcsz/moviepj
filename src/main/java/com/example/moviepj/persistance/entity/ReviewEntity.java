package com.example.moviepj.persistance.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReviewEntity {

    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
