package com.l2realstate.inmobiliaria.web.controller;


import com.l2realstate.inmobiliaria.domain.Customer;
import com.l2realstate.inmobiliaria.domain.service.CustomerService;
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
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/allCustomers")
    @io.swagger.v3.oas.annotations.Operation(summary = "To get All Customers", description = "It gets all Customers")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    public ResponseEntity<List<Customer>> getAll(){
        try{
            return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getCustomerById/{idCustomer}")
    @Operation(summary = "To get an sspecific operation", description = "To get an Specific operation")
    @ApiResponse(responseCode = "200", description = "Ok, Information Found")
    @ApiResponse(responseCode = "404", description = "Error, information not found")
    public ResponseEntity<Customer> getCustomer(@Parameter(description = "Receives the id of the operation to search")@PathVariable int idCustomer){

        return  customerService.getCustomerById(idCustomer)
                .map(a -> new ResponseEntity<>(a, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/createCustomer")
    @io.swagger.v3.oas.annotations.Operation(summary = "To create a Customer", description = "To create a Customer")
    @ApiResponse(responseCode = "201", description = "Created Successfully")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    public ResponseEntity<Customer> createCustomer(@Parameter(description = "Receives the customer object")@RequestBody Customer customer){
        try{
            return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @DeleteMapping("/deleteCustomer/{customerId}")
    @io.swagger.v3.oas.annotations.Operation(summary = "To delete a Customer", description = "To delete a Customer")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Object not Found")
    public ResponseEntity deleteCustomer(@Parameter(description = "Receives the customer Id")@PathVariable int customerId){

        if(customerService.DeleteCustomer(customerId)){

            return new ResponseEntity<>(HttpStatus.OK);
        }else{

            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


}
