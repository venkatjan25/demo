package com.example.demo.service;

import com.example.demo.daoimpl.DetailsDAOImpl;
import com.example.demo.dto.Details;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.MockitoAnnotations.initMocks;
@RunWith(MockitoJUnitRunner.class)
public class DetailsServiceTest {

    @InjectMocks
    private DetailsService detailsService;
    @Mock
    DetailsDAOImpl dao;

    @Before
    public void init() {
        initMocks(this);
    }
    @Test
    public void countUserIdTest(){

        Long count = 10L;
        when(dao.getDetails()).thenReturn(count);

        Long totalRecords = detailsService.getDetails();
        Assert.assertEquals(count,totalRecords);
    }
    @Test
    public void updateTitle(){
        Details d = new Details();
        d.setTitle("1800floweres");
        d.setBody("1800floweres");
        d.setId(4);
        when(dao.updateUserDetails(4,d)).thenReturn(d);
        Details details = detailsService.updateUserDetails(4,d);
        Assert.assertEquals(d,details);
    }
}
