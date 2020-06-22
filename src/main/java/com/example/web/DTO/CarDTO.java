package com.example.web.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CarDTO {
    private String carNo,img,name,year,fuel,km,price,span;
}
