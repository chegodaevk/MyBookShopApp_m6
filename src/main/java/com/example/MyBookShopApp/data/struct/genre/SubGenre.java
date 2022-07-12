package com.example.MyBookShopApp.data.struct.genre;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "subgenres")
public class SubGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sub_genre")
    private String subGenre;

    @Column(name = "quantity_books")
    private Integer quantityBooks;

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    @JsonIgnore
    private GenreEntity genreEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubGenre() {
        return subGenre;
    }

    public void setSubGenre(String subGenre) {
        this.subGenre = subGenre;
    }

    public Integer getQuantityBooks() {
        return quantityBooks;
    }

    public void setQuantityBooks(Integer quantityBooks) {
        this.quantityBooks = quantityBooks;
    }

    public GenreEntity getGenreEntity() {
        return genreEntity;
    }

    public void setGenreEntity(GenreEntity genreEntity) {
        this.genreEntity = genreEntity;
    }
}
