package com.example.lab6.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity @Table(name="Favorites")
public class Favorite {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Temporal(TemporalType.DATE)
    Date likedate;

    @ManyToOne @JoinColumn(name="userid")
    User user;

    @ManyToOne @JoinColumn(name="videoid")
    Video video;
}
