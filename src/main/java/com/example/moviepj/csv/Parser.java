package com.example.moviepj.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.example.moviepj.persistance.entity.MovieEntity;
import com.example.moviepj.persistance.entity.UserEntity;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


public class Parser {
    public static List<UserEntity> csvToUserEntity(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
             CSVParser csvParser = new org.apache.commons.csv.CSVParser(fileReader,
                     CSVFormat.EXCEL.withDelimiter(',')
                             .withSkipHeaderRecord(true)
                             .withTrim()
                             .withIgnoreEmptyLines(true)
                             .withQuote(null)
                             .withFirstRecordAsHeader()
                             .withIgnoreHeaderCase()
                             .withHeader(
                                     "id", "first_name", "last_name", "email", "password",
                                     "age", "city", "country"))) {

            List<UserEntity> entityList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                if (csvRecord.size() >= csvParser.getHeaderMap().size()) {
                    if (Integer.parseInt(csvRecord.get("age")) > 16) {
                        UserEntity userEntity = new UserEntity(Long.parseLong(csvRecord.get("id")), csvRecord.get("first_name"),
                                csvRecord.get("last_name"), csvRecord.get("email"), csvRecord.get("password"),
                                Integer.parseInt(csvRecord.get("age")), csvRecord.get("city"),
                                csvRecord.get("country"));
                        entityList.add(userEntity);
                    }
                }
            }
            return entityList;
        } catch (IOException e) {
            throw new RuntimeException("failed to parse CSV file: " + e.getMessage());
        }
    }

    public static List<MovieEntity> csvToMovieEntity(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
             CSVParser csvParser = new org.apache.commons.csv.CSVParser(fileReader,
                     CSVFormat.DEFAULT.withDelimiter(',')
                             .withSkipHeaderRecord(true)
                             .withTrim()
                             .withIgnoreEmptyLines(true)
                             .withQuote('"')
                             .withFirstRecordAsHeader()
                             .withIgnoreHeaderCase()
                             .withHeader(
                                     "id", "movie_title", "movie_genre", "critic_rating", "movie_creator",
                                     "movie_company", "movie_release_year"))) {

            List<MovieEntity> entityList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                if (csvRecord.size() >= csvParser.getHeaderMap().size()) {
                    MovieEntity movieEntity = new MovieEntity(Long.parseLong(csvRecord.get("id")), csvRecord.get("movie_title"),
                            csvRecord.get("movie_genre"), Double.parseDouble(csvRecord.get("critic_rating")), csvRecord.get("movie_creator"),
                            csvRecord.get("movie_company"), Integer.parseInt(csvRecord.get("movie_release_year")));
                    entityList.add(movieEntity);
                }
            }
            return entityList;
        } catch (IOException e) {
            throw new RuntimeException("failed to parse CSV file: " + e.getMessage());
        }
    }
}

