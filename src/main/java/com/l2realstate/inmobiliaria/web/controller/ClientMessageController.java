package com.l2realstate.inmobiliaria.web.controller;

import com.l2realstate.inmobiliaria.domain.ClientMessage;
import com.l2realstate.inmobiliaria.domain.service.ClientMessageService;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("/clientMessages")
public class ClientMessageController {

    @Autowired
    ClientMessageService clientMessageService;

    @GetMapping("/allClientMessages")
    @io.swagger.v3.oas.annotations.Operation(summary = "To get All Client Messages", description = "It gets all Client Messages")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    public ResponseEntity<List<ClientMessage>> getAll(){
        try{
            return new ResponseEntity<>(clientMessageService.getAll(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getClientMessage/{idClientMessage}")
    @Operation(summary = "To get an specific Customer", description = "To get an Specific Customer")
    @ApiResponse(responseCode = "200", description = "Ok, Information Found")
    @ApiResponse(responseCode = "404", description = "Error, information not found")
    public ResponseEntity<ClientMessage> getClientMessage(@Parameter(description = "Receives the id of the Customer to search")@PathVariable int idClientMessage){

        return clientMessageService.getClientMessage(idClientMessage)
                .map( a-> new ResponseEntity<>(a, HttpStatus.OK))
                .orElse( new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @GetMapping("/getByOperation/{operationId}")
    @Operation(summary = "To get an sspecific Client Message", description = "To get an Specific Client Message")
    @ApiResponse(responseCode = "200", description = "Ok, Information Found")
    @ApiResponse(responseCode = "204", description = "No Content Available")
    @ApiResponse(responseCode = "404", description = "Error, information not found")
    public ResponseEntity<List<ClientMessage>> getByOperation(@Parameter(description = "Receives the id of the Client-Message to search")@PathVariable int operationId){

        if(clientMessageService.getMessagesByOperation(operationId).isPresent()){

            List<ClientMessage> resultado = clientMessageService.getMessagesByOperation(operationId).get();

            if(resultado.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else{

                return new ResponseEntity<>(resultado, HttpStatus.OK);
            }

        }else{

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createClientMessage")
    @io.swagger.v3.oas.annotations.Operation(summary = "To create a Client Message", description = "To create a Client Message")
    @ApiResponse(responseCode = "201", description = "Created Successfully")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    public ResponseEntity<ClientMessage> saveClientMessage(@Parameter(description = "Receives the Client Message object")@RequestBody ClientMessage clientMessage){

        try{
            return new ResponseEntity<>(clientMessageService.saveMessage(clientMessage), HttpStatus.CREATED);
        }catch(Exception e){

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/deleteClientMessage/{idClientMessage}")
    @io.swagger.v3.oas.annotations.Operation(summary = "To delete a ClientMessage", description = "To delete a ClientMessage")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Client Message not Found")
    public ResponseEntity deleteClientMessage(@Parameter(description = "Receives the clientMessaeg Id")@PathVariable int idClientMessage){

         if(clientMessageService.deleteMessage(idClientMessage)){

             return new ResponseEntity(HttpStatus.OK);
         }else{

             return new ResponseEntity(HttpStatus.NOT_FOUND);
         }

    }

}
