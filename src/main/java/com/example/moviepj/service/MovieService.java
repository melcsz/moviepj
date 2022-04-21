package com.example.moviepj.service;

import com.example.moviepj.csv.Parser;
import com.example.moviepj.persistance.repository.MovieRepository;
import com.example.moviepj.persistance.entity.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void save(MultipartFile file) {
        try {
            List<MovieEntity> listOfMovies = Parser.csvToMovieEntity(file.getInputStream());
            for (MovieEntity movie : listOfMovies) {
                if (!(movieRepository.existsById(movie.getId()))) {
                    movieRepository.save(movie);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }
}