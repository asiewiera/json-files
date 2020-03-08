package com.asiewiera.jsonfiles.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "address")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text", nullable = false, columnDefinition = "TEXT")
    private String text;

    @Column(name = "correct", nullable = false)
    private Boolean isCorrect;

/*    @ManyToOne
    @JoinColumn(name = "test_id")
    private TestDao testDao;*/




}
