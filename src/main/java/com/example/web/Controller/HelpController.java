package com.example.web.Controller;



import com.example.web.mappers.CarMapper;
import com.example.web.mappers.HelpMapper;
import com.example.web.DTO.HelpDTO;
import com.example.web.proxy.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.function.Function;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/help")
public class HelpController {

  @Autowired Proxy proxy;
  @Autowired Box box;
  @Autowired Pager pager;
  @Autowired
  HelpMapper help;
  @Autowired CarMapper carMapper;





//    @GetMapping("/{searchWord}/{pageNumber}")
//    public Map<?,?> list(@PathVariable("pageNumber") String pageNumber,
//                         @PathVariable("searchWord") String searchWord){


    @GetMapping("/{searchWord}/{pageNumber}")
    public Map<?,?> help(@PathVariable("pageNumber") String pageNumber,
                          @PathVariable("searchWord") String searchWord){
        if(searchWord.equals("null")){
            proxy.print("검색어가 없음");
            pager.setSearchWord("");
        }else{
            proxy.print("검색어가 "+searchWord);
            pager.setSearchWord(searchWord);
        }
        proxy.print("넘어온 페이지번호: "+pageNumber);
        pager.setPageNow(proxy.integer(pageNumber));
        pager.setBlockSize(10);
        pager.setPageSize(5010);
        pager.paging();
        Function<Pager, List<HelpDTO>> f = p ->  help.selectHelps(p);
        List<HelpDTO> list = f.apply(pager);
        proxy.print("***********");
        for(HelpDTO m : list){
            proxy.print(m.toString());
        }
        box.clear();
        box.put("pager", pager);
        box.put("list", list);
        return box.get();


    }

}


