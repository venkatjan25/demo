package com.example.demo.service;

import com.example.demo.dao.DetailsDAO;
import com.example.demo.dto.Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DetailsService {

    @Autowired
    private DetailsDAO detailsDAO;
    public Long getDetails(){
        return detailsDAO.getDetails();
    }
    public Details updateUserDetails(Integer id ,Details details){
       return detailsDAO.updateUserDetails(id,details);
    }
}
