package com.example.web.proxy;


import com.example.web.Entity.Car;
import com.example.web.music.CarRepository;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Crawler {
    @Autowired CarRepository carRepository;
    public void carlist() {
        System.out.println("크롤링시작");
        for(int j=1;j<21;j++){
            try {
                String url = "https://www.bobaedream.co.kr/mycar/mycar_list.php?gubun=I&page="+j+"&order=S11&view_size=70";
                Connection.Response homepage = Jsoup.connect(url).method(Connection.Method.GET)
                        .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36\"")
                        .execute();
                Document d = homepage.parse();
                Elements img = d.select("a.img.w164");
                Elements name = d.select("p.tit>a");
                Elements year = d.select("div.mode-cell.year>span");
                Elements fuel = d.select("div.mode-cell.fuel>span");
                Elements km = d.select("div.mode-cell.km>span");
                Elements price = d.select("div.mode-cell.price");
                Elements span = d.select("div.seller-content>ul>li");
                Elements dealer = d.select("div.seller-name>a>span");

                System.out.println("이미지: " + img.get(0));
                System.out.println("이름: " + name.get(0));
                System.out.println("년도: " + year.get(0));
                System.out.println("연료: " + fuel.get(0));
                System.out.println("키로: " + km.get(0));
                System.out.println("가격: " + price.get(0));
                System.out.println("지역: " + span.get(0));
                System.out.println("딜러이름: " + dealer.get(0));

                Car car = null;
                for (int i = 0; i < name.size(); i++) {
                    car = new Car();
                    car.setImg(name.get(i).text());
                    car.setName(name.get(i).text());
                    car.setYear(year.get(i).text());
                    car.setFuel(fuel.get(i).text());
                    car.setKm(km.get(i).text());
                    car.setPrice(price.get(i).text());
                    car.setSpan(span.get(i).text());
                    car.setDealer(span.get(i).text());
                    carRepository.save(car);
                    if(price.get(i).text()!=null) {
                        car.setPrice(price.get(i).text());
                    }else{
                        car.setPrice("상담후결정");
                    }
                    carRepository.save(car);
                }
            } catch (Exception e) {
                System.out.println("에러발생 : " + e);
            }
        }

    }
}
