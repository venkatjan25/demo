package com.example.demo.daoimpl;

import com.example.demo.dao.DetailsDAO;
import com.example.demo.dto.Details;
import com.example.demo.util.DemoConstants;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class DetailsDAOImpl implements DetailsDAO {


    public Long getDetails(){
        ResponseEntity<Details[]> entity = new RestTemplate().getForEntity(DemoConstants.BASE_URI, Details[].class);
        List<Integer> detailsList =  Arrays.stream(entity.getBody()).map(d->d.getUserId()).collect(Collectors.toList());
        return detailsList.stream().distinct().count();

    }

    public Details updateUserDetails(Integer id, Details details){
        try{
            Map<String,Integer> map = new HashMap();
            map.put("id",id);
            ResponseEntity<Details> exchange = new RestTemplate().exchange(DemoConstants.UPDATE_URI, HttpMethod.PUT, new HttpEntity<Details>(details), Details.class,map);
            return exchange.getBody();
        }catch (Exception e){
            System.out.println("Exception is occured while updating the index:"+e.getMessage());
        }
        return new Details();
    }
}
