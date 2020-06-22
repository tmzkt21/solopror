package com.example.web.Entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int seq;
    @Column(length = 20)
    private String userId;
    @Column(length = 20)
    private String password;
    @Column(length = 20)
    private String email;
    @Builder
    public User(String userId, String password, String email, String addr) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.email = addr;
    }
}

