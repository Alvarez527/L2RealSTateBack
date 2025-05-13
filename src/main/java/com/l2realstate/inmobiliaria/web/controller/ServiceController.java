package com.l2realstate.inmobiliaria.web.controller;

import com.l2realstate.inmobiliaria.domain.Service;
import com.l2realstate.inmobiliaria.domain.service.ServiceService;
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
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    ServiceService serviceService;

    @GetMapping("/getAllServices")
    @Operation(summary = "To get All Services", description = "It gets all services")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<List<Service>> getAllServices(){

        return new ResponseEntity<>(serviceService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getServiceById/{serviceId}")
    @Operation(summary = "To get specific service by Id", description = "It gets an specific service")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Id of the Service not Found")
    public ResponseEntity<Service> getServiceById(@Parameter(description = "Receives the id of the service to search")@PathVariable int serviceId){

        return serviceService.getServiceById(serviceId).map(service -> new ResponseEntity<>(service, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/createService")
    @Operation(summary = "To create a Service", description = "It creates a service")
    @ApiResponse(responseCode = "201", description = "Created")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    public ResponseEntity<Service> createService(@Parameter(description = "Service Object to create")@RequestBody Service service){
        try {
            return new ResponseEntity<>(serviceService.saveService(service), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteService/{serviceId}")
    @Operation(summary = "To delete an Service", description = "It deletes a service")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Id of the Service not Found")
    public ResponseEntity deleteService(@Parameter(description = "Receives the id of the service to delete")@PathVariable int serviceId){

        if(serviceService.deleteService(serviceId)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
