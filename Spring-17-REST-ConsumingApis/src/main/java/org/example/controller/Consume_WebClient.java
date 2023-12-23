package org.example.controller;

import org.example.entity.Genre;
import org.example.entity.MovieCinema;
import org.example.repository.GenreRepository;
import org.example.repository.MovieCinemaRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class Consume_WebClient {
    private final MovieCinemaRepository movieCinemaRepository;
    private final GenreRepository genreRepository;
    private final WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();

    public Consume_WebClient(MovieCinemaRepository movieCinemaRepository, GenreRepository genreRepository) {
        this.movieCinemaRepository = movieCinemaRepository;
        this.genreRepository = genreRepository;
    }

    // ---------------------- WEBCLIENT CREATE API---------------------------------


    @GetMapping("/flux-movie-cinema")
    public Flux<MovieCinema> readAllCinemaFlux() {
        return Flux.fromIterable(movieCinemaRepository.findAll());
    }

//    @GetMapping("/mono-movie-cinema/{id}")
//    public Mono<MovieCinema> readById(@PathVariable("id") Long id) {
//
//        return Mono.just(movieCinemaRepository.findById(id).get());
//    }

    @GetMapping("/mono-movie-cinema/{id}")
    public ResponseEntity<Mono<MovieCinema>> readById(@PathVariable("id") Long id) {

        return ResponseEntity.ok(Mono.just(movieCinemaRepository.findById(id).get()));
    }

    @PostMapping("/create-genre")
    public Mono<Genre> createGenre(@RequestBody Genre genre) {

        Genre createGenre = genreRepository.save(genre);

        return Mono.just(createGenre);
    }

    @DeleteMapping("/delete/genre/{id}")
    public Mono<Void> deleteGenre(@PathVariable("id") Long id) {

        genreRepository.deleteById(id);

        return Mono.empty();
    }

    // ---------------------- WEBCLIENT CONSUME API---------------------------------

    @GetMapping("/flux")
    public Flux<MovieCinema> readWithWebClient() {

        return webClient
                .get()
                .uri("/flux-movie-cinema")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToFlux(MovieCinema.class);
    }

    @GetMapping("/mono/{id}")
    public Mono<MovieCinema> readMonoWithWebClient(@PathVariable("id") Long id) {
        return webClient
                .get()
                .uri("/mono-movie-cinema/{id}", id)
                .retrieve()
                .bodyToMono(MovieCinema.class);
    }
}
