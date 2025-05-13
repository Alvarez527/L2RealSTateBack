package com.l2realstate.inmobiliaria.web.controller;

import com.l2realstate.inmobiliaria.domain.State;
import com.l2realstate.inmobiliaria.domain.service.StateService;
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
@RequestMapping("/state")
public class StateController {

    @Autowired
    StateService stateService;


    @GetMapping("/allStates")
    @Operation(summary = "To get all States in database", description = "Gets all States")
    @ApiResponse(responseCode = "200", description = "Ok, Information Found")
    public ResponseEntity<List<State>>  getAllStates(){

        return new ResponseEntity<>(stateService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getState/{stateId}")
    @Operation(summary = "To get an sspecific state", description = "To get an Specific State")
    @ApiResponse(responseCode = "200", description = "Ok, Information Found")
    @ApiResponse(responseCode = "404", description = "Error, information not found")
    public ResponseEntity<State> getState(@Parameter(description = "Id of the State")@PathVariable int stateId){

       return stateService.getStateById(stateId).map( state -> new ResponseEntity<>(state, HttpStatus.OK ))
               .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/createState")
    @Operation(summary = "To create a state", description = "To create an specific state")
    @ApiResponse(responseCode = "201", description = "Created Successfully")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    public ResponseEntity<State> createState(@Parameter(description = "State Object to create")@RequestBody State state){

        try{
            return new ResponseEntity<>(stateService.saveState(state), HttpStatus.CREATED);
        }catch(Exception e){

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @DeleteMapping("/deleteState/{stateId}")
    @Operation(summary = "To delete an State", description = "It deletes an state")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Id of the State not Found")
    public ResponseEntity deleteState(@Parameter(description = "Receives the id of the state to delete")@PathVariable int stateId){

         if (stateService.deleteState(stateId)){

             return new ResponseEntity<>(HttpStatus.OK);
         }else{
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
    }



}
