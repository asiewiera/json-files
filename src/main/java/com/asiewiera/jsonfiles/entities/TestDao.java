package com.asiewiera.jsonfiles.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "test")
public class TestDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "subCategory", nullable = false)
    private String subCategory;

    @Column(name = "multiSelect", nullable = false)
    private Boolean multiSelect;

    @Column(name = "text", nullable = false, columnDefinition = "TEXT")
    private String text;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "test_id")

    private List<Answer> answerList;

    @Column(name = "explanation", nullable = false, columnDefinition = "TEXT")
    private String explanation;


}
