package com.ProjetsAva.ProjetsAva.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetsAva.ProjetsAva.model.Client;



public interface ClientRepository extends JpaRepository<Client, Integer>{
	
	public boolean existsByEmail(String email);
	
	public Client findByEmail(String email);
}
