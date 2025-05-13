package com.l2realstate.inmobiliaria.web.controller;


import com.l2realstate.inmobiliaria.domain.Residential;
import com.l2realstate.inmobiliaria.domain.service.ResidentialService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/residential")
public class ResidentialController {

    @Autowired
    ResidentialService residentialService;

    @RequestMapping("/allResidentials")
    @Operation(summary = "To get All Residentials", description = "It gets all Residentials")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    public ResponseEntity<List<Residential>> getAllResidentials(){

        try{
            return new ResponseEntity<>(residentialService.getAll(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @GetMapping("/getResidentialById/{residentialId}")
    @Operation(summary = "To get an sspecific residential", description = "To get an Specific residential")
    @ApiResponse(responseCode = "200", description = "Ok, Information Found")
    @ApiResponse(responseCode = "404", description = "Error, information not found")
    public ResponseEntity<Residential> getResidentialById(@Parameter(description = "Receives the id of the residential to search")@PathVariable int residentialId){

        return residentialService.getResidentialById(residentialId)
                .map(a -> new ResponseEntity<>(a, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/createResidential")
    @Operation(summary = "To create a Residential", description = "To create Residential")
    @ApiResponse(responseCode = "201", description = "Created Successfully")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    public ResponseEntity<Residential> createResidential(@Parameter(description = "Residential Object to create")@RequestBody Residential residential){
        try{
            return new ResponseEntity<>(residentialService.saveResidential(residential), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/deleteResidential/{residentialId}")
    @Operation(summary = "To delete a Residential", description = "It deletes a Residential")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Id of the Residential not Found")
    public ResponseEntity deleteResidential(@Parameter(description = "Receives the id of the Residential to delete")@PathVariable int residentialId){

        if(residentialService.deleteResidential(residentialId)){

            return new ResponseEntity<>(HttpStatus.OK);
        }else{

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
