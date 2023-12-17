package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Genre extends BaseEntity {

    private String name;

    @ManyToOne(fetch = "genreList")
    @JsonIgnore
    private List<Movie> movieList;

}
