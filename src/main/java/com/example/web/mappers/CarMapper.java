package com.example.web.mappers;

import com.example.web.DTO.CarDTO;
import com.example.web.DTO.HelpDTO;
import com.example.web.proxy.Pager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarMapper {

    public void insertCar(CarDTO carDTO);
    public void updateCar(CarDTO carDTO);
    public void deleteCar(CarDTO carDTO);
    public List<CarDTO> selectCars(Pager pager);
    public CarDTO selectCar(String carNo);
    public int count();

}
