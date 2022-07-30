package com.stajokulu.message;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "message")
    private String value;
}
