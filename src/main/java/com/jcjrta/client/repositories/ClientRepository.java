package com.jcjrta.client.repositories;

import com.jcjrta.client.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long>{
}
