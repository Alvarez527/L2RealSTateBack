package com.l2realstate.inmobiliaria.web.controller;

import com.l2realstate.inmobiliaria.domain.City;
import com.l2realstate.inmobiliaria.domain.Residential;
import com.l2realstate.inmobiliaria.domain.service.CityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    CityService cityService;

    @GetMapping("/allCities")
    @io.swagger.v3.oas.annotations.Operation(summary = "To get All Cities", description = "It gets all Cities")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    public ResponseEntity<List<City>> getAllCities(){
        try{
            return new ResponseEntity<>(cityService.getAll(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getCityById/{cityId}")
    @Operation(summary = "To get an sspecific city", description = "To get an Specific city")
    @ApiResponse(responseCode = "200", description = "Ok, Information Found")
    @ApiResponse(responseCode = "404", description = "Error, information not found")
    public ResponseEntity<City> getCity(@Parameter(description = "Receives the id of the city to search")@PathVariable int cityId){

        return cityService.getCity(cityId)
                .map(a-> new ResponseEntity<>(a,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/createCity")
    @io.swagger.v3.oas.annotations.Operation(summary = "To create a City", description = "To create a City")
    @ApiResponse(responseCode = "201", description = "Created Successfully")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    public ResponseEntity<City> createCity(@Parameter(description = "Receives the City object")@RequestBody City city){

        try{
            return new ResponseEntity<>(cityService.saveCity(city), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @DeleteMapping("/deleteCity/{cityId}")
    @io.swagger.v3.oas.annotations.Operation(summary = "To delete a City", description = "To delete a City")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "City  not Found")
    public ResponseEntity deleteCity(@Parameter(description = "Receives the City Id")@PathVariable int cityId){

         if(cityService.deleteCity(cityId)){

             return new ResponseEntity<>(HttpStatus.OK);
         }else{

             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
    }


}
