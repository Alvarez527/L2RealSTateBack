package com.l2realstate.inmobiliaria.web.controller;


import com.l2realstate.inmobiliaria.domain.Operation;
import com.l2realstate.inmobiliaria.domain.Property;
import com.l2realstate.inmobiliaria.domain.PropertiesService;
import com.l2realstate.inmobiliaria.domain.service.PropertyService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @GetMapping("/getProperties")
    @io.swagger.v3.oas.annotations.Operation(summary = "To get All properties", description = "It gets all properties")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    public ResponseEntity<List<Property>> getAll(){
        try{
            return new ResponseEntity<>(propertyService.getAll(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getPropertyById/{propertyId}")
    @io.swagger.v3.oas.annotations.Operation(summary = "To get an specific Property", description = "To get an Specific Property")
    @ApiResponse(responseCode = "200", description = "Ok, Information Found")
    @ApiResponse(responseCode = "404", description = "Error, information not found")
    public ResponseEntity<Property> getPropertyById(@Parameter(description = "Receives the id of the Property to search")@PathVariable int propertyId){

        return propertyService.getPropertyById(propertyId)
                .map(a -> new ResponseEntity<>(a, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getOperations/{propertyId}")
    @io.swagger.v3.oas.annotations.Operation(summary = "To get operations of a property", description = "To get operations of a property")
    @ApiResponse(responseCode = "200", description = "Ok, Information Found")
    @ApiResponse(responseCode = "404", description = "Error, information not found")
    public ResponseEntity<List<Operation>> getOperations(@Parameter(description = "Receives the id of the property to search")@PathVariable int propertyId){

        return new ResponseEntity<>(propertyService.getOperations(propertyId), HttpStatus.OK) ;
    }

    @PostMapping("/saveProperty")
    @io.swagger.v3.oas.annotations.Operation(summary = "To create a Property", description = "To create Property")
    @ApiResponse(responseCode = "201", description = "Created Successfully")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    public ResponseEntity<Property> saveProperty(@Parameter(description = "Property Object to create")@RequestBody Property property){
        try{
            return new ResponseEntity<>(propertyService.saveProperty(property), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/deleteProperty/{propertyId}")
    @io.swagger.v3.oas.annotations.Operation(summary = "To delete an Operation", description = "It deletes an Operation")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Id of the Operation not Found")
    public ResponseEntity deleteProperty(@Parameter(description = "Receives the id of the Operation to delete")@PathVariable int propertyId){

        if (propertyService.deleteProperty(propertyId)){

            return new ResponseEntity(HttpStatus.OK);
        }else{

            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }


}
