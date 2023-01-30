package com.ProjetsAva.ProjetsAva.service;

import org.springframework.context.annotation.Bean;

import com.ProjetsAva.ProjetsAva.model.Client;


public interface ClientService {
	@Bean
	public Client createClient(Client client);
	public boolean checkEmail(String email);
}