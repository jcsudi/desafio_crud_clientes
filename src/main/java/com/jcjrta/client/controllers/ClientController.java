package com.jcjrta.client.controllers;

import com.jcjrta.client.dto.ClientDTO;
import com.jcjrta.client.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findById (@PathVariable Long id){
        ClientDTO dto = service.findById(id);
        return ResponseEntity.ok(dto) ;
    }

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> findAll(Pageable pageable){
        Page<ClientDTO> clientDTOS = service.findAll(pageable);
        return ResponseEntity.ok( clientDTOS);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> dto(@Valid @RequestBody ClientDTO dto){
        dto =  service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> delete(@PathVariable Long id, @Valid @RequestBody ClientDTO dto){
        ClientDTO dto1 = service.update(dto, id);
        return ResponseEntity.ok(dto1);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
