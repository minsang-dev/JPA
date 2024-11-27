package com.sparta.currency_user.user.entity;

import com.sparta.currency_user.common.entity.TimeBaseEntity;
import com.sparta.currency_user.exchange.entity.Exchange;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class User extends TimeBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Exchange> exchanges;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User() {}
}