package com.l2realstate.inmobiliaria.web.controller;


import com.l2realstate.inmobiliaria.domain.SalesPerson;
import com.l2realstate.inmobiliaria.domain.SalesPersonMessage;
import com.l2realstate.inmobiliaria.domain.service.SalesPersonMessageService;
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
@RequestMapping("/salesPersonMessages")
public class SalesPersonMessageController {

@Autowired
SalesPersonMessageService salesPersonMessageService;

@GetMapping("/allSalesPersonMessages")
@Operation(summary = "To get All Sales Person Messages", description = "It gets all Sales Person Messages")
@ApiResponse(responseCode = "200", description = "OK")
@ApiResponse(responseCode = "500", description = "Internal Server Error")
    public ResponseEntity<List<SalesPersonMessage>> getAll(){

    try{
        return new ResponseEntity<>(salesPersonMessageService.getAll(), HttpStatus.OK);
    }catch(Exception e){

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


}

@GetMapping("/getSalesPersonMessageById/{idSalesPersonMessage}")
@Operation(summary = "To get SalesPerson Messages by Id", description = "It gets SalesPerson Messages by Id")
@ApiResponse(responseCode = "200", description = "OK")
@ApiResponse(responseCode = "404", description = "Not Found")
    public ResponseEntity<SalesPersonMessage> getSalesPersonMessage(@Parameter(description = "Sales Person Message Id")@PathVariable int idSalesPersonMessage){

    return salesPersonMessageService.salesPersonMessage(idSalesPersonMessage)
            .map(salesPersonMessage -> new ResponseEntity<>(salesPersonMessage, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
}

@GetMapping("/getByOperation/{operationId}")
@Operation(summary = "To get an sspecific SalesPerson Message", description = "To get an Specific SalesPerson Message")
@ApiResponse(responseCode = "200", description = "Ok, Information Found")
@ApiResponse(responseCode = "204", description = "No Content Available")
@ApiResponse(responseCode = "404", description = "Error, information not found")
    public ResponseEntity<List<SalesPersonMessage>> getByOperation(@Parameter(description = "Receives the id of the SalesPerson Message to search")@PathVariable int operationId){

        if (salesPersonMessageService.getByOperation(operationId).isPresent()){

            List<SalesPersonMessage> resultado = salesPersonMessageService.getByOperation(operationId).get();

            if( resultado.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else{

                return new ResponseEntity<>(resultado, HttpStatus.OK);
            }

        }else{

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
}

@PostMapping("/createSalesPersonMessage")
@Operation(summary = "To create a SalesPersonMessage", description = "To create SalesPersonMessage")
@ApiResponse(responseCode = "201", description = "Created Successfully")
@ApiResponse(responseCode = "500", description = "Internal Server Error")
    public ResponseEntity<SalesPersonMessage> saveSalesPersonMessage(@Parameter(description = "Sales Person Message Object to create")@RequestBody SalesPersonMessage salesPersonMessage){
    try{

        return new ResponseEntity<>(salesPersonMessageService.saveSalesPersonMessage(salesPersonMessage), HttpStatus.CREATED);

    }catch(Exception e){

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

@DeleteMapping("/deleteSalesPersonMessage/{idSalesPersonMessage}")
@Operation(summary = "To delete an SalesPersonMessage", description = "It deletes a SalesPersonMessage")
@ApiResponse(responseCode = "200", description = "OK")
@ApiResponse(responseCode = "404", description = "Id of the SalesPersonMessage not Found")
    public ResponseEntity deleteSalesPersonMessage(@Parameter(description = "Receives the id of the SalesPersonMessage to delete")@PathVariable int idSalesPersonMessage){

        if(salesPersonMessageService.deleteSalesPersonMessage(idSalesPersonMessage)){

            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
}

}
