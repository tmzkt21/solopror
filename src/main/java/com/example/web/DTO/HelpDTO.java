package com.example.web.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class HelpDTO {
    private String userNo,rank,user,tear,point,level,wins;
}
