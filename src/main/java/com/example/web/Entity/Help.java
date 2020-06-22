package com.example.web.Entity;

import lombok.Builder;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity(name="help") @Component
public class Help {
    //랭킹,소환사,티어,LP,레벨,승률
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;

    @Column(length = 200, nullable = false)
    private String rank;

    @Column(length = 200, nullable = false)
    private String user;

    @Column(length = 200, nullable = false)
    private String tear;

    @Column(length = 200, nullable = false)
    private String point;

    @Column(length = 200, nullable = false)
    private String level;

    @Column(length = 200, nullable = false)
    private String wins;



    @Builder
    public Help(String rank, String user, String tear,
                String point, String level, String wins) {

        this.rank = rank;
        this.user = user;
        this.tear = tear;
        this.point = point;
        this.level = level;
        this.wins = wins;


    }

    public Help() {}

    @Override
    public String toString() {
        return "Help{" +
                "userNo=" + userNo +
                ", rank='" + rank + '\'' +
                ", user='" + user + '\'' +
                ", tear='" + tear + '\'' +
                ", point='" + point + '\'' +
                ", level='" + level + '\'' +
                ", wins='" + wins + '\'' +
                '}';
    }

    public Long getUserNo() {
        return userNo;
    }

    public void setUserNo(Long userNo) {
        this.userNo = userNo;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTear() {
        return tear;
    }

    public void setTear(String tear) {
        this.tear = tear;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }
}
