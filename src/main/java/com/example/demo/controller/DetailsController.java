package com.example.demo.controller;

import com.example.demo.dto.Details;
import com.example.demo.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/details")
public class DetailsController {


    @Autowired
    private DetailsService detailsService;

    @GetMapping(value = "getUniqueIds")
    public Long getDetails(){
       return detailsService.getDetails();
    }

    @PutMapping(value = "getUpdateTitleUniqueIds")
    public Details getUpdatedDetails(){
        return detailsService.getUpdatedDetails();
    }

}
