package AVAProject.AVA.service;

//import org.springframework.context.annotation.Bean;

import AVAProject.AVA.model.Client;

public interface ClientService {
	//@Bean
	public Client createClient(Client client);
	public boolean checkEmail(String email);
}
