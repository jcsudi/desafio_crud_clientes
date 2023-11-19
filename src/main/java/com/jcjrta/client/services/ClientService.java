package com.jcjrta.client.services;

import com.jcjrta.client.dto.ClientDTO;
import com.jcjrta.client.entities.Client;
import com.jcjrta.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository repository;

    @Transactional(readOnly = true)
    public ClientDTO findById (Long id){
        Optional<Client> result = repository.findById(id);
        Client c = result.get();
        ClientDTO dto = new ClientDTO(c);
        return dto;
    }
}