package com.jcjrta.client.services;

import com.jcjrta.client.dto.ClientDTO;
import com.jcjrta.client.entities.Client;
import com.jcjrta.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable){
        Page<Client> clients = repository.findAll(pageable);
        Page<ClientDTO> clientDTOS = clients.map(x -> new ClientDTO(x));
        return clientDTOS;
    }

    @Transactional()
    public ClientDTO insert(ClientDTO dto){
        Client client = new Client();

        client.setName(dto.getName());
        client.setCpf(dto.getCpf());
        client.setIncome(dto.getIncome());
        client.setBirthDate(dto.getBirthDate());
        client.setChildren(dto.getChildren());

        client =  repository.save(client);

        return new ClientDTO(client);
    }
}
