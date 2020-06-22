package com.example.web.Entity;

import lombok.Builder;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity(name="car")
@Component
public class Car {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long carNo;

        @Column(length = 200, nullable = false)
        private String img;

        @Column(length = 200, nullable = false)
        private String name;

        @Column(length = 200, nullable = false)
        private String year;

        @Column(length = 200, nullable = false)
        private String fuel;

        @Column(length = 200, nullable = false)
        private String km;

        @Column(length = 200, nullable = false)
        private String price;

        @Column(length = 200, nullable = false)
        private String span;

        @Column(length = 200, nullable = false)
        private String dealer;





        @Builder
        public Car(String img, String name, String year,
                    String fuel,String km,String price,String span,String dealer) {

            this.img = img;
            this.name = name;
            this.year = year;
            this.fuel = fuel;
            this.fuel = fuel;
            this.km = km;
            this.price = price;
            this.span = span;
            this.dealer = dealer;


        }

        public Car() {}

    @Override
    public String toString() {
        return "Car{" +
                "carNo=" + carNo +
                ", img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", fuel='" + fuel + '\'' +
                ", km='" + km + '\'' +
                ", price='" + price + '\'' +
                ", span='" + span + '\'' +
                ", dealer='" + dealer + '\'' +
                '}';
    }

    public Long getCarNo() {
        return carNo;
    }

    public void setCarNo(Long carNo) {
        this.carNo = carNo;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSpan() {
        return span;
    }

    public void setSpan(String span) {
        this.span = span;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }
}

