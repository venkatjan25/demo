package com.example.demo.controller;

import com.example.demo.dto.Details;
import com.example.demo.service.DetailsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/details")
public class DetailsController {


    @Autowired
    private DetailsService detailsService;
    @GetMapping(value = "getUniqueIds")
    public Long getDetails(){
       return detailsService.getDetails();
    }

    @ApiOperation(value = "Update user details", notes = "delete tags based on tag model")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request executed successfully", response = Details.class),
            @ApiResponse(code = 400, message = "Bad Request, missing required fields.", response = String.class),
            @ApiResponse(code = 401, message = "Unauthorized.", response = String.class),
            @ApiResponse(code = 403, message = "Forbidden.", response = String.class),
            @ApiResponse(code = 404, message = "Not Found.", response = String.class),
            @ApiResponse(code = 415, message = "Bad Request, missing required fields.", response = String.class),
            @ApiResponse(code = 429, message = "Bad Request, missing required fields.", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = String.class)})

    @PutMapping(value = "updateUserDetails/{id}")
    public Details updateUserDetails(@PathVariable Integer id, @RequestBody Details details){
        return detailsService.updateUserDetails(id,details);
    }


}
