package com.example.web.proxy;


import com.example.web.Entity.Help;
import com.example.web.music.RankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


@Service("uploader") @Lazy
public class FileUploader extends Proxy{
    @Autowired Inventory<String> inventory;
    @Autowired
    RankRepository rankRepository;

    // C:\Users\bit19\IdeaProjects\help\src\main\resources\static\files\롤랭킹.csv
    // "C:\\Users\\bit19\\IdeaProjects\\help\\src\\main\\resources\\static\\files\\롤랭킹.csv"
    public void upload(){
        inventory.clear();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\bit19\\IdeaProjects\\help\\src\\main\\resources\\static\\files\\롤랭킹.csv")));
            String help = "";
            while((help = reader.readLine()) != null){
                inventory.add(help);
            }
        }catch(Exception e){
            print("파일 리딩 에러");
            e.printStackTrace();
        }
        print("--------------------------------------\n");
        print(inventory.get().get(0).toString());
        String[] arr = inventory.get().get(0).toString().split(",");
        // "2000003","유동우","K10","YOU,  DONGWOO","","","DF","40","","07-MAR-1978","1","177","70"
        Help help =new Help();
        help.setRank(arr[0]);
        help.setUser(arr[1]);
        help.setTear(arr[2]);
        help.setPoint(arr[3]);
        help.setLevel(arr[4]);
        help.setWins(arr[5]);
        print("***************************\n");
        print(help.toString());
        rankRepository.save(help);



    }
}