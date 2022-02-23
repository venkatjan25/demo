package com.example.demo.service;

import com.example.demo.dto.Details;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class DetailsServiceTest extends TestCase {

    @Autowired
    private DetailsService detailsService;

    @Test
    public void countUserIdTest(){
        Long totalRecords = detailsService.getDetails();
        assertTrue(totalRecords>0);
    }
    @Test
    public void updateTitle(){
        Details details = detailsService.getUpdatedDetails();
        assertNotNull(details);
    }
}
