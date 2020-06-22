package com.example.web.Controller;


import com.example.web.mappers.CarMapper;
import com.example.web.mappers.HelpMapper;
import com.example.web.Entity.Car;
import com.example.web.DTO.CarDTO;
import com.example.web.music.CarRepository;
import com.example.web.proxy.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@RestController
@RequestMapping("/car")
    public class CarController {
        @Autowired
        Box<Object> box;
        @Autowired
        Crawler crawler;
        @Autowired
        FileUploader fileUploader;
        @Autowired
        Proxy proxy;
        @Autowired
        CarRepository carRepository;
        @Autowired
        Pager pager;
        @Autowired
        HelpMapper help;
        @Autowired
    CarMapper carMapper;
    @GetMapping("/{searchWord}/{pageNumber}")
    public Map<?,?> cars(@PathVariable("searchWord") String searchWord,
                         @PathVariable("pageNumber") String pageNumber){
        if(searchWord.equals("null")){
            proxy.print("검색어가 없음");
            pager.setSearchWord("");
        }else{
            proxy.print("검색어가 "+searchWord);
            pager.setSearchWord(searchWord);
        }
        proxy.print("넘어온 페이지번호: "+pageNumber);
        pager.setPageNow(proxy.integer(pageNumber));
        pager.setBlockSize(25);
        pager.setPageSize(25);
        pager.paging();

        Function<Pager, List<CarDTO>> f = p ->  carMapper.selectCars(p);
        List<CarDTO> list = f.apply(pager);
        proxy.print("***********");
        for(CarDTO m : list){
            proxy.print(m.toString());
        }
        box.clear();
        box.put("pager", pager);
        box.put("list", list);
        return box.get();
    }
        @GetMapping("/car/list")
        public List<Car> findCar(){
            System.out.println("자바들어옴");

//            if(carRepository.count()==0){crawler.carlist();}
            crawler.carlist();
            return carRepository.findAll();
        }






    }











