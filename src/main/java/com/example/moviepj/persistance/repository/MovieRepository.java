package com.example.moviepj.persistance.repository;

import com.example.moviepj.persistance.entity.MovieEntity;
import com.example.moviepj.persistance.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

}
