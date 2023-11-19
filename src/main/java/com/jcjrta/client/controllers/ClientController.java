package com.jcjrta.client.controllers;

import com.jcjrta.client.dto.ClientDTO;
import com.jcjrta.client.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping(value = "/{id}")
    public ClientDTO findById (@PathVariable Long id){
        ClientDTO dto = service.findById(id);
        return dto;
    }
}
