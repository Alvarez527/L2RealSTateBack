package com.l2realstate.inmobiliaria.web.controller;

import com.l2realstate.inmobiliaria.domain.SalesPerson;
import com.l2realstate.inmobiliaria.domain.service.SalesPersonService;
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
@RequestMapping("/salesPerson")
public class SalesPersonController {

    @Autowired
    SalesPersonService salesPersonService;

    @GetMapping("/allSalesPerson")
    @Operation(summary = "To get All Sales Person", description = "It gets all Sales Person")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    public ResponseEntity<List<SalesPerson>> getAll(){
        try{
            return new ResponseEntity<>(salesPersonService.getAll(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getSalesPersonById/{salesPersonId}")
    @Operation(summary = "To get an specific Sales Person", description = "To get an Specific Sales Person")
    @ApiResponse(responseCode = "200", description = "Ok, Information Found")
    @ApiResponse(responseCode = "404", description = "Error, information not found")
    public ResponseEntity<SalesPerson> getSalesPersonById(@Parameter(description = "Receives the id of the Sales Person to search")@PathVariable int salesPersonId){

           return salesPersonService.getSalesPersonById(salesPersonId)
                    .map(salesPerson -> new ResponseEntity<>(salesPerson, HttpStatus.OK) )
                   .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/createSalesPerson")
    @Operation(summary = "To create a Sales Person", description = "To create Sales Person")
    @ApiResponse(responseCode = "201", description = "Created Successfully")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    public ResponseEntity<SalesPerson> createSalesPerson(@Parameter(description = "Sales Person  Object to create")@RequestBody SalesPerson salesPerson){
        try{
            return new ResponseEntity<>(salesPersonService.saveSalesPerson(salesPerson), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/deleteSalesPerson/{salesPersonId}")
    @Operation(summary = "To delete a Sales Person", description = "It deletes a SalesPerson")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Id of the SalesPerson not Found")
    public ResponseEntity deleteSalesPerson(@Parameter(description = "Receives the id of the SalesPerson to delete")@PathVariable int salesPersonId){

        if (salesPersonService.deleteSalesPerson(salesPersonId)){

            return new ResponseEntity<>(HttpStatus.OK);
        }else{

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
