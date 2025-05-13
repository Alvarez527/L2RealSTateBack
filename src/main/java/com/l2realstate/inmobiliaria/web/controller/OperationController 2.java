package com.l2realstate.inmobiliaria.web.controller;


import com.l2realstate.inmobiliaria.domain.ClientMessage;
import com.l2realstate.inmobiliaria.domain.Operation;
import com.l2realstate.inmobiliaria.domain.Property;
import com.l2realstate.inmobiliaria.domain.service.OperationService;
import com.l2realstate.inmobiliaria.domain.service.PropertyService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/operations")
public class OperationController {

    @Autowired
    OperationService operationService;
    @GetMapping("/getAllOperations")
    @io.swagger.v3.oas.annotations.Operation(summary = "To get All Operations", description = "It gets all Operations")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    public ResponseEntity<List<Operation>> getAll(){
        try{
            return new ResponseEntity<>(operationService.getAll(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getOperationById/{operationId}")
    @io.swagger.v3.oas.annotations.Operation(summary = "To get an specific operation", description = "To get an Specific operation")
    @ApiResponse(responseCode = "200", description = "Ok, Information Found")
    @ApiResponse(responseCode = "404", description = "Error, information not found")
    public ResponseEntity<Operation> getOperation(@Parameter(description = "Receives the id of the operation to search")@PathVariable int operationId){

        return operationService.getOperationById(operationId)
                .map( a -> new ResponseEntity<>(a, HttpStatus.OK))
                .orElse( new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/createOperation")
    @io.swagger.v3.oas.annotations.Operation(summary = "To create a Operation", description = "To create Operation")
    @ApiResponse(responseCode = "201", description = "Created Successfully")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    public ResponseEntity<Operation> saveOperation(@Parameter(description = "Operation Object to create")@RequestBody Operation operation){
        try{
            return new ResponseEntity<>(operationService.saveOperation(operation), HttpStatus.CREATED);
        }catch(Exception e){

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/deleteOperation/{operationId}")
    @io.swagger.v3.oas.annotations.Operation(summary = "To delete a Operation", description = "It deletes an Operation")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Object not Found")
    public ResponseEntity deleteOperation(@Parameter(description = "Receives the operation Id")@PathVariable int operationId){

        if(operationService.deleteOperation(operationId)){

            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
