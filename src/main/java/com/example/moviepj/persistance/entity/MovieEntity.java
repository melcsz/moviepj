package com.example.moviepj.persistance.entity;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "movie")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "title is mandatory")
    @Column(name = "title")
    private String title;

    @NotBlank(message = "genre is mandatory")
    @Column(name = "genre")
    private String genre;

    @Column(name = "critic_rating")
    private Double criticRating;

    @NotBlank(message = "creator is mandatory")
    @Column(name = "creator")
    private String creator;

    @NotBlank(message = "company is mandatory")
    @Column(name = "company")
    private String company;

    @NotBlank(message = "release year is mandatory")
    @Column(name = "release_year")
    private Integer releaseYear;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    @JsonUnwrapped
    private RatingEntity rating;


    @Transient
    private List<ReviewEntity> reviews;

    public MovieEntity(Long id, String title, String genre, Double criticRating, String creator, String company, Integer releaseYear) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.criticRating = criticRating;
        this.creator = creator;
        this.company = company;
        this.releaseYear = releaseYear;
    }

    public MovieEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getCriticRating() {
        return criticRating;
    }

    public void setCriticRating(Double criticRating) {
        this.criticRating = criticRating;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public RatingEntity getRating() {
        return rating;
    }

    public void setRating(RatingEntity rating) {
        this.rating = rating;
    }

    public List<ReviewEntity> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewEntity> reviews) {
        this.reviews = reviews;
    }
}
