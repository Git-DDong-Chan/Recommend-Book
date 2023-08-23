package com.example.rb.book;

import com.example.rb.user.SiteUser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Book {

    @Id
    private String title;

    @Column
    private String author;

    @Column
    private Integer count=0;

    @ManyToOne
    private SiteUser user;
}