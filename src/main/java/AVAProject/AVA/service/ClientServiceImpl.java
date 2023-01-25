package AVAProject.AVA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import AVAProject.AVA.model.Client;
import AVAProject.AVA.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncode;
	
	@Override
	public Client createClient(Client client) {

		client.setMotPasse(passwordEncode.encode(client.getMotPasse()));
		client.setRole("ROLE_USER");

		return clientRepo.save(client);
	}
	

	@Override
	public boolean checkEmail(String email) {
		return clientRepo.existsByEmail(email);
	}

}