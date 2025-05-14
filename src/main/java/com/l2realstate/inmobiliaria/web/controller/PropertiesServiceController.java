package com.l2realstate.inmobiliaria.web.controller;


import com.l2realstate.inmobiliaria.domain.PropertiesService;
import com.l2realstate.inmobiliaria.domain.Service;
import com.l2realstate.inmobiliaria.domain.service.PropertiesServiceService;
import com.l2realstate.inmobiliaria.domain.service.ServiceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@RestController
@RequestMapping("/propertiesService")
public class PropertiesServiceController {

    @Autowired
    PropertiesServiceService propertiesServiceService;
    @Autowired
    private ServiceService serviceService;

    @GetMapping("/getAllPropertiesServices")
    @io.swagger.v3.oas.annotations.Operation(summary = "To get All Property-Service relations", description = "It gets all Property-Service relations")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    public ResponseEntity<List<PropertiesService>> getAllPropertiesServices(){
        try{
            return new ResponseEntity<>(propertiesServiceService.getAll(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getAllServicesByProperty/{propertyId}")
    @Operation(summary = "To get a Property-Service Relation", description = "To get a Property-Service Relation")
    @ApiResponse(responseCode = "200", description = "Ok, Information Found")
    @ApiResponse(responseCode = "404", description = "Error, information not found")
    public ResponseEntity<List<Service>> getAllServicesByProperty(@Parameter(description = "Receives the id of the Property-Service Relation to search")@PathVariable int propertyId){

        Optional<List<Integer>> optionalServiceIds = propertiesServiceService.getServicesByProperty(propertyId);

        if(optionalServiceIds.isPresent() && !optionalServiceIds.get().isEmpty()){

                List<Service> servicios = optionalServiceIds.get().stream()
                        .map(serviceId -> serviceService.getServiceById(serviceId))
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList());

            return ResponseEntity.ok(servicios);
        }else{

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createPropertiesService")
    @io.swagger.v3.oas.annotations.Operation(summary = "To create a PropertiesService", description = "To create PropertiesService")
    @ApiResponse(responseCode = "201", description = "Created Successfully")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    public ResponseEntity<PropertiesService> createPropertiesService(@Parameter(description = "PropertiesService Object to create")@RequestBody PropertiesService propertiesService){
        try{
            return new ResponseEntity<>(propertiesServiceService.savePropertyService(propertiesService), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/deletePropertiesService")
    @Operation(summary = "To delete an PropertieService", description = "It deletes an Operation")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Object not Found")
    public ResponseEntity deletePropertiesService(@Parameter(description = "Receives the object Properties Service in Body")@RequestBody PropertiesService propertiesService){

        if(propertiesServiceService.deletePropertyService(propertiesService)){

            return new ResponseEntity(HttpStatus.OK);
        }else{

            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

}
