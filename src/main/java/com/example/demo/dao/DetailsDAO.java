package com.example.demo.dao;

import com.example.demo.dto.Details;


public interface DetailsDAO {
    public Long getDetails();
    public Details updateUserDetails(Integer id,Details details);
}
