package com.ProjetsAva.ProjetsAva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetsAva.ProjetsAva.model.Client;
import com.ProjetsAva.ProjetsAva.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepo;

	@Override
	public Client createClient(Client client) {
		return clientRepo.save(client);
	}

	@Override
	public boolean checkEmail(String email) {
		return clientRepo.existsByEmail(email);
	}
	/*
	@Autowired
	private ClientRepository clientRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncode;
	
	//@Override
	public Client createClient(Client client) {

		client.setMotPasse(passwordEncode.encode(client.getMotPasse()));
		client.setRole("ROLE_USER");

		return clientRepo.save(client);
	}
	

	//@Override
	public boolean checkEmail(String email) {
		return clientRepo.existsByEmail(email);
	}
*/
}