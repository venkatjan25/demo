package com.example.demo.controller;

import com.example.demo.dto.Details;
import com.example.demo.service.DetailsService;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.when;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.MockitoAnnotations.initMocks;
@RunWith(MockitoJUnitRunner.class)
public class DetailsControllerTest {

    @InjectMocks
    private DetailsController detailsController;
    @Mock
    private DetailsService detailsService;

    @Before
    public void init() {
        initMocks(this);
    }
    @Test
    public void countUserIdTest(){
        Long count = 10L;
        when(detailsService.getDetails()).thenReturn(count);
        Long totalRecords = detailsController.getDetails();
        Assert.assertEquals(count,totalRecords);
    }


    @Test
    public void updateTitle(){
        Details d = new Details();
        d.setTitle("1800floweres");
        d.setBody("1800floweres");

        when(detailsService.updateUserDetails(4,d)).thenReturn(d);
        Details details = detailsController.updateUserDetails(4,d);
        Assert.assertEquals(d,details);
    }
}
