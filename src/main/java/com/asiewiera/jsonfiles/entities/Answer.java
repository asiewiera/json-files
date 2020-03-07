package com.asiewiera.jsonfiles.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "address")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "correct", nullable = false)
    private Boolean isCorrect;
}
