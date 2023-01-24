package AVAProject.AVA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AVAProject.AVA.model.Client;
import AVAProject.AVA.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepo;

	@Override
	public Client createClient(Client client) {
		
		return clientRepo.save(client);
	}

}
