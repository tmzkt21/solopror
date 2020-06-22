package com.example.web.mappers;

import com.example.web.DTO.HelpDTO;
import com.example.web.proxy.Pager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HelpMapper {

    public void insertHelp(HelpDTO helpDTO);
    public void updateHelp(HelpDTO helpDTO);
    public void deleteHelp(HelpDTO helpDTO);
    public List<HelpDTO> selectHelps(Pager pager);
    public HelpDTO selectHelp(String userNo);
    public int count();

}
