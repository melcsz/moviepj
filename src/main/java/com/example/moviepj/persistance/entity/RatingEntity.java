package com.example.moviepj.persistance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RatingEntity {
    @Id
    @Column(name = "movieId")
    private Integer movieId;

    @Column(name = "likes")
    private Integer likes;

    @Column(name = "rating")
    private Double rating;
}
