package AVAProject.AVA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import AVAProject.AVA.model.Client;
import AVAProject.AVA.service.ClientService;

@Controller
public class HomeController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@PostMapping("/createClient")
	public String createClient(@ModelAttribute Client client) {
		
		//System.out.println(client);
		Client clientDtls = clientService.createClient(client);
		if(clientDtls != null) {
			System.out.println("Registerd successfully 2");
		}else {
			System.out.println("Error");
		}
		//clientService.save(client);
		
		return "login";
	}
	

}
